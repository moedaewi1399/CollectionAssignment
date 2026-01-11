package org.example.jdbc.dao;

import org.example.jdbc.model.Student;
import org.example.jdbc.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    @Override
    public void addStudent(Student student) {
        String sql =
                "INSERT INTO student(name, email, age) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());

            ps.executeUpdate();
            System.out.println("Student added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                );
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        Student s = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void updateStudent(Student student) {
        String sql =
                "UPDATE student SET name=?, email=?, age=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setInt(4, student.getId());

            ps.executeUpdate();
            System.out.println("Student updated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

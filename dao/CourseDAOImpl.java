package org.example.jdbc.dao;

import org.example.jdbc.model.Course;
import org.example.jdbc.model.Student;
import org.example.jdbc.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public void addCourse(Course course) {
        String sql = "INSERT INTO course(name, fee) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getName());
            ps.setDouble(2, course.getFee());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM course";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("fee")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Course getCourseById(int id) {
        String sql="SELECT * From course where id= ?";
        Course c=null;
        try(Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("fee"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;

    }

    @Override
    public void updateCourse(Course course) {
        String sql="UPDATE course SET name=? , fee=? where id= ? ";
        try(Connection con = DBConnection.getConnection();
        PreparedStatement  ps = con.prepareStatement(sql)){
            ps.setString(1,course.getName());
            ps.setDouble(2,course.getFee());
            ps.setInt(3,course.getId());
            ps.executeUpdate();
            System.out.println("Course Updated Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(int id) {
        String sql = "DELETE From course Where id=?";
        try(Connection con = DBConnection.getConnection();
        PreparedStatement ps= con.prepareStatement(sql);){
            ps.setInt(1,id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package org.example.jdbc.dao;

import org.example.jdbc.model.Enrollment;
import org.example.jdbc.model.StudentCourseDTO;
import org.example.jdbc.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {

    @Override
    public void enrollStudent(Enrollment enrollment) {
        String sql =
                "INSERT INTO enrollment(student_id, course_id, enroll_date) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, enrollment.getStudentId());
            ps.setInt(2, enrollment.getCourseId());
            ps.setDate(3, Date.valueOf(enrollment.getEnrollDate()));

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // JOIN QUERY
    @Override
    public List<StudentCourseDTO> getStudentCourseDetails() {

        List<StudentCourseDTO> list = new ArrayList<>();

        String sql = """
            SELECT s.name AS student_name,
                   c.name AS course_name,
                   c.fee  AS course_fee
            FROM student s
            JOIN enrollment e ON s.id = e.student_id
            JOIN course c ON e.course_id = c.id
            """;


        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new StudentCourseDTO(
                        rs.getString("student_name"),
                        rs.getString("course_name"),
                        rs.getDouble("course_fee")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<StudentCourseDTO> total(){
        List<StudentCourseDTO> list = new ArrayList<>();
        String sql = """
                 select e.course_id,c.name as course_name,
                  sum(c.fee) as total_fee,
                   count(student_id) total_student from enrollment e
                    left join course c on e.course_id= c.id group by e.course_id;
                """;
        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                list.add(new StudentCourseDTO(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getDouble("total_fee"),
                        rs.getInt("total_student")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
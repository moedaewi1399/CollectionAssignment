package org.example.jdbc.dao;

import org.example.jdbc.model.Enrollment;
import org.example.jdbc.model.StudentCourseDTO;

import java.util.List;

public interface EnrollmentDAO {

    void enrollStudent(Enrollment enrollment);
    List<StudentCourseDTO> getStudentCourseDetails();
    List<StudentCourseDTO> total();
}


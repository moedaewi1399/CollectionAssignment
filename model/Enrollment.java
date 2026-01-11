package org.example.jdbc.model;

import java.time.LocalDate;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollDate;

    public Enrollment() {}

    public Enrollment(int studentId, int courseId, LocalDate enrollDate) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollDate = enrollDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }
}

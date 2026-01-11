package org.example.jdbc.model;

public class StudentCourseDTO {

    private String studentName;
    private String courseName;
    private double courseFee;
    private int courseId;
    private double totalFee;
    private int totalStudent;

    public StudentCourseDTO(String studentName, String courseName, double courseFee) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.courseFee = courseFee;
    }


    public StudentCourseDTO(int courseId, String courseName, double totalFee, int totalStudent) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.totalFee = totalFee;
        this.totalStudent = totalStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }
}

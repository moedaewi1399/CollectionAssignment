package org.example.jdbc;

import org.example.jdbc.dao.*;
import org.example.jdbc.model.Course;
import org.example.jdbc.model.Enrollment;
import org.example.jdbc.model.Student;
import org.example.jdbc.model.StudentCourseDTO;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();
        CourseDAO courseDAO = new CourseDAOImpl();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n 1. Student 2.Course 3.Enrollment");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n 1.add 2.Student List 3.Update 4.Delete  5.Search");
                    int secChoice = sc.nextInt();
                    switch (secChoice) {
                        case 1:
                            System.out.println("Enter Student Name");
                            String name = sc.next();
                            System.out.println("Enter Student Age");
                            int age = sc.nextInt();
                            System.out.println("Enter Student Email");
                            String email = sc.next();

                            dao.addStudent(new Student(name, email, age));
                            break;
                        case 2:
                            dao.getAllStudents().forEach(s ->
                                    System.out.println(
                                            s.getId() + " " + s.getName() + " " + s.getEmail()
                                    )
                            );
                            break;
                        case 3:
                            System.out.println("Enter Student ID to update");
                            Student s = dao.getStudentById(sc.nextInt());
                            System.out.println("Enter Student Name to Update");
                            s.setName(sc.next());
                            dao.updateStudent(s);
                            break;
                        case 4:
                            System.out.println("Enter Student ID to Delete");
                            dao.deleteStudent(sc.nextInt());
                            break;
                        case 5:
                            System.out.println("Enter Student ID to Search");
                            int searchId = sc.nextInt();
                            Student stu = dao.getStudentById(searchId);
                            System.out.println("Found: " + stu.getName());
                            break;
                        default:
                            System.out.println("Invalid Choice");
                    }
                    break;
                case 2:
                    System.out.println("\n 1.add 2.Course List 3.Update 4.Delete");
                    secChoice = sc.nextInt();
                    switch (secChoice) {
                        case 1:
                            System.out.println("Enter Course Name to Update");
                            String name = sc.next();
                            System.out.println("Enter Course Fee to Update");
                            double fee=sc.nextDouble();
                            courseDAO.addCourse(new Course(name,fee));
                            break;
                        case 2:
                            courseDAO.getAllCourses().forEach(c-> System.out.println(c.getId()+" "+c.getName()+" "+c.getFee()));
                            break;
                        case 3:
                            System.out.println("Enter Course ID to update");
                            Course c = courseDAO.getCourseById(sc.nextInt());
                            System.out.println("Enter Fee to Update");
                            c.setFee(sc.nextDouble());
                            courseDAO.updateCourse(c);
                            break;
                        case 4:
                            System.out.println("Enter Course ID to Delete");
                            courseDAO.deleteCourse(sc.nextInt());
                            break;
                    }

                    break;
                case 3:
                    EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();
                    System.out.println("\n 1.Enroll 2.Show Total");
                    choice =sc.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("Student ID:");
                            int stdId=sc.nextInt();
                            System.out.println("Course ID:");
                            int courseId = sc.nextInt();
                            enrollmentDAO.enrollStudent(new Enrollment(stdId,courseId, LocalDate.now()));

                            enrollmentDAO.getStudentCourseDetails().forEach(dto -> System.out.println(
                                    dto.getStudentName() + " enrolled in " +
                                            dto.getCourseName() + " (Fee: " + dto.getCourseFee() + ")")
                            );
                            break;
                        case 2:
                            System.out.println("Total_Enrollment");
                            enrollmentDAO.total().forEach( dto-> System.out.println("Course_id : " +dto.getCourseId()+
                                    "; Course_Name : "+ dto.getCourseName()+"; totalFee : "+ dto.getTotalFee() +
                                    "; Total_Student : "+ dto.getTotalStudent()));
                            break;
                        default:
                            System.out.println("Invalid");
                    }
                    break;

                default:
                    System.out.println("Invalid Number");
            }
        }

        // CREATE

/*
        // READ ALL


        // READ ONE

        // UPDATE


        // DELETE
        dao.deleteStudent(2);
        */





//        EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();
//        enrollmentDAO.enrollStudent(new Enrollment(1,1, LocalDate.now()));
//
//        enrollmentDAO.getStudentCourseDetails().forEach(dto ->
//                System.out.println(
//                        dto.getStudentName() + " enrolled in " +
//                                dto.getCourseName() + " (Fee: " + dto.getCourseFee() + ")"
//                )
//        );


    }

}
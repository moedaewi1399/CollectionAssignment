package CollectionAssignment.HomeWork5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class HomeWork5 {
    public static void main(String[] args){
    List<Student> studentList = Arrays.asList(new Student("Aung",3),new Student("Moe",1),new Student("Hnin",1),new Student("Khun",2));

    studentList.sort(Comparator.comparingInt(Student::getGrade).reversed());
    for(Student s:studentList){
        System.out.println(s.toString());
    }
    }
}

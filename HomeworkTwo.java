package CollectionAssignment;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class HomeworkTwo {
    public static void main(String[] args) {
        LinkedList<String> studentList = new LinkedList<>();
        studentList.add("Moe");
        studentList.add("Hnin");
        studentList.add("Khun");
        studentList.add("May");
        studentList.add("Hein");
        studentList.add("Aung");
        studentList.add("Thit");
        studentList.add("Hla");
        studentList.add("Ngwe");
        studentList.add("Zin");

        Collections.sort(studentList);
        System.out.println(studentList);
    }

}

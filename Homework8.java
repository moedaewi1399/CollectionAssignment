package CollectionAssignment;

import java.util.HashMap;
import java.util.Map;
class Student{
    private int rollNo;
    private String name;
    private String grade;
    private int age;
    public Student(int rollNo,String name,String grade,int age){
        this.rollNo=rollNo;
        this.name=name;
        this.grade=grade;
        this.age=age;
    }
    public String toString(){
        return "Student: "+"rollNo= "+rollNo+",name= "+ name+", grade= "+grade+",age "+age;
    }

    static int id=1;
    public static void addStudent(Student student){
        int key = id++;
        Homework8.memoryDB.put(key,student);
        System.out.println("ID :"+key+"=>"+student.toString());
    }


}
public class Homework8 {
    static Map<Integer,Object> memoryDB = new HashMap<>();
    public static void main(String[] args){
       Student.addStudent(new Student(1,"n" ,
                "A",26));

       Student.addStudent(new Student(2,"b","A",23));


    }
}

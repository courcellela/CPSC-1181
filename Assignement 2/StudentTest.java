/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			January 18th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */
import java.util.*;

public class StudentTest {
    /*
    * This application test the Student class by creating objects and calling the methods
    */
    public static void main(String[] args) {
        Student student1 = new Student("'April Schauer'", "");
        System.out.println(student1);

        Student student2 = new Student("'Norma Li'", "");
        System.out.println(student2);

        Student student3 = new Student("'Brock O'", " ");
        System.out.println(student3);

        Student student4 = new Student("'Misty Waters'", " ");
        System.out.println(student4);

        student1.addCourse("A+", 3);
        student1.addCourse("A", 3);
        student1.addCourse("A-", 3);
        student1.addCourse("B+", 3);
        System.out.println("Student GPA " + student1.getName() + " is " + student1.calculateGPA());
    }
}

/*
**This application will create an ArrayList
 */
import java.util.ArrayList;
public class College
{
    private ArrayList<Student> collegeStudents;
    /*
    **This program will initialize the instance variable
     */
    public College()
    {
        collegeStudents = new ArrayList<Student>();
    }
    /*
    **This application will add an object from the Student class
     */
    public void addStudent(Student student)
    {
        collegeStudents.add(student);
    }
    /*
    **This application will search a student by the student number
     */
    public boolean find(int studentNumber) {

        for (Student student : collegeStudents) {
            if (student.getStudentNum() == studentNumber) {
                return true;
            }
        }
        return false;
    }
    /*
    **This application will delete a student from the ArrayList
     */
    public boolean deleteStudent(int studentNumber)
    {
        for (Student student : collegeStudents) {
            if (student.getStudentNum() == studentNumber) {
                collegeStudents.remove(student);
                return true;
            }
        }
        return false;
    }
    /*
    **This application will add a course to an student object
     */
    public boolean addCourseTaken(int studentNumber, String grade, int credits)
    {
        if (find(studentNumber))
        {
            for(Student student : collegeStudents)
            {
                student.addCourse(grade, credits);
                return true;
            }
        }
        return false;
    }
    /*
    **This application will retrieve an student loginID
     */
    public String retrieveId(int studentNumber)
    {
        for (Student student : collegeStudents) {
            if (student.getStudentNum() == studentNumber) {
                return student.getLoginId();
            }
        }
        return null; // Return null if student not found
    }

    /*
    **This application will display the student with the highest GPA
     */
    public String highestGPA()
    {
        double maxGPA = 0;
        String student = "";
        int studentNum = 0;

        for (int i = 0; i < collegeStudents.size(); i++)
        {
            if (collegeStudents.get(i).calculateGPA() > maxGPA)
            {
                maxGPA = collegeStudents.get(i).calculateGPA();
                student = collegeStudents.get(i).getName();
                studentNum = collegeStudents.get(i).getStudentNum();
            }
        }
        return "Student with highest GPA is: " + student + "\n"
                + "Student Name: " + maxGPA + "\n" +
                "Student number: " + studentNum;
    }
    /*
    **This application will display the college class in a String object
     */
    public String toString()
    {
        return "College " + collegeStudents.toString();
    }
}

/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			January 18th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

/*
*This application program will create the Student class
 */
public class Student {
    private String studentName;
    private String studentAddres;
    private double totalGradePoints;
    private int totalCredits;
    private int studentNumber;
    private static int nextStudentNumber = 10000001;
    /*
    This application will construct the student main information.
     */
    public Student(String studentName, String studentAddres){
        this.studentName = studentName;
        this.studentAddres = studentAddres;
        studentNumber = nextStudentNumber++;
        totalGradePoints = 0;
        totalCredits = 0;
    }
    /*
    *This application will display the name of the student
    */
    public String getName(){
        return studentName;
    }
    /*
     *This application will display the name of the student
     */
    public String getAddres(){
        return studentAddres;
    }
    /*
     *This application will add courses
     */
    public void addCourse(String grade, int credits){

        totalCredits += credits;

        if (grade.equalsIgnoreCase("A+")) {
            totalGradePoints += 4.0;
        }
        if (grade.equalsIgnoreCase("A")) {
            totalGradePoints += 4.0;
        }
        if (grade.equalsIgnoreCase("A-")) {
            totalGradePoints += 3.7;
        }
        if (grade.equalsIgnoreCase("B+")) {
            totalGradePoints += 3.3;
        }
        if (grade.equalsIgnoreCase("B")) {
            totalGradePoints += 3.0;
        }
        if (grade.equalsIgnoreCase("B-")) {
            totalGradePoints += 2.7;
        }
        if (grade.equalsIgnoreCase("C")) {
            totalGradePoints += 2.0;
        }
        if (grade.equalsIgnoreCase("C-")) {
            totalGradePoints += 1.7;
        }
        if (grade.equalsIgnoreCase("D")) {
            totalGradePoints += 1.0;
        }
        if (grade.equalsIgnoreCase("F")) {
            totalGradePoints += 0.0;
        }
    }
    /*
     *This application calculates the GPA
     */
    public double calculateGPA(){
        return (totalGradePoints * 3) / totalCredits;
    }
    /*
     *This application return the student number
     */
    public int getStudentNum(){
        return studentNumber;
    }
    /*
     *This application creates the Student ID
     */
    public String getLoginId() {
        String id = getName().toLowerCase();
        String clearId = id.trim();
        char firsLetter = clearId.charAt(0);
        String lastName = "";
        for (int i = 0; i < clearId.length(); i++) {
            if (clearId.charAt(i) == ' ') {
                lastName = clearId.substring(i + 1);
            }
        }
        String secondLetters;
        if (lastName.length() >= 3) {
            secondLetters = lastName.substring(0, 3);
        } else {
            secondLetters = lastName;
        }
        int idNum = getStudentNum();
        String idNum2 = String.valueOf(idNum);
        String idNum3 = idNum2.substring((idNum2.length() - 3));
        return firsLetter + secondLetters + idNum3;
    }
    /*
     *This application print the student constructed.
     */
    public String toString(){
        return getName() + "'Student number': " + getStudentNum() + " has a login id " + "'" +
                getLoginId() + "'" ;
    }
}

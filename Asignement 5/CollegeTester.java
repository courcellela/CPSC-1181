/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			Febreary 11th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

import java.util.Scanner;

public class CollegeTester
{
    /*
    **This application program will test the College and Student class
     */
    public static void main(String[] args)
    {
        menu();
    }
    /*
    **This application will display the menu
     */
    public static void menu()
    {
        College langara = new College();
        langara.addStudent(new Student("Ryan Reynolds", "01 Main Str"));
        langara.addStudent(new GraduateStudent("Denis Villenueve", "10 Ontario Str", "Computer Science", "Proffesor X"));
        langara.addStudent(new Student("Ryan Gosling", "02 Abbot Str"));
        langara.addStudent(new InternationalStudent("Christopher Nolan", " 77 Illinois Av", "London"));
        langara.addStudent(new GraduateStudent("Stanley Kubrick", "1 Odyssey", "Script", "Steven S"));
        langara.addStudent(new InternationalStudent("Guillermo del Toro", " 52 Mexico St", "EU"));

        int totalCredits = 15;

        boolean flag = false;

        while (!flag) {
            System.out.println("Welcome" + "\n" + "We have created a college with some students");
            System.out.println("1. Add a new Student to an existing College" + "\n" +
                    "2. Look for an existing student" + "\n" +
                    "3. Delete a student" + "\n" +
                    "4. Add the grade point and credits to an student" + "\n" +
                    "5. Retrieve the login ID of an student" + "\n" +
                    "6. find the student with the highest GPA" + "\n" +
                    "7. Exit program");
            Scanner input2 = new Scanner(System.in);
            int option = input2.nextInt();

            switch (option) {
                case 1:
                    addStudent(langara);
                    break;
                case 2:
                    int studentNum = studentNumSearch();
                    if (checkerNum(studentNum))
                    {
                        findStudent(langara, studentNum);
                    }
                    break;
                case 3:;
                    int studentNum2 = studentNumSearch();
                    if (checkerNum(studentNum2))
                    {
                        delStudent(langara, studentNum2);
                    }
                    break;
                case 4:
                    addStudentGPA(langara);
                    break;
                case 5:
                    System.out.println("Enter the student number");
                    Scanner input = new Scanner(System.in);
                    int studentNum3 = input.nextInt();
                    if (checkerNum(studentNum3))
                    {
                        idRetrieve(langara, studentNum3);
                    }
                    break;
                case 6:
                    showHighestGPA(langara);
                    break;
                case 7: flag = true;
                    break;
            }
        }
        for (int i = 0; i < (langara.getStudents().size()); i++)
        {
            System.out.println(langara.getStudents().get(i).getName() + " will pay for the semester  $" +  (int)langara.getStudents().get(i).getTuitionFeed(totalCredits));
        }
        System.out.println(langara);
    }
    /*
    **This application program will add Student to College ArrayList
     */
    public static void addStudent(College college)
    {
        boolean flag = false;

        while(!flag) {
            System.out.println("Enter one type: (1)Student, (2)Graduate Student, (3)International Student");
            Scanner input = new Scanner(System.in);
            int type = input.nextInt();
            System.out.println("Enter the student name");
            Scanner input2 = new Scanner(System.in);
            String name = input2.nextLine();
            System.out.println("Enter the student addres");
            String addres = input2.nextLine();

            if (checker(name) || checker(addres))
            {
                name = name.trim();
                addres = addres.trim();
                if (type == 1)
                {
                    college.addStudent(new Student(name, addres));
                }
                if (type == 2)
                {
                    System.out.println("Enter the student research topic");
                    String topic = input2.nextLine();
                    System.out.println("Enter the student's supervisor name");
                    String supervisor = input2.nextLine();
                    college.addStudent(new GraduateStudent(name, addres, topic, supervisor));
                }
                if (type == 3)
                {
                    System.out.println("Enter the student country of origin");
                    Scanner input4 = new Scanner(System.in);
                    String country = input4.nextLine();
                    college.addStudent(new InternationalStudent(name, addres, country));
                }

                System.out.println("Do you want to add another student in this college? Answer Y/N");
                Scanner input3 = new Scanner(System.in);
                String yes = input3.nextLine();

                if (yes.charAt(0) == 'N' || yes.charAt(0) == 'n')
                {
                    flag = true;
                }
            }
        }
    }
    /*
    **This application will check for the input words
     */
    public static boolean checker(String word)
    {
        for (int i = 0; i < word.length(); i++)
        {
            if (word.charAt(i) < 65 && word.charAt(i) > 122){
                System.out.println("Error, write only letter of the alphabet");
                return false;
            }
        }
        return true;
    }
    /*
    **This application will check for input numbers
     */
    public static boolean checkerNum(int num)
    {
        if (num < 10000001 || num > 99999999){
            System.out.println("Error, not a correct number");
            return false;
        }
        return true;
    }
    /*
    **This application will check for tbe credits number
     */
    public static boolean checkCredits(int num)
    {
        if (num < 1 || num > 5){
            System.out.println("Error, credits are from 1 to 5");
            return false;
        }
        return true;
    }
    /*
    **This application will request the student number to the user
     */
    public static int studentNumSearch()
    {
        System.out.println("Enter the student number");
        Scanner input3 = new Scanner(System.in);
        return input3.nextInt();
    }
    /*
    **This application will search for the student in the college
     */
   public static void findStudent(College college, int num)
    {
        if (college.find(num))
        {
            System.out.println("The student: " + num + " is registered in the collece");
        }
        else{
            System.out.println("The student: " + num + " was not found");

        }
    }
    /*
    **This application will delete an student from the college
     */
    public static void delStudent(College college, int num)
    {
        if (college.deleteStudent(num))
        {
            System.out.println("The student: " + num + " is removed");
        }
        else{
            System.out.println("The student: " + num + " was not found");
        }
    }
    /*
    **This application will add the courses taken to an student in a college
     */
    public static void addStudentGPA(College college)
    {
        int studentNum = studentNumSearch();

        System.out.println("Enter the grade");
        Scanner input = new Scanner(System.in);
        String grade = input.nextLine();

        System.out.println("Enter the credits");
        Scanner input2 = new Scanner(System.in);
        int credits = input2.nextInt();

        if (checkerNum(studentNum) && checkCredits(credits) && checker(grade))
        {
            if (!college.addCourseTaken(studentNum, grade, credits))
            {
                System.out.println("Error, The student was not found");

            }
            else
            {
                System.out.println("The grade and credits were added to the student number: " + studentNum);
            }
        }
        else
        {
            System.out.println("Error, wrong format");

        }
    }
    /*
    **This application will display the loginID
     */
    public static void idRetrieve(College college, int num)
    {
        String loginId = college.retrieveId(num);
        if (loginId != null)
        {
            System.out.println("The student ID is: " + loginId);
            loginId = "";
        }
        else
        {
            System.out.println("The student ID was not found");
        }
    }
    /*
    **This application will display the Student with the highest GPA
     */
    public static void showHighestGPA(College college)
    {
        String gpa = college.highestGPA();
        System.out.println(gpa);
    }
}

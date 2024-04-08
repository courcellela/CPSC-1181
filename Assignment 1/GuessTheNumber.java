/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			January 11th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

import javax.swing.JOptionPane;

public class GuessTheNumber {
    /*
     **This application program Guess the number input by the user
     **/
    public static void main(String[] args){

        startGame();

    }
    /*
    **This application program display the Menu for choice the game level
     */
    public static void startGame(){

        boolean flag = false;
        while (!flag) {
            Object[] choice = {"easy", "medium", "hard"};
            String level = (String) JOptionPane.showInputDialog(null,
                    "Welcome to Guess My Number Game." + "\n" +
                            "Choose a level of difficulty" + "\n",
                    "Mystery Number Game", JOptionPane.PLAIN_MESSAGE, null,
                    choice, choice[0]);
            if (level.equals("easy") || level.equals("medium") || level.equals("hard")) {
                game(level);
            }
            int repeat = JOptionPane.showConfirmDialog(
                    null, "Would you like to repeat the program",
                    "Mystery Game", JOptionPane.YES_NO_OPTION);
            if (repeat == 1) {
                flag = true;
            }
        }
    }
    /*
    **This application program provide the instruction of the game for each level
     */
    public static void game(String level){

        boolean flag = false;
        while (!flag){

            if (level.equals("easy")){
                String easyNum = (String)JOptionPane.showInputDialog(null,
                    "Follow the next instructions:" + "\n" +
                            "1. Choose an Integer number from 0 to 9" + "\n" +
                            "2. Subtract 9 from the number you choose" + "\n" +
                            "3. Write the result in the box" + "\n",
                        "Mystery Game", JOptionPane.PLAIN_MESSAGE);
                System.out.println(easyNum);
                if (!checker("easy", easyNum)){
                    repeat();//write message box if input is not valid
                }
                else {
                    guessNum("easy", easyNum);
                    flag = true;
                }
            }

            if (level.equals("medium")){
                String mediumNum = (String)JOptionPane.showInputDialog(null,
                        "Follow the next instructions:" + "\n" +
                                "1. Choose an Integer number from 0 to 9" + "\n" +
                                "2. Multiply your number by 2" + "\n" +
                                "3. Add the current month as one digit number (ex January is 1)" + "\n" +
                                "4. Write the result in the box" + "\n",
                        "Mystery Game", JOptionPane.PLAIN_MESSAGE);
                if (!checker("medium", mediumNum)){
                    repeat();//write message box if input is not valid
                }
                else {
                    guessNum("medium", mediumNum);
                    flag = true;
                }
            }
            if (level.equals("hard")){
                String hardNum = (String)JOptionPane.showInputDialog(null,
                        "Follow the next instructions:" + "\n" +
                                "1. Choose an Integer number from 0 to 9" + "\n" +
                                "2. Add the number of months in a year" + "\n" +
                                "3. Add the current year" + "\n" +
                                "4. Add the number of days in your current Month" + "\n" +
                                "5. Write the result in the box" + "\n",
                        "Mystery Game", JOptionPane.PLAIN_MESSAGE);
                if (!checker("hard", hardNum)){
                    repeat();//write message box if input is not valid
                }
                else {
                    guessNum("hard", hardNum);
                    flag = true;
                }
            }
        }
    }
    /*
    **This application program check for input errors
     */
    public static boolean checker(String level, String num){

        if (level.equals("easy")){
            if (num.length() > 1){
                return false;
            }
        }
        if (level.equals("medium")){
            if (num.length() > 2){
                return false;
            }
        }
        if (level.equals("hard")){
            if (num.length() > 4){
                return false;
            }
        }
        for (int i = 0; i < num.length(); i++){
            if (num.charAt(i) < 47 || num.charAt(i) > 57){
                return false;
            }
        }
        return true;
    }
    /*
    **This application program display the error message
     */
    public static void repeat(){
        JOptionPane.showMessageDialog(null,
                "Please write only numbers and the correct number of digits",
                        "Error", JOptionPane.ERROR_MESSAGE);
    }
    /*
    **This application program make the calculations of the numbers
     */
    public static void guessNum(String level, String numResult){
        int num, numFound = 0;
        if (level.equals("easy")) {
            num = Integer.parseInt(numResult);
            numFound = 9 - num;
        }
        if (level.equals("medium")) {
            num = Integer.parseInt(numResult);
            numFound = (num - 1) / 2;
        }
        if (level.equals("hard")) {
            num = Integer.parseInt(numResult);
            numFound = num - 2067;
        }

        result(numFound);
    }
    /*
    **This application program display the result
     */
    public static void result(int result){
        JOptionPane.showMessageDialog(null,
                "Your number is........" + "\n" + result,
                "Mystery Game", JOptionPane.INFORMATION_MESSAGE);
    }
}


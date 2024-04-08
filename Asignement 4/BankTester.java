/**
 **Program Name:	CS Object-Oriented Computing
 **Author:			Luis Courcelle
 **Date:			February 01st, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This application program test the Bank and BankAccount classes with input from the user
 */
public class BankTester {
    /**
     * This application display the menu options of the tester program
     */
    public static void main(String[] args)
    {
        Bank rbc = new Bank();


        int findAccount = 0000;
        double amount = 0.00;
        int accountNumber = 1006;
        rbc.addAccount(new BankAccount(1001, 30000));
        rbc.addAccount(new BankAccount(1002, 0));
        rbc.addAccount(new BankAccount(1003, 5000));
        rbc.addAccount(new BankAccount(1004, 2000));
        rbc.addAccount(new BankAccount(1005, 2000));
        rbc.addAccount(new BankAccount(1006, 0));

        boolean stop = false;
        try {

            //Test for null accounts //
            /*Bank scotia = new Bank();
            scotia.getMinimun();
            scotia.getMaximum();*/

            while (!stop) {
                System.out.println("Choose an option" + "\n" +
                        "1. Add a new Bank Account" + "\n" +
                        "2. Balance of a Bank Account" + "\n" +
                        "3. Deposit money to a Bank Account" + "\n" +
                        "4. Withdraw money from a Bank Account" + "\n" +
                        "5. Display a Bank Account with the highest Balance" + "\n" +
                        "6. Display a Bank Account with the lowest Balance" + "\n" +
                        "7. Exit program");
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                switch (option)
                {
                    case 1:
                        accountNumber++;
                        createAccount(rbc, accountNumber);
                        break;
                    case 2:
                        findAccount = inputAccountNumber();
                        getBalanceAccount(rbc, findAccount);
                        break;
                    case 3:
                        findAccount = inputAccountNumber();
                        amount = requestAmount();
                        rbc.depositToAccount(findAccount, amount);
                        break;
                    case 4:
                        findAccount = inputAccountNumber();
                        amount = requestAmount();
                        rbc.withdrawToAccount(findAccount, amount);
                        break;
                    case 5:
                        System.out.println(rbc.getMaximum());
                        break;
                    case 6:
                        System.out.println(rbc.getMinimun());
                        break;
                    case 7:stop = true;
                        break;
                }
            }
        }
        catch(BankAccountException | BankException e)
        {
            System.out.println("Error " + e.getMessage());
        }
        catch (NumberFormatException | InputMismatchException e)
        {
            System.out.println("The input is not a number");
        }
    }
    /**
     * This application creates a new Bank Account
     * @param name request the Bank variable
     * @param num request the balance amount
     */
    public static void createAccount(Bank name, int num)
    {
        try{
            System.out.println("Enter initial balance as a double digit");
            Scanner input = new Scanner(System.in);
            double newAccountBalance = input.nextDouble();
            name.addAccount(new BankAccount(num, newAccountBalance));
            System.out.println("Te account was created with RBC " + name);
        }
        catch (NumberFormatException | InputMismatchException e)
        {
            System.out.println("Not a number");
        }
    }
    /**
     * This application request to input the Account Number
     * @return the number
     */
    public static int inputAccountNumber()
    {
            System.out.println("Enter tha account number");
            Scanner scanner = new Scanner(System.in);
            int accountNumber = scanner.nextInt();
            return accountNumber;
    }

    /**
     * This application return the balanace for a given Bank Account
     * @param bank name of the Bank variable
     * @param num Account number
     */
    public static void getBalanceAccount(Bank bank, int num)
    {
        BankAccount account = bank.find(num);
        if (account != null)
        {
            System.out.println("Balance is: " + account.getBalance()); ;
        }
    }
    /**
     * This application request for an amount
     * @return the input amount
     */
    public static double requestAmount()
    {
        System.out.println("Enter the amount");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

}

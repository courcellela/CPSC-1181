/**
 **Program Name:	CS Object-Oriented Computing
 **Author:			Luis Courcelle
 **Date:			February 01st, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

/**
 * This application program create the Bank Account class
 */
public class BankAccount {
    private double balance;
    private int accountNumber;

    public BankAccount(int anAccountNumber){

        balance = 0;
        accountNumber = anAccountNumber;
        try{
            checkAccountNumber(accountNumber);
        }
        catch (BankAccountException e)
        {
            System.out.println("Error in the account " + e.getMessage());
        }
    }

    /**
     * Constructor with paramenters
     * @param anAccountNumber
     * @param initialBalance
     * @throws BankAccountException
     */
    public BankAccount(int anAccountNumber, double initialBalance) throws BankAccountException{

        balance = initialBalance;
        accountNumber = anAccountNumber;

        try{
            checkAccountNumber(accountNumber);
            checkAccountBalance(balance);
        }
        catch (BankAccountException e)
        {
            System.out.println("Error adding account " + e.getMessage());
            System.exit(1);
        }
    }
    /**
     * To obtain the balance
     * @return the balance
     */
    public double getBalance() {

        return balance;
    }
    /**
     * To obatain the account number
     * @return account number
     */
    public int getAccountNumber(){

        return accountNumber;
    }
    /**
     * Deposite the amount given
     * @param amount
     */
    public void deposit(double amount){

        balance += amount;
    }
    /**
     * Withdraw the amount given
     * @param amount
     * @throws BankAccountException
     */
    public void withdraw(double amount) throws BankAccountException{

       if ((balance -= amount) < 0)
           throw new BankAccountException("Insufficient funds");
    }
    /**
     * validates the length of numbers for an account number
     * @param accountNumber
     * @throws BankAccountException
     */
    private void checkAccountNumber(int accountNumber) throws BankAccountException {
        if (accountNumber < 1000 || accountNumber > 1999) {
            throw new BankAccountException("Only 4 digits number");
        }
    }
    /**
     * Validate the balance is not negative
     * @param balance
     * @throws BankAccountException
     */
    private void checkAccountBalance(double balance) throws BankAccountException{
        if (balance < 0)
        {
            throw new BankAccountException("Balance cant' be less than 0");
        }
    }
    @Override
    public String toString(){
        return "Account Number: " + accountNumber + "  balance: " + balance;
    }
}

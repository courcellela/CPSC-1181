/**
 **Program Name:	CS Object-Oriented Computing
 **Author:			Luis Courcelle
 **Date:			February 01st, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */
import java.util.ArrayList;
/**
 * This application program creates the Bank class
 */
public class Bank {
    private ArrayList<BankAccount> accounts;

    /**
     * This application creates the constructors of Bank
     */
    public Bank()
    {
        accounts = new ArrayList<BankAccount>();
    }
    public void addAccount(BankAccount a) throws BankAccountException
    {
        if (a.getAccountNumber() < 1000 || a.getAccountNumber() > 1999)
            throw new BankAccountException("Only 4 digits number");
        accounts.add(a);
    }

    /**
     * Get the balance of the accounts in the Bank
     * @return total balance
     */
    public double getTotalBalance()
    {
        double total = 0;
        for(BankAccount a : accounts)
        {
            total = total + a.getBalance();
        }
        return total;
    }
    /**
     Counts the number of bank accounts whose balance is at least a given value.
     @param atLeast the balance required to count an account
     @return the number of accounts having least the given balance
     */
    public int count(double atLeast)
    {
        int matches = 0;

        for(BankAccount a : accounts)
        {
            if (a.getBalance() >= atLeast)
                matches++;
        }
        return matches;
    }
    /**
     Finds a bank account with a given number.
     @param accountNumber the number to find
     @return the account with the given number, or null if there is no such account
     */
    public BankAccount find(int accountNumber) throws BankAccountException
    {
        for(BankAccount a : accounts)
        {
            if (a.getAccountNumber() == accountNumber)
                return a;
        }
        throw new BankAccountException("Account not found");
    }
    /**
     Gets the bank account with the largest balance.
     @return the account with the largest balance, or null if the bank has no accounts
     */
    public BankAccount getMaximum() throws BankException
    {
        if (accounts.size() == 0)
            throw new BankException("There is only one or none accounts in this bank");


        BankAccount largest = accounts.get(0);

        for (int i = 1; i < accounts.size(); i++)
        {
            BankAccount a = accounts.get(i);
            if (a.getBalance() > largest.getBalance())
                largest = a;
        }
        return largest;
    }

    /**
     * Get the account with the minimum balance
     * @return account number
     * @throws BankException
     */
    public BankAccount getMinimun() throws BankException
    {
        if (accounts.size() == 0)
            throw new BankException("There is only one or none accounts in this bank");

        BankAccount minimun = accounts.get(0);

        for (int i = 1; i < accounts.size(); i++)
        {
            BankAccount a = accounts.get(i);
            if (a.getBalance() < minimun.getBalance() )
                minimun = a;
        }
        return minimun;
    }
    /**
     * Deposite the amount in the Bank Account given
     * @param accountNumber account number
     * @param amount the deposit amount
     * @return update the balanca
     * @throws BankAccountException
     */
    public BankAccount depositToAccount(int accountNumber, double amount) throws BankAccountException
    {
        for(BankAccount a : accounts)
        {
            if (a.getAccountNumber() == accountNumber)
            {
                a.deposit(amount);
                return a;
            }
        }
        throw new BankAccountException("Account not found");
    }
    /**
     * Withdraw the amount from the Bank Account given
     * @param accountNumber account number
     * @param amount withdraw amount
     * @return update the balance
     * @throws BankAccountException
     */
    public BankAccount withdrawToAccount(int accountNumber, double amount) throws BankAccountException
    {
        for(BankAccount a : accounts)
        {
            if (a.getAccountNumber() == accountNumber)
            {
                a.withdraw(amount);
                return a;
            }
        }
        throw new BankAccountException("Account not found");
    }
    public String toString()
    {
        return "  Bank " + accounts.toString();
    }
}

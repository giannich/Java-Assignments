/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giannichenproject5;

/**
 *
 * @author Gianni
 */
public class BankAccount {
    
    Customer customer;
    String acctNumber;
    float balance;
    
    public void deposit(float amt)
    {
        balance += amt;
        System.out.println(String.format(customer.firstName + " " + customer.lastName + 
                " deposited $%.2f. Current balance is $%.2f", amt, balance));
    }
    
    public void withdraw(float amt)
    {
        if (balance >= amt)
        {
            balance -= amt;
            System.out.println(String.format(customer.firstName + " " + customer.lastName + 
                " withdrew $%.2f. Current balance is $%.2f", amt, balance));
        }
        else
        {
            System.out.println(String.format("Unable to withdraw $%.2f for " + customer.firstName +
                    " " + customer.lastName + " due to insufficient funds.", amt));
        }
    }
    
    public void applyInterest()
    {
        //This function applies interest
    }
    
    public void checkBalance()
    {
        System.out.println(String.format(customer.firstName + " " + customer.lastName + 
                ", Balance $%.2f", balance));
    }
    
    public String randomAcctNumber()
    {
        java.util.Random rand = new java.util.Random();
        String seed = "";
        for (int i = 0; i < 10; i++)
        {
            seed += String.valueOf(rand.nextInt(9));
        }
        return seed;
    }
    
}

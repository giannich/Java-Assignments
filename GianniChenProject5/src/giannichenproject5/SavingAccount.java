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
public class SavingAccount extends BankAccount {
    
    //Constructor
    public SavingAccount(String first, String last, String social, float bal)
    {
        customer = new Customer(first, last, social);
        acctNumber = randomAcctNumber();
        balance = bal;
        
        System.out.println("Successfully created account for " + customer.firstName + 
                " " + customer.lastName + " Account Number " + acctNumber);
        checkBalance();
    }
    
    public void applyInterest()
    {
        balance *= (1.05f);
    }
    
}

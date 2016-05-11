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
public class CheckingAccount extends BankAccount{
    
    //Constructor
    public CheckingAccount (Customer cust, float bal)
    {
        customer = cust;
        acctNumber = randomAcctNumber();
        balance = bal;
        
        System.out.println("Successfully created checking account for " + customer.firstName + 
                " " + customer.lastName + " Account Number " + acctNumber);
        
        //checkBalance();
    }
    
    public void applyInterest()
    {
        if (balance > 10000)
        {
            float interest = (balance - 10000) * 0.02f;
            balance += interest;
        }
    }
}

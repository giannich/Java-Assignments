/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package giannichenproject5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Gianni
 */
public class BankDatabase {
    
    ArrayList<BankAccount> database = new ArrayList<BankAccount>();
    
    public BankDatabase()
    {
        //Null Constructor
    }
    
    public void openAccount(String type, Customer customer, float deposit)
    {
        if (type == "Checking")
        {
            CheckingAccount checkAcct = new CheckingAccount(customer, deposit);
            database.add(checkAcct);
        }
        else if (type == "Saving")
        {
            SavingAccount savingAcct = new SavingAccount(customer, deposit);
            database.add(savingAcct);
        }
        else
        {
            System.out.println("Error: Wrong account type was entered.");
        }
    }
    
    public void print()
    {   
        Collections.sort(database);
        
        for (BankAccount element: database)
        {
            System.out.println(String.format(element.customer.firstName + " " + element.customer.lastName +
                    ", accn #: " + element.acctNumber + ", Balance $%.2f", element.balance));
        }
    }
    
    public void applyInterest()
    {
        for (BankAccount element: database)
        {
            element.applyInterest();
        }
    }
    
}

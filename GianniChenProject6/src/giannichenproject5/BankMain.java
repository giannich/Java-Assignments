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

public class BankMain {

    public static void main(String[] args) {

        BankDatabase db = new BankDatabase();

        Customer alin = new Customer("Alin Parker", "123-45-6789");

        Customer mary = new Customer ("Mary Jones", "987-65-4321");

        Customer john = new Customer("John Smith", "123-45-6789");    

        db.openAccount("Checking", alin, 20000.0f);

        db.openAccount ("Saving", mary, 15000.0f);

        db.openAccount("Saving", john, 12000.0f);

        db.print();

        db.applyInterest();

        db.print();
    }
}


//Old BankMain
/*
public class BankMain {

    public static void main(String[] args) {       

        CheckingAccount acct1 = new CheckingAccount("Alin", "Parker", "123-45-6789", 1000.0f);
        CheckingAccount acct2 = new CheckingAccount("Mary", "Jones", "987-65-4321", 500.0f);
        SavingAccount acct3 = new SavingAccount("John", "Smith", "1233-45-6789", 200.0f);
        
        acct1.deposit(22000.00f);
        acct2.deposit(12000.00f); 

        acct1.withdraw(2000.00f);
        acct2.withdraw(1000.00f);

        acct1.applyInterest();
        acct2.applyInterest();

        acct1.checkBalance();
        acct2.checkBalance();

        acct1.withdraw(30000.00f);

    }

}*/
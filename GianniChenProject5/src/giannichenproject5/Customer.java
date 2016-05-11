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
public class Customer {
    
    String firstName;
    String lastName;
    String SSNumber;
    
    public Customer(String first, String last, String social)
    {
        firstName = first;
        lastName = last;
        SSNumber = social;

        if (!(
                Character.isDigit(social.charAt(0)) &&
                Character.isDigit(social.charAt(1)) &&
                Character.isDigit(social.charAt(2)) &&
                social.charAt(3) == 45 &&
                Character.isDigit(social.charAt(4)) &&
                Character.isDigit(social.charAt(5)) &&
                social.charAt(6) == 45 &&
                Character.isDigit(social.charAt(7)) &&
                Character.isDigit(social.charAt(8)) &&
                Character.isDigit(social.charAt(9)) &&
                Character.isDigit(social.charAt(10))))
        {
            System.out.println("Successfully created account for John Smith. Invalid SSN!");
        }
    }
}

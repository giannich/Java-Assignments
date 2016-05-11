/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
public class InvalidCustomerException extends Exception {
    
    String SSN;
    
    InvalidCustomerException()
    {
        super();
    }
    InvalidCustomerException(String s)
    {
        super(s);
        SSN = s;
    }
    
    @Override
    public String getMessage()
    {
        return ("Invalid SSN " + SSN);
    }

}

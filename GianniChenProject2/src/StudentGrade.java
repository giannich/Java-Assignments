/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
public class StudentGrade {
    
    public static void main (String[] args)
    {
        int count = 5;
        String letter;
        
        while (count > 0)
        {
            int grade = (int)(Math.random() * 50) + 50;
            if (grade > 90)
            {
                letter = "A";
            }
            else if (grade > 80)
            {
                letter = "B";
            }
            else if (grade > 70)
            {
                letter = "C";
            }
            else if (grade > 60)
            {
                letter = "D";
            }
            else
            {
                letter = "F";
            }
            System.out.println("Student grade is " + grade + " which is a " + letter);
            count--;
        }
    }
}

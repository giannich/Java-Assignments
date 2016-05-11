/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */

import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args)
    {
        int[] list = new int[5];
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, welcome to ArrayDemo!");
        
        for (int i = 0; i < list.length; i++)
        {
            System.out.println("Please input data for index number " + i + ": ");
            list[i] = in.nextInt();
        }
        
        float avg = getAverage(list);
        int max = getLargest(list);
        int min = getSmallest(list);
        
        System.out.println("You have entered the following numbers: " + list[0] + ", " + list[1] + ", " + list[2] + ", " + list[3] + ", and " + list[4]);
        System.out.println("The average of those numbers is: " + avg);
        System.out.println("The largest of those numbers is: " + max);
        System.out.println("And the smallest of those numbers is: " + min);
        
        //determine and output: -avg, -max, -min
    }
    
    static float getAverage(int[] data)
    {
        int sum = 0;
        
        for (int i = 0; i < data.length; i++)
        {
            sum += data[i];
        }
        return (sum/data.length);
    }
    static int getLargest(int[] data)
    {
        int large = data[0];
        
        for (int i = 0; i < data.length; i++)
        {
            if (large < data[i])
            {
                large = data[i];
            }
        }
        return large;
    }
    static int getSmallest(int[] data)
    {
        int small = data[0];
        
        for (int i = 0; i < data.length; i++)
        {
            if (small > data[i])
            {
                small = data[i];
            }
        }
        return small;
    } 
    
}

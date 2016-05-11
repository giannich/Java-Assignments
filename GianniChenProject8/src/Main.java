/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) { 
        
        // Path to file example
        // C:\Users\Gianni\Box Sync\UCLA Extension\Java\GianniChenProject8\src\boats.txt

        // Create boats
        Boat seaMonkey = new Boat("Sea Monkey");
        Boat backdraft = new Boat("Backdraft");
        Boat castAway = new Boat("Cast Away");
        Boat nautifish = new Boat("Nautifish");
        Boat destiny = new Boat("Destiny");
        
        // Ask for file path
        Scanner console = new Scanner(System.in);
        System.out.println("Please input the path of the input file");
        String inputFileName = console.nextLine();
        
        // Create Command ArrayList to store all the boat names and their respective commands
        ArrayList<ArrayList<String>> commandLines = new ArrayList<ArrayList<String>>();
        
        try
        {
            // File reader and buffer reader
            FileReader inputFile = new FileReader(inputFileName);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String line;
            
            // Loop through each line
            while ((line = bufferReader.readLine()) != null)
            {
                // Skip if line is empty
                if (!line.isEmpty())
                {
                    // Parse the line into parts
                    String[] parts = line.split(", ");
                    
                    // Add parts into an ArrayList
                    ArrayList<String> temp = new ArrayList<String>();
                    for (String part : parts)
                    {
                        temp.add(part);
                    }
                    // And then add the temp ArrayList into main ArrayList
                    commandLines.add(temp);
                }
            }
            
            // Close the buffer reader
            bufferReader.close();
            
            // Loop through commands
            for (ArrayList<String> outerPart : commandLines)
            {
                // Validate correct format
                if (outerPart.size() == 2)
                {
                    String boatName = outerPart.get(0);
                    String commandName = outerPart.get(1);

                    switch(boatName) 
                    {
                        case "Sea Monkey":  System.out.println(seaMonkey.CommandInput(commandName));
                                            break;

                        case "Backdraft":   System.out.println(backdraft.CommandInput(commandName));
                                            break;

                        case "Cast Away":   System.out.println(castAway.CommandInput(commandName)); 
                                            break;

                        case "Nautifish":   System.out.println(nautifish.CommandInput(commandName)); 
                                            break;

                        case "Destiny":     System.out.println(destiny.CommandInput(commandName));
                                            break;  
                                            
                                            // Invalid boat name
                        default:            System.out.println(boatName + " does not exist.");                    
                    }
                }
                else
                {
                    System.out.println("Command format is invalid.");
                }
            }
        }
        
        catch(Exception e)
        {
            System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }
    } 
}

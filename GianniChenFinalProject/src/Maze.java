
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
public class Maze {
    
    private static int maxMazeRow = 20;
    private static int maxMazeCol = 50;
    
    private static char[][] maze;

    // The create function accepts a file path and copies the file's layout into the maze 2d array - Works
    static void create (String filename)
    { 
        // Creates the maze
        maze = new char[maxMazeRow][maxMazeCol];
        
        // Try catch segment
        try
        {
            // File reader and buffer reader
            FileReader inputFile = new FileReader(filename);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            
            // Temp variables for first loop
            String line;
            ArrayList<char[]> tempList = new ArrayList<char[]>();
            
            // This loop collects each char of a line into a temporary array of 21 characters
            // The temporary list is then added into an ArrayList of arrays tempList
            for (int i = 0; i < maxMazeRow ; i++)
            {
                // Reads the first line of characters
                line = bufferReader.readLine();
                
                // String into array
                char[] charArray = line.toCharArray();
                    
                // And then add the temp ArrayList into main ArrayList
                tempList.add(charArray);
            }
            
            // Temp variable for second loop
            char[] tempCharArray;
            
            // This second loop transfers the ArrayList of arrays into the 2d maze array
            // The looping restriction allows the selection of only the first 20 characters
            // In this way, the 21st character, which is the carriage return, is ignored
            for (int i = 0; i < maxMazeRow ; i++)
            {
                for (int j = 0; j < maxMazeCol ; j++)
                {
                    tempCharArray = tempList.get(i);
                    maze[i][j] = tempCharArray[j];
                }
                
            }
            // Close the buffer reader
            bufferReader.close();
        }
        catch(Exception e)
        {
            System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }
    }
    
    // This function displays the maze and entities on the console - Works
    static void display()
    {   
        System.out.print("\n");
        for (int i = 0; i < maxMazeRow ; i++)
        {
            // Displays rows guideline
            System.out.print(i+1 + "\t");
            
            for (int j = 0; j < maxMazeCol ; j++)
            {
                System.out.print(maze[i][j]);
            }
            
            // This allows the maze to be printed clearly in each row
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    static boolean available(int row, int col)
    {
        if (maze[row][col] == ' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
        
    // This function returns the current character in the given location; replaces the 'available' function
    static char displayElement(int row, int col)
    {
        return maze[row][col];
    }
    
    // This is a function that replaces a character in the maze and returns the replaced one
    // This is used for creation purposes
    static char replaceElement(char newChar, int row, int col)
    {
        // Puts the old char into a temp retChar
        char retChar = maze[row][col];
        
        // Substitutes new char into old position
        maze[row][col] = newChar;
        
        return retChar;
    }
    
    // This is a function swaps the two chars that are present in the given positions
    // This is used for movement purposes
    static void swapElement(int row1, int col1, int row2, int col2)
    {
        // Puts entity 1 in a temp variable
        char tempChar = maze[row1][col1];
        
        // Moves entity 2 in entity 1's original position and moves temp variable in entity 2's original position
        maze[row1][col1] = maze[row2][col2];
        maze[row2][col2] = tempChar;
    }
    
    // Getter for maze's row
    public static int getMaxRow()
    {
        return maxMazeRow;
    }
    
    // Getter for maze's col
    public static int getMaxCol()
    {
        return maxMazeCol;
    }
}

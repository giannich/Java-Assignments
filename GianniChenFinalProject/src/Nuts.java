import java.util.ArrayList;
import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
public class Nuts extends Edibles{
    
    private static int totalNuts = 5;
    
    // Arraylist of Nuts
    private ArrayList<Nuts> nutList = new ArrayList<Nuts>();
    
    // Creates a bunch of Nuts
    public void create()
    {      
        // New randomizer and variable
        Random rand = new Random();
        boolean nutty;
        
        // Randomizes the list of nuts
        for (int i = 0; i < totalNuts; i++)
        {
            nutty = rand.nextBoolean();
            
            if (nutty)
            {
                Peanut aPeanut = new Peanut();
                nutList.add(aPeanut);
            }
            else
            {
                Almond aAlmond = new Almond();
                nutList.add(aAlmond);
            }
        }
        
        // Initializes some values
        int currentNut = 0;
        Nuts theNut;
        int row;
        int col;
        
        // Gives random row and col coordinates for the nuts and puts them in the maze
        while (currentNut < totalNuts)
        {
            row = rand.nextInt((Maze.getMaxRow()));
            col = rand.nextInt((Maze.getMaxCol()));
            
            if(Maze.displayElement(row, col) == ' ')
            {
                theNut = nutList.get(currentNut);
                theNut.put(row, col);
                currentNut++;
            }
        }
    }
    
    // This function returns the Nuts nutritional value
    private int isNuts(char symbol)
    {
        if (symbol == 'A' || symbol == 'P')
        {
            return nutPoints;
        }
        else
        {
            return 0;
        }
    }
    
    // This function returns the total number of nuts static variable
    public static int getTotalNuts()
    {
        return totalNuts;
    }
    
    public static void eatNuts()
    {
        totalNuts--;
    }
    
    public int getNutPoints()
    {
        return nutPoints;
    }
}

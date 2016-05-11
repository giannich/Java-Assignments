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
public class Shrooms extends Edibles{
    
    private static int totalShrooms = 5;
    
    // Arraylist of Nuts
    private ArrayList<Shrooms> shroomsList = new ArrayList<Shrooms>();
    
    public Shrooms()
    {
        this.symbol = 'M';
        this.nutPoints = -15;
    }
    
    // Creates a bunch of Shrooms
    public void create()
    {   
        // Loop to fill the shrooms array
        for (int i = 0; i < totalShrooms; i++)
        {
            Shrooms aShroom = new Shrooms();
            shroomsList.add(aShroom);
        }
        
        // Initializes some values
        Random rand = new Random();
        int currentShroom = 0;
        Shrooms theShroom;
        int row;
        int col;
        
        // Gives random row and col coordinates for the nuts and puts them in the maze
        while (currentShroom < totalShrooms)
        {
            row = rand.nextInt((Maze.getMaxRow()));
            col = rand.nextInt((Maze.getMaxCol()));
            
            if(Maze.displayElement(row, col) == ' ')
            {
                theShroom = shroomsList.get(currentShroom);
                theShroom.put(row, col);
                currentShroom++;
            }
        }
    }
    
    // This function returns the total number of nuts static variable
    public static int getTotalShrooms()
    {
        return totalShrooms;
    }
    
    public static void eatShroom()
    {
        totalShrooms--;
    }
    
    public int getNutPoints()
    {
        return nutPoints;
    }
}

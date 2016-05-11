import java.util.Random;
import java.util.Scanner;
import java.lang.String;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
public class Squirrel extends Entity{
    
    private int points;
    private int totNutsCollected;
    
    private Almond aAlmond = new Almond();
    private Peanut aPeanut = new Peanut();
    private Shrooms aShroom = new Shrooms();
    
    public void create()
    {
        // Initializes the squirrel's symbol with a @ and sets up the while loop - Works
        this.symbol = '@';
        boolean create = true;
        
        Scanner console = new Scanner(System.in);
        
        while (create)
        {
            // Prompts the user to input a row and column
            System.out.println("Where do you want to put the squirrel?");
            System.out.println("The current Maze's size is " + Maze.getMaxRow() + " rows by " + Maze.getMaxCol() + " columns.");
            System.out.println("Please enter the position in the following format: row, column");
            System.out.println("If you would like to randomize the initial position, then just type Random (Not case sensitive).");
            
            // Reads line, splits input into two strings and puts them into a temporary array
            String positionInput = console.nextLine();
            
            // For randomize check
            positionInput = positionInput.toLowerCase();
            
            // Randomizing loop
            if (positionInput.contains("random"))
            {
                Random rand = new Random();
                boolean randomize = true;
                
                while (randomize)
                {
                    int tempRow = rand.nextInt((Maze.getMaxRow()));
                    int tempCol = rand.nextInt((Maze.getMaxCol()));

                    if(Maze.displayElement(tempRow, tempCol) == ' ')
                    {
                        System.out.println("A squirrel has been created in the following position: (" + (tempRow + 1) + ", " + (tempCol + 1) + ")!");
                        this.put(tempRow, tempCol);
                        randomize = false;
                        create = false;
                    }
                }
                continue;
            }
            
            // Splits into two arguments
            String[] positionArray = positionInput.split(", ");
            
            // Validation for input format - whether the inputs are exactly 2
            if (positionArray.length != 2)
            {
                System.out.println("Unrecognized input: the number of arguments is not equal to 2. "
                        + "Please try again and check that each argument is separated by a comma and followed by an empty space.");
                continue;
            }
            
            // Puts the coordinates into separate strings
            String tempStringRow = positionArray[0];
            String tempStringCol = positionArray[1];
            
            // Validation for input format - whether the inputs are integers
            if (!isInteger(tempStringRow) || !isInteger(tempStringCol))
            {
                System.out.println("Unrecognized input: the two arguments are not integers. Please try again.");
                continue;
            }

            // Finally parses the two arguments into integers
            int tempRow = Integer.parseInt(positionArray[0]);
            int tempCol = Integer.parseInt(positionArray[1]);
            
            // Make up for human counting difference from computer counting
            tempRow--;
            tempCol--;
            
            // Validation for more input formatting - minor errors
            // Row size too big or too small
            if (tempRow >= Maze.getMaxRow() || tempRow < 0)
            {
                System.out.println("The inputted row size is not within range. Please try again with a number between 1 and " + Maze.getMaxRow() + ".");
            }
            // Column size too big or too small
            else if (tempCol >= Maze.getMaxCol() || tempCol < 0)
            {
                System.out.println("The inputted column size is not within range. Please try again with a number between 1 and " + Maze.getMaxCol() + ".");
            }
            // Place is already occupied by a wall
            else if (Maze.displayElement(tempRow, tempCol) == '*')
            {
                System.out.println("You placed the Squirrel in a wall as highlighted below. Please try again.");
                Maze.replaceElement('#', tempRow, tempCol);
                Maze.display();
                Maze.replaceElement('*', tempRow, tempCol);
            }
            // Everything is fine
            else
            {
                System.out.println("A squirrel has been created in the following position: (" + (tempRow + 1) + ", " + (tempCol + 1) + ")!");
                this.put(tempRow, tempCol);
                create = false;
            }
        }
    }
    
    // Moving functions, need to verify
    
    public void moveLeft()
    {
        int oldRow = this.row;
        int oldCol = this.col;
        int newRow = this.row;
        int newCol = this.col - 1;
        
        if (newCol > 0)
        {
            moveCheck(oldRow, oldCol, newRow, newCol);
        }
        else
        {
            System.out.println("Cannot move to this position: You are going outside the maze.");
        }
    }
    
    public void moveRight()
    {
        int oldRow = this.row;
        int oldCol = this.col;
        int newRow = this.row;
        int newCol = this.col + 1;
        
        if (newCol <= Maze.getMaxCol())
        {
            moveCheck(oldRow, oldCol, newRow, newCol);
        }
        else
        {
            System.out.println("Cannot move to this position: You are going outside the maze.");
        }
    }
    
    public void moveUp()
    {
        int oldRow = this.row;
        int oldCol = this.col;
        int newRow = this.row - 1;
        int newCol = this.col;
        
        if (newRow > 0)
        {
            moveCheck(oldRow, oldCol, newRow, newCol);
        }
        else
        {
            System.out.println("Cannot move to this position: You are going outside the maze.");
        }
    }
    
    public void moveDown()
    {
        int oldRow = this.row;
        int oldCol = this.col;
        int newRow = this.row + 1;
        int newCol = this.col;
        
        if (newRow <= Maze.getMaxRow())
        {
            moveCheck(oldRow, oldCol, newRow, newCol);
        }
        else
        {
            System.out.println("Cannot move to this position: You are going outside the maze.");
        }
    }
    
    // Function to check if the movement is valid; includes actual move too - Incomplete
    private void moveCheck(int oldRow, int oldCol, int newRow, int newCol)
    {        
        char retChar = Maze.displayElement(newRow, newCol);
        
        switch (retChar)
        {
            case '*':   System.out.println("Cannot move to this position: there is a wall there.");
                        break;
            
            case 'A':   this.points += aAlmond.getNutPoints();
                        this.totNutsCollected++;
                        Nuts.eatNuts();
                        System.out.println("!!! Squirrel got " + aAlmond.getNutPoints() + " points (Total " + this.points + " points) !!!");
                        System.out.println("There are still " + Nuts.getTotalNuts() + " nuts and " + Shrooms.getTotalShrooms() + " poisonous mushrooms left!");
                        this.moveDo(oldRow, oldCol, newRow, newCol);
                        break;
            
            case 'P':   this.points += aPeanut.getNutPoints();
                        this.totNutsCollected++;
                        Nuts.eatNuts();
                        System.out.println("!!! Squirrel got " + aPeanut.getNutPoints() + " points (Total " + this.points + " points) !!!");
                        System.out.println("There are still " + Nuts.getTotalNuts() + " nuts and " + Shrooms.getTotalShrooms() + " poisonous mushrooms left!");
                        this.moveDo(oldRow, oldCol, newRow, newCol);
                        break;
            
            case 'M':   this.points += aShroom.getNutPoints();
                        Shrooms.eatShroom();
                        System.out.println("!!! Squirrel got " + aShroom.getNutPoints() + " points (Total " + this.points + " points) !!!");
                        System.out.println("There are still " + Nuts.getTotalNuts() + " nuts and " + Shrooms.getTotalShrooms() + " poisonous mushrooms left!");
                        this.moveDo(oldRow, oldCol, newRow, newCol);
                        break;
            
            case ' ':   System.out.println("The Squirrel moved into (" + (newRow + 1) + ", " + (newCol + 1) + ").");
                        this.moveDo(oldRow, oldCol, newRow, newCol);
                        break;
                        
            default:    System.out.println("The Squirrel tried to move into an unknown object. It turned back.");
        }
    }
    
    private void moveDo(int oldRow, int oldCol, int newRow, int newCol)
    {
        Maze.swapElement(oldRow, oldCol, newRow, newCol);
        Maze.replaceElement(' ', oldRow, oldCol);
        Maze.display();
        this.row = newRow;
        this.col = newCol;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    private static boolean isInteger(String str) 
    {
        if (str == null) 
        {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}

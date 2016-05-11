import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
public class HungrySquirrelGame {
        
    public static void main(String[] args) { 
        
        // 1. Instantiate maze and create maze object - Complete
                
        // Ask for file path
        Scanner console = new Scanner(System.in);
        System.out.println("Please input the path of the input file:");
        String inputFilePath = console.nextLine();
        
        Maze.create(inputFilePath);
        Maze.display();
        
        // 2. Instantiate squirrel object and prompt user to put it somewhere - Complete
                    
        Squirrel aSquirrel = new Squirrel();
        aSquirrel.create();
        
        // 3. Instantiate an array of nuts and determine the type of nuts created - Complete
        
        Nuts aNuts = new Nuts();
        aNuts.create();
        
        Shrooms aShroom = new Shrooms();
        aShroom.create();
        
        // 4. Display the maze with all the created entities - Complete
                        
        System.out.println("The maze has been filled with nuts, please look carefully at the map below:");
        Maze.display();
        
        // 5. Accept user input to move the squirrel - Complete
        
        boolean running = true;
        String userInput;
        char userInputChar;
        
        while (running)
        {
            System.out.println("Where would you like to move the squirrel? (Hint: enter H for help, not case sensitive)");
            userInput = console.next();
            
            // Transform input into lower case of first char
            userInput = userInput.toUpperCase();
            userInputChar = userInput.charAt(0);
            
            switch (userInputChar)
            {
                case 'H':   displayHelp();
                            break;

                case 'L':   aSquirrel.moveLeft();
                            break;

                case 'R':   aSquirrel.moveRight();
                            break;

                case 'U':   aSquirrel.moveUp();
                            break;

                case 'D':   aSquirrel.moveDown();
                            break;
                
                case 'E':   exitGame();
                            break;

                default:    System.out.println("Unrecognized input, please try again.");
            }
            
            // Validate if all the nuts are collected
            if(aNuts.getTotalNuts() <= 0)
            {
                System.out.println("Squirrel successfully collected all the nuts. Total points: " + aSquirrel.getPoints() + ".");
                System.out.println("Thank you for playing this game");
                exitGame();
                running = false;
                continue;
            }
            
            // Validate if points are below 0
            if(aSquirrel.getPoints() < 0)
            {
                System.out.println("Squirrel ate a poisonous mushroom and died due to starvation. Game over!");
                exitGame();
                running = false;
                continue;
            }
        }
        
        // 6. For every move, the maze should be displayed - Completed
        
        // 7. For every newly collected nut, an output message should be displayed - Completed
        
        // 8. Once all the nuts are collected, a message should be displayed - Completed

    }
    
    private static void displayHelp()
    {
        System.out.println("Welcome to the help screen!");
        System.out.println("The objective of the game is for the Squirrel to collect all the nuts");
        System.out.println("Each Almond is worth 5 points, while each peanut is worth 10 points");
        System.out.println("");
        System.out.println("The following are the commands that you can input:");
        System.out.println("\tH\tDisplays the help screen");
        System.out.println("\tL\tMoves Squirrel left");
        System.out.println("\tR\tMoves Squirrel right");
        System.out.println("\tU\tMoves Squirrel up");
        System.out.println("\tD\tMoves Squirrel down");
        System.out.println("\tE\tExits the game");
        
    }
    
    private static void exitGame()
    {
        System.out.println("The application will now close. Enter anything to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        System.exit(0);
        
    }
    
}

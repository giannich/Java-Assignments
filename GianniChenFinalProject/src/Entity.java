/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
abstract public class Entity {
    
    protected char symbol;
    protected int row;
    protected int col;
    
    abstract void create();
    
    public char put(int newRow, int newCol)
    {
        // Gets the current character in the maze
        char oldChar = Maze.displayElement(newRow, newCol);
        
        // If the character is not a wall, then the function replaces it with the object's symbol
        // Otherwise it returns the wall symbol
        if (oldChar != '*')
        {
            // Replaces symbol, returns the replaced symbol into replacedChar, and changes the positions of the entity
            char replacedChar = Maze.replaceElement(symbol, newRow, newCol);
            this.row = newRow;
            this.col = newCol;
            return replacedChar;
        }
        else
        {
            return oldChar;
        }
    }
}

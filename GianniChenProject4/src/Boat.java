/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
public class Boat {
    
    String name;
    boolean sailPosition;
    float speed;
    
    public Boat (String boatName)
    {
        name = boatName;
        sailPosition = false;
        speed = 0;
    }
    public void goFast()
    {
        this.sailPosition = true;
        this.speed += 10;
        if (this.speed >= 100)
        {
            this.speed = 100;
        }
        System.out.println(name + " is raising the sail at the speed of 10 mph");
    }
    
    public void goSlow()
    {
        this.sailPosition = false;
        this.speed -= 5;
        if (this.speed <= 0)
        {
            this.speed = 0;
        }
        System.out.println(name + " is lowering the sail at the speed of 5 mph");
    }
        
    public void whereIsTheSail()
    {
        if (this.sailPosition)
        {
            System.out.println(name + " sail is up");
        }
        else
        {
            System.out.println(name + " sail is down");
        }
    }
}

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
    
    private String name;
    private int speed;
    private int angle;
    private boolean power;
    
    public Boat()
    {
        name = "No Name";
        speed = 0;
        angle = 0;
        power = false;
        
        System.out.println("A boat by the name of " + this.name + " was created moving in " + this.angle + " deg angle at the speed of " + this.speed + " mph.");
    }
    
    public Boat(String name)
    {
        this.name = name;
        speed = 0;
        angle = 0;
        power = false;
        
        System.out.println("A boat by the name of " + this.name + " was created moving in " + this.angle + " deg angle at the speed of " + this.speed + " mph.");
    }
    
    public Boat(String name, int speed, int angle, boolean power)
    {
        this.name = name;
        this.speed = speed;
        this.angle = angle;
        this.power = power;
        
        System.out.println("A boat by the name of " + this.name + " was created moving in " + this.angle + " deg angle at the speed of " + this.speed + " mph.");
    }
    
    public String CommandInput(String command)
    {
        String output;
        
        
        switch(command) 
        {
            case "power on":    this.power = true;
                                output = this.name + 
                                        " is pointing in the direction of " +
                                        this.angle + " deg.";
                                break;
                                
            case "power off":   this.power = false;
                                output = this.name + " is powered off.";
                                break;
                                
            case "speed up":    this.speed += 2;
                                output = this.name + " is moving in " +
                                        this.angle + " deg angle at the speed of " +
                                        this.speed + " mph.";
                                break;
                                
            case "speed down":  if (this.speed <= 0)
                                    {   
                                        output = "Cannot slow down when stationary.";
                                    }
                                else
                                    {
                                        this.speed -= 2;
                                        output = this.name + " is moving in " +
                                            this.angle + " deg angle at the speed of " +
                                            this.speed + " mph.";
                                    }
                                break;
            
            case "turn left":   this.angle -= 5;
                                if (this.angle < -180)
                                {
                                    this.angle += 360;
                                }
                                output = this.name + " is in " + this.angle + 
                                        " deg angle.";
                                break;
                                
            case "turn right":  this.angle += 5;
                                if (this.angle >= 180)
                                {
                                    this.angle -= 360;
                                }
                                output = this.name + " is in " + this.angle + 
                                        " deg angle.";
                                break;
                                
                                // Invalid command
            default:            output = command + " is an invalid command.";
        }

        return output;
    }
    
}

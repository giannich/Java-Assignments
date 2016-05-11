/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianni
 */
public class SimpleBoatMain {
    public static void main (String[] args) {

        Boat simpleBoat = new Boat("Destinty");

        simpleBoat.goFast();   

        simpleBoat.goSlow();

        simpleBoat.whereIsTheSail();

        simpleBoat.goFast();

        simpleBoat.whereIsTheSail();

    }
}

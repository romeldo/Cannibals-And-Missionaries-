/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author limingchu
 */
/* This class was implemented to control the Boat movement and obtain the 
 * Boat information
*/
public class BoatPos {
    private String boatpos;
    /* This method was called at the begining of the Game
     * the Boat position was set to the "left"*/
    public void setPos(){
        boatpos = "left";
    }
    /* This method was implemented to get the current Boat position
    */
    public String getPos(){
        return boatpos;
    }
    /* This method was called after the two passengers on board
     * if the current Boat position is at "left" side
     * then move the Boat to "right"
     * if the current Boat position is at "right" side
     * then mobe the Boat to "left"
    */
    public void moveBoat(){
        if(boatpos.equals("left")){
            boatpos = "right";
        }
        else{
            boatpos = "left";
        }
    }
    /* This method was called to print the Boat position at the 
     * "left" side or "right" side
    */
    public void printBoat(){
        if(boatpos.equals("left")){
            System.out.println("<Boat>-----------------------------------");
        }
        else{
            System.out.println("-----------------------------------<Boat>");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author limingchu
 */
/* This class was implemented to obtain the Round information */
public class Round {
    private int round;
    /* This method was called when each Round start
     * return the current Round number
    */
    public int getRound(){
        return round;
    }
    /* This method was called when the Game goes into next Round 
     * increase the Round number and return next Round number
    */
    public int nextRound(){
        return round++;
    }
    /* THis method was called at begining of the Game
     * reset the Round number to zero
    */
    public void resetRound(){
        round = 0;
    }
}

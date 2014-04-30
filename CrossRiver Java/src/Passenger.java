
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author limingchu
 */
/* This class was implemented to obtain the passenger information
 * on both sides, there are two ArrayList to store the cannibals
 * and Missionaries on two sides. 
 * And also contorl the passenger movement between sides, there 
 * 4 counters to count the number of cannibals and Missionaries
 * on both sides, if cannibals on board and move from left to right
 * then leftC-- and rightC++, else leftC++ and rightC--.
 * if Missionaries on board and move from left to right, then
 * leftM-- and rightM++, else leftM++ and rightM--
 */
public class Passenger {
    private List<String> pass_left = new ArrayList<String>();
    private List<String> pass_right = new ArrayList<String>();
    private int leftC;
    private int leftM;
    private int rightC;
    private int rightM;
    /* This method was implemented to get the counter value of 
     * cannibals on left side
    */
    public int getLeftC() {
        return leftC;
    }
    /* This method was implemented to get the counter value of 
     * Missionaries on left side
    */
    public int getLeftM() {
        return leftM;
    }
    /* This method was implemented to get the counter value of 
     * cannibals on right side
    */
    public int getRightC() {
        return rightC;
    }
    /* This method was implemented to get the counter value of 
     * Missionaries on right side
    */
    public int getRightM() {
        return rightM;
    }
    /* This method was called at the begining of the Game, all
     * passengers are on left side, MMMCCC. 
     * And the counter value are leftC = 3, leftM = 3, rightC = 0
     * rightM = 0
     */
    public void initPassenger(){
        pass_left.add("M");
        pass_left.add("M");
        pass_left.add("M");
        pass_left.add("C");
        pass_left.add("C");
        pass_left.add("C");
        leftC = 3;
        leftM = 3;
        rightC = 0;
        rightM = 0;
    }
    /* This method was implemented to get the ArrayList of the 
     * passengers on left side
     */
    public List<String> getLeftPassenger(){
        return pass_left;
        
    }
    /* This method was implemented to get the ArrayList of the 
     * passengers on right side
     */
    public List<String> getRightPassenger(){
        return pass_right;
        
    }
    /* This method was called when the Boat on left side, and move
     * the passengers from left to right. The passenger to move was 
     * from user input, if user input "C", which means move cannibals
     * from left to right, then left ArrayList called remove(), and 
     * right ArrayList called add(). And counter value of passenger
     * leftC-- and rightC++. 
     * Same for move Missionaries from left to right*/
    public void leftPasOnBoard(String who){
        
        pass_left.remove(who);  
        pass_right.add(who);
        if(who.equalsIgnoreCase("C")){
            leftC--;
            rightC++;
        }
        if(who.equalsIgnoreCase("M")){
            leftM--;
            rightM++;
        }
    }
    /* This method was called when the Boat on right side, and move
     * the passengers from right to left. The passenger to move was 
     * from user input, if user input "C", which means move cannibals
     * from right to left, then right ArrayList called remove(), and 
     * left ArrayList called add(). And counter value of passenger
     * rightC-- and leftC++. 
     * Same for move Missionaries from right to left*/
    public void rightPasOnBoard(String who){

        pass_right.remove(who);  
        pass_left.add(who);
        
        if(who.equalsIgnoreCase("C")){
            rightC--;
            leftC++;
        }
        if(who.equalsIgnoreCase("M")){
            rightM--;
            leftM++;
        }
    }
    /* This method was called to print the passenger infromation
     * on both sides. For all elements in left ArrayList, print
     * the elements on one line. And for all elements in right
     * ArrayList, print the elements on one line. If there is no
     * elements in the ArrayList, then print nothing
     */
    public void printPassenger(){
        for(String pas : pass_left){
            System.out.print(pas);
        }
        System.out.print("                                   ");
        if(!pass_right.isEmpty()){
            for(String pas : pass_right){
                System.out.print(pas);
        }
        }
        else{
            System.out.print("");
        }
        
        System.out.println("");
    }
}

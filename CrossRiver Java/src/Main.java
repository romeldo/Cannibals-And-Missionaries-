
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author limingchu
 */
/* This is the main class of the Game
*/
public class Main {
    
    private Round round = new Round();
    private BoatPos boatpos = new BoatPos();
    private Passenger pas = new Passenger();
    private Scanner in = new Scanner(System.in);

    private List<String> pass_left = new ArrayList<String>();
    private List<String> pass_right = new ArrayList<String>();
    
    private static int WIN = 1;
    private static int LOSE = 2;
    private static int CONTINUE = 3;
    private int status = 3;
    private boolean b;
    /* This method was implemented to initial the Game, and it is 
     * called at begining or reset of the Game. The Round number 
     * was reset to zero, Boat position was on "left" side, and 
     * initial the passenger information in the two ArrayList.
     * Then there are two functions to control the passenger
     * on board, which are FirstPassengerOnBoard(), and 
     * SecondPassengerOnBoard(). After the passenger on board,
     * then move the Boat from left to right, and check the 
     * win/lose condition by calling WinnerCheck() function,
     * if neither win nor lose, then continue to next Round
     */
    public void initGame(){
        round.resetRound();
        boatpos.setPos();
        pas.initPassenger();
        System.out.println("Crossing the River");
        System.out.println("-----------------------------------------");
        System.out.println("Round " + round.getRound());
        System.out.println("Left                                Right");
        pas.printPassenger();
        boatpos.printBoat();
        FirstPassengerOnBoard();
        SecondPassengerOnBoard();
        boatpos.moveBoat();

        WinnerCheck();
        nextRound();       
    }
    /* This is a recursion method that execute the next Round of 
     * the Game. Each time this method was called, the Round number
     * was increased once, and get the Boat position from the last 
     * call and print the Boat position. 
     * After the two functions that control passenger on board, 
     * move the Boat from current position to other. then check 
     * the win/lose condition by calling WinnerCheck() function,
     * if neither win nor lose,  continue to next Round
     */
    public void nextRound(){
        WinnerCheck();

        round.nextRound();
        boatpos.getPos();
        System.out.println("-----------------------------------------");
        System.out.println("Round " + round.getRound());
        System.out.println("Left                                Right");
        pas.printPassenger();
        boatpos.printBoat();
        FirstPassengerOnBoard();
        SecondPassengerOnBoard();
        boatpos.moveBoat();
       // WinnerCheck();
        nextRound();

    }
    /* This recursion method was implemented to control the fisrt passenger
     * on board. First get the two passenger ArrayList on both sides
     * then ask for the user input, c for cannibal, m for missionary,
     * the input was validated by checking the input satisfied the 
     * a specified pattern, [cm]. If the input was satisfied, then 
     * check the user input "C" or "M", based on the current Boat
     * position, then call leftPasOnBoard() or rightPasOnBoard() 
     * function from Passenger class, else repeat this method.
     * The status of the two passenger ArrayList if they contain
     * the user input was also validate, if the pasaenger ArrayList
     * does not contain the user input, this method was repeated.
     */
    public void FirstPassengerOnBoard(){
        String pos = boatpos.getPos();
        String passenger;
        pass_left = pas.getLeftPassenger();
        pass_right = pas.getRightPassenger();
        System.out.println("First passenger (c for cannibal, m for missionary)");
        
        while(!in.hasNext("[cm]")){
            System.out.println(" Illegal Input! ");
            System.out.println("First passenger (c for cannibal, m for missionary)");
            passenger = in.next();
            
        }
        passenger = in.next();
        
        if(pos.equals("left")){
            if(passenger.equalsIgnoreCase("C")){
                if(pass_left.contains("C")){
                    pas.leftPasOnBoard("C");
                }
                else{
                    System.out.println("No more cannibal");
                    FirstPassengerOnBoard();
                }
            }
            if(passenger.equalsIgnoreCase("M")){
                if(pass_left.contains("M")){
                    pas.leftPasOnBoard("M");
                }
                else{
                    System.out.println("No more missionary");
                    FirstPassengerOnBoard();
                }
            }
        }
        if(pos.equals("right")){
            if(passenger.equalsIgnoreCase("C")){
                if(pass_right.contains("C")){
                    pas.rightPasOnBoard("C");
                }
                else{
                    System.out.println("No more cannibal");
                    FirstPassengerOnBoard();
                }
            }
            if(passenger.equalsIgnoreCase("M")){
                if(pass_right.contains("M")){
                    pas.rightPasOnBoard("M");
                }
                else{
                    System.out.println("No more missionary");
                    FirstPassengerOnBoard();
                }
            }
        }
    }
    /* This recursion method was implemented to control the 2nd passenger
     * on board. First get the two passenger ArrayList on both sides
     * then ask for the user input, c for cannibal, m for missionary,
     * the input was validated by checking the input satisfied the 
     * a specified pattern, [cmn]. If the input was satisfied, then 
     * check the user input "C", "M" or "N". If user input "N",
     * which means no 2nd passenger on board, then do nothing,
     * else based on the current Boat position, then call 
     * leftPasOnBoard() or rightPasOnBoard() function from Passenger 
     * class, if the input not satisfied, repeat this method.
     * The status of the two passenger ArrayList if they contain
     * the user input was also validate, if the pasaenger ArrayList
     * does not contain the user input, this method was repeated.
     */
    public void SecondPassengerOnBoard(){
        String pos = boatpos.getPos();
        String passenger;
        pass_left = pas.getLeftPassenger();
        pass_right = pas.getRightPassenger();
                
        System.out.println("Second passenger (c for cannibal, m for missionary, n for none)");
        
        while(!in.hasNext("[cmn]")){
            System.out.println(" Illegal Input! ");
            System.out.println("Second passenger (c for cannibal, m for missionary, n for none)");
            passenger = in.next();
            
        }
        passenger = in.next();
        
        if(pos.equals("left")){
            if(passenger.equalsIgnoreCase("C")){
                if(pass_left.contains("C")){
                    pas.leftPasOnBoard("C");
                }
                else{
                    System.out.println("No more cannibal");
                    SecondPassengerOnBoard();
                }
            }
            else if(passenger.equalsIgnoreCase("M")){
                if(pass_left.contains("M")){
                    pas.leftPasOnBoard("M");
                }
                else{
                    System.out.println("No more missionary");
                    SecondPassengerOnBoard();
                }
            }
            else{
                
            }
        }
        if(pos.equals("right")){
            if(passenger.equalsIgnoreCase("C")){
                if(pass_right.contains("C")){
                    pas.rightPasOnBoard("C");
                }
                else{
                    System.out.println("No more cannibal");
                    SecondPassengerOnBoard();
                }
            }
            else if(passenger.equalsIgnoreCase("M")){
                if(pass_right.contains("M")){
                    pas.rightPasOnBoard("M");
                }
                else{
                    System.out.println("No more missionary");
                    SecondPassengerOnBoard();
                }
            }
            else{
                
            }
        }
    }
    /* This method was implemented to check the status of win/lose 
     * or continue. The alforithm to check is: for win, if passenger 
     * ArrayList on left side is empty, and the Boat position is 
     * on right side; for lose, if the counter of cannibals is 
     * greater than the counter of Missionaries on either side, 
     * and the counter value of Missionaries on both side is 
     * not equal to zero; else, all the other conditions, the 
     * Game will continue.
     * Based on the above conditions, the status will be set to 
     * the value accordingly*/
    public void WinnerCheck(){

    String pos = boatpos.getPos();
//    pass_left = pas.getLeftPassenger();
//    pass_right = pas.getRightPassenger();
    if(pas.getLeftC() ==0 && pas.getLeftM() == 0 && pos.equals("right")){
        setStatus(WIN);
        
        pass_left.clear();
            pass_right.clear();
            System.out.println("Congratulations! You win the game in " + round.getRound() + " rounds.");
            initGame();
    }

    if(!pass_left.isEmpty() || !pass_right.isEmpty()){
        if(pas.getLeftM() != 0 && pas.getRightM()!= 0){
            if(pas.getLeftC() > pas.getLeftM() || pas.getRightC() > pas.getRightM()){
            setStatus(LOSE);
            
            pass_left.clear();
            pass_right.clear();
            System.out.println("Missionaries eaten by cannibals! You lose!");
            initGame();
        }
        }
        
    }

    if(!pass_left.isEmpty() || !pass_right.isEmpty()){
        if(pas.getLeftM() != 0 && pas.getRightM() != 0){
            if(pas.getLeftC() <= pas.getLeftM() && pas.getRightC() <= pas.getRightM()){
                setStatus(CONTINUE);
            }
        }
        else if(pas.getLeftM() == 0 && pas.getRightM() != 0){
            if(pas.getRightC() <= pas.getRightM()){
                setStatus(CONTINUE);
            }
        }
        else if(pas.getLeftM() != 0 && pas.getRightM() == 0){
            if(pas.getLeftC() <= pas.getLeftM()){
                setStatus(CONTINUE);
            }
        }
    }
    
}

    /* This method was implemented to get the value of win/lose status
    */
    public int getStatus(){
        return status;
    }
    /* This method was implemented to set the vaule of win/lose status
    */
    public void setStatus(int num){
        this.status = num;
    }
    /* The main method to start this program
    */ 
    public static void main(String[] args){
        
        Main m = new Main();
        m.initGame();

     }
             
}

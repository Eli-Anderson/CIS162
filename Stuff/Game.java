import java.util.Scanner;
/***********************************************
 * Write a description of the Game class here.
 * 
 * @author 
 * @version 
 ***********************************************/
public class Game
{
    /** Objects of the GVdie class  */
    private GVdie d1;
    private GVdie d2;
    private GVdie d3;
    // Declare d2 and d3 as objects of the GVdie class.

    /** credit balance  */
    private int credits;

    private String currentMessage;

    /** current message to store the messages from the game  */
    
    
    /********************************************
     * Constructor for objects of class Chuck
     *******************************************/
    public Game(String message)
    {
        // instantiate the 3 GVdie 
        d1 = new GVdie(6);
        d2 = new GVdie(6);
        d3 = new GVdie(6);

        // initialize credits to 0
        credits = 0;

        // initialize message 
        currentMessage = "";

    }

    /************************************************
     * getMessage - returns the message
     ***********************************************/
    public String getMessage ( ) 
    {
        return currentMessage;
    }

    /************************************************
     * setMessage - sets the message to the input
     * parameter
     ***********************************************/
    public void setMessage (String message) 
    {
        currentMessage = message;
    }

    /************************************************
     * getCredits - returns the credits
     ***********************************************/    
    public int getCredits ( )
    {
        return credits;
    }

    /************************************************
     * addCredits - add  amount to the credits.  
     ***********************************************/    
    public void addCredits (int amount) 
    {
        credits += amount;
    }

    /***********************************************************
     * rollDice - Roll the three dice invoking the roll method of the 
     * GVdie class
     **********************************************************/        
    public void rollDice ( ) 
    {
        d1.roll();
        d2.roll();
        d3.roll();
        // complete to roll d2 and d3
    }

    /***********************************************************
     * return true if two of the dice match num, 
     * return false otherwise.
     **********************************************************/       
    public boolean isDoubles (int num) 
    {
        int v1 = d1.getValue();
        int v2 = d2.getValue();
        int v3 = d3.getValue();
        // complete  to get the value of d2 and d3

        // write the required logic 
        if (v1 == v2 && v2 != v3) return true;
        if (v2 == v3 && v3 != v1) return true;
        return false;
    }

    /***********************************************************
     *return true if all three dice are identical to the number
     *passed as parameter. return false otherwise.
     **********************************************************/
    public boolean isTriplets (int num ) 
    {
        int v1 = d1.getValue();
        int v2 = d2.getValue();
        int v3 = d3.getValue();
        // complete to get the value of d2 and d3

        // write the required logic 
        if (v1 == v2 && v2 == v3) return true;
        return false;
    }

    /***********************************************************
     *return true if the num passed as parameter was rolled
     **********************************************************/
    public boolean wasNumberRolled(int num ) 
    {
        int v1 = d1.getValue();
        int v2 = d2.getValue();
        int v3 = d3.getValue();
        // complete  to get the value of d2 and d3

        // write the required logic 
        if (num == v1 || num == v2 || num == v3) return true;
        return false;
    }

    /***********************************************************
     *return the value of the die passed as parameter
     **********************************************************/
    public int getDieValue (int num)
    {
        if (num == 1)
            return d1.getValue();
        else if (num == 2)
            return d2.getValue();
        else
            return d3.getValue();
        // continue with the logic to return value of d2 and value of d3

    }

    /***********************************************************
     *Check how many of the dice match num.  
     *If all three dice, increase the credits by 30.  
     *If only two dice, increase the credits by 20  
     *If only one die, increase credits by 10  
     **********************************************************/     
    public static void main (String [] args ) 
    {
        Scanner scan = new Scanner (System.in);
        int guess;

        // instantiate an object of the Game class named myGame.  Pass 
        Game myGame = new Game("Welcome to our game!");
        // an interesting message as input parameter!

        // Printing the initial message from the game
        System.out.println(myGame.getMessage());

        //Prompts the user to guess an integer number between 1 - 6   
        System.out.print("Guess a number between 1 and 6: ");
        guess = scan.nextInt();
        
        
        System.out.println("your guess was: " + guess);
       
        // invoke the rollDice method of the game class
        game.rollDice();
    
        
        // Printing the values of the rolled dice
        System.out.println("Die1 is: " + myGame.getDieValue(1));
        // complete for Die2 and Die3
        System.out.println("Die2 is: " + myGame.getDieValue(2));
        System.out.println("Die3 is: " + myGame.getDieValue(3));




        // Ask the question to know if the number that the user 
        // guessed was rolled by the computer 3 times - invoke 
        // the isTripplets method
        if (                             )
        {
            // add 30 to the credits
            
            // set the message to "Tripples!"

        }
        else 

        // Complete the logic for doubles and wasNumberRolled

        
        
        // printing the results of the game
            System.out.println ("Results: " + myGame.getMessage() + " Credits: " + myGame.getCredits());
    }
}


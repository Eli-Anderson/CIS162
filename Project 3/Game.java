
/**
 * A very simple text-based UI for the Pig class. Allows for a range of inputs, and prints the needed information to play easily
 * play the game
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Game
{
    final private static String version = "v2017.6.20";

    public static void main (String[] a) {
        Pig p = new Pig();
        Scanner in = new Scanner(System.in);
        char action;

        System.out.println("Welcome to Pig");

        while (true) {
            if ( p.playerWon() || p.computerWon() ) { /* if game is already over, do not allow continued play */
                System.out.print("Game over! What would you like to do? (N)ew Game or (Q)uit? ");
                action = Character.toUpperCase(in.next().charAt(0));
                
                if (action != 'N' && action != 'Q') { /* if input will not quit or restart, just ignore it */
                    continue;
                }
            } else { /* if game is not over yet */
                System.out.print("What would you like to do? (R)oll, (H)old, (N)ew Game, or (Q)uit? ");
                action = Character.toUpperCase(in.next().charAt(0));
            }
            switch (action) {

                case 'Q': /* user wants to quit */
                    System.out.println("Goodbye.");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Developed by Elijah Anderson - " + version);
                    return;

                /* ****** */

                case 'R': /* user wants to roll */
                    p.playerRolls();
                    if (p.oneRolled()) {
                        if (p.snakeEyesRolled()) { /* snake eyes... reset score, print message */
                            p.scorePlayer = 0;
                            System.out.println("");
                            System.out.println("          Oh shoot, you rolled snake eyes!");
                        } else { /* one is rolled (and not snake eyes), round is reset automatically in Pig class */
                            System.out.println("");
                            System.out.println("          Darn, you rolled a one");
                        }
                        printBoard(p);
                        doComputersTurn(p); /* does the computer's turn, since a one was rolled ending user's turn */
                    } else {
                        printBoard(p);
                    }
                    break;

                /* ****** */

                case 'H': /* user wants to hold */
                    p.playerHolds();
                    if (p.playerWon()) {
                        System.out.println("You won!"); /* prints message, future iterations will not allow further play */
                    } else {
                        doComputersTurn(p);
                    }
                    break;

                /* ****** */

                case 'N': /* user wants to restart the game */
                    restartGame(p);
            }
        }
    }

    public static void doComputersTurn (Pig p) { /* handles printing some information to make it easier to understand the computer's turn while in game */
        System.out.println("*");
        System.out.println("Computer's Turn");
        System.out.println("*");

        p.computerTurn();

        printBoard(p);

        System.out.println("*");
        System.out.println("End of Computer's Turn");
        System.out.println("*");

        if (p.computerWon()) {
            System.out.println("          You lost!");
        }
    }

    public static void printBoard (Pig p) { /* prints out the current game information */
        System.out.println("***********************");
        System.out.println("Dice: " + p.die1.getValue() + ", " + p.die2.getValue());
        System.out.println("Round: " + p.getRoundScore());
        System.out.println("Player Score: " + p.getPlayerScore());
        System.out.println("Cpu Score: " + p.getCpuScore());
        System.out.println("***********************");
        System.out.println("");
    }

    private static void restartGame (Pig p) {
        p.restart();
        System.out.println("Game restarted");
    }
}

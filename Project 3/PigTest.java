import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class for Pig.
 *
 * @author  Elijah Anderson
 * @version 2017.6.20
 */
public class PigTest {

    @Test
    public void testGetRoundScore ( ) { /* – return the current round score. */
        Pig p = new Pig();
        p.playerRolls();
        while (p.oneRolled()) p.playerRolls(); /* makes sure round score is not 0 */
        assertEquals(p.getDieValue(1) + p.getDieValue(2), p.getRoundScore());
    }

    /* * */

    @Test
    public void testPlayerRolls ( ) { /* - Tests that the dice are rolled properly during player's turn */
        Pig p = new Pig();
        int d1Value = p.getDieValue(1);
        int d2Value = p.getDieValue(2);
        p.playerRolls();
        int numOfSameRolls = 0;
        for (int n=0; n < 1000; n++) {
            if (d1Value == p.getDieValue(1) && d2Value == p.getDieValue(2)) {
                numOfSameRolls ++;
            }
            d1Value = p.getDieValue(1);
            d2Value = p.getDieValue(2);
            p.playerRolls();
        }
        assertTrue(numOfSameRolls < 1000); /* the chances of rolling the same dice 1000 times in a row is 1 / (36 ^ 1000) */

    }

    /* * */

    @Test
    public void testPlayerHolds ( ) { /* Makes sure that player's score is updated properly at end of playerHolds, and that getPlayerScore returns correct integer */
        Pig p = new Pig();
        p.playerRolls();
        while (p.oneRolled()) {
            p.playerRolls();
        }
        int roundScore = p.getRoundScore();
        p.playerHolds();
        assertEquals(roundScore, p.getPlayerScore());
        
    }

    /* * */

    @Test
    public void testComputerTurn ( ) { /* Assures that all sequences of the computer's turn function properly */
        Pig p = new Pig();

        while (true) { // test snake eyes
            p.computerTurn();
            if (p.snakeEyesRolled()) {
                assertEquals(p.getCpuScore(), 0);
                break;
            } else {
                p.scoreCpu = -1;
            }
        }
        p.scoreCpu = -1;
        while (true) { // test that round score is reset if one rolled (that cpu score is unchanged)
            p.computerTurn();
            if (p.oneRolled()) {
                assertTrue( p.getCpuScore() == -1);
                break;
            } else {
                p.scoreCpu = -1;
            }
        }
    }

    /* * */

    @Test
    public void testSetRoundScore () {
        Pig p = new Pig();
        // p.setRoundScore(10);   can't do this since it is private
        p.playerRolls();
        while (p.oneRolled()) p.playerRolls(); /* makes sure the round score is > 0 */

        assertTrue(p.getRoundScore() > 0);
    }

    /* * */

    public void simulatePlayersTurn (Pig p) { // used within the simulateGame test method
        p.playerRolls();
        while (!p.oneRolled() && p.getRoundScore() <= 19 && p.getPlayerScore() + p.getRoundScore() < p.SCORE_FOR_WIN) {
            p.playerRolls();
        }
        p.playerHolds();
        
    }

    /* * */
    
    @Test
    public void simulateGame () {
        Pig p = new Pig();

        while (true) {
            simulatePlayersTurn(p);
            if (p.playerWon()) {
                assertTrue(p.playerWon());
                return;
            }
            p.computerTurn();
            if (p.computerWon()) {
                assertTrue(p.computerWon());
                return;
            }
        }
    }
}
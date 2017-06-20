
/**
 * A class used to play the game of Pig. Does not include any UI or input, so must be used within another class in order to
 * actually play the game. Does include basic AI methods, score tracking, the ability to restart, and other features.
 *
 * @author Elijah Anderson
 * @version 2017.6.20
 */
public class Pig
{
    /*
    Maintain two GVdie objects, player’s score, computer’s score, current round score, and a constant for the winning score of 100.
    */
    GVdie die1, die2;
    int scorePlayer, scoreCpu, scoreRound;
    public final int SCORE_FOR_WIN = 100;

    public Pig ( ) { /* - a constructor that initializes all of the instance variables to appropriate values, instantiates two dice. */
        die1 = new GVdie(6);
        die2 = new GVdie(6);
        scorePlayer = scoreCpu = scoreRound = 0; /* bad practice? */
    }

    private void setRoundScore (int a) {
        scoreRound = a;
    }

    private void addRoundScore (int a) {
        scoreRound += a;
    }

    public int getRoundScore ( ) { /* – return the current round score. */
        return scoreRound;
    }

    public int getPlayerScore ( ) { /* – return the player’s score. */
        return scorePlayer;
    }

    public int getCpuScore ( ) { /* – return the computer’s score. */
        return scoreCpu;
    }

    public int getDieValue (int n) {
        if (n == 1) return die1.getValue();
        if (n == 2) return die2.getValue();
        return 0;
    }

    public boolean playerWon ( ) { /* - return true if the player score is currently high enough to win. Otherwise, return false. */
        return scorePlayer >= SCORE_FOR_WIN;
    }

    public boolean computerWon ( ) { /* - return true if the computer score is currently high enough to win. Otherwise, return false. */
        return scoreCpu >= SCORE_FOR_WIN;
    }

    public boolean oneRolled () {
        return getDieValue(1) == 1 || getDieValue(2) == 1;
    }

    public boolean snakeEyesRolled () {
        return getDieValue(1) == 1 && getDieValue(2) == 1;
    }

    private void rollDice ( ) { /* - roll both dice. If 1 is rolled, round score = 0. Otherwise, increment the round score by total of dice. Used by both the player + computer. */
        die1.roll();
        die2.roll();
        if (getDieValue(1) == 1 || getDieValue(2) == 1) {
            setRoundScore(0);
        } else {
            addRoundScore(getDieValue(1) + getDieValue(2));
        }
    }

    public void playerRolls ( ) { /* - performs the first half of the player turn: Roll the dice and update the round score. */
        rollDice();
    }

    public void playerHolds ( ) { /* - performs the second half of the player's turn: update the player's score, and reset the round score to zero.  */
        scorePlayer += getRoundScore();
        setRoundScore(0);

    }

    public void computerTurn ( ) { /* - performs the computer's entire turn */
        rollDice();
        while (!oneRolled() && getRoundScore() <= 19 && getCpuScore() + getRoundScore() < SCORE_FOR_WIN) {
            rollDice(); /* keeps rolling until stop conditions are met */
        }
        if (snakeEyesRolled()) { /* resets score if snake eyes are rolled */
            scoreCpu = 0;
        }
        scoreCpu += getRoundScore();
        setRoundScore(0);
    }

    public void restart ( ) { /* – reset all instance variables to start a new game. */
        scorePlayer = scoreCpu = scoreRound = 0; /* is this bad practice? seems short and sweet, to me */

        /* if so, use this:
        scorePlayer = 0;
        scoreCpu = 0;
        scoreRound = 0;
        */
    }
    
}

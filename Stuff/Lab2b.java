
/**
 * Write a description of class Lab2b here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Lab2b
{
    /*
    Prompt the user to enter one integer for the number of seconds.
    Calculate and display the number of equivalent hours, minutes and seconds (refer to section 2.5 about integer division and the remainder operator)
    hours = total / 3600;
    total = total % 3600;
    */
    public static void main (String[] a) {
        Scanner in = new Scanner(System.in);
        int secondsInput, hours, minutes, secondsOutput;
        System.out.println("Enter number of seconds");

        secondsInput = in.nextInt();
        secondsOutput = secondsInput % 60;
        minutes = (secondsInput / 60) % 60; // gets total number of minutes, then gets remainder of 60
        hours = secondsInput / 3600;

        System.out.println(hours + " hours, " + minutes + " minutes, and " + secondsOutput + " seconds");
    }
}

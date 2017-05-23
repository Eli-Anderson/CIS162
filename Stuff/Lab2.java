
/**
 * Write a description of class Lab2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Lab2 {

    public static void main (String[] a) {
        /*
        Prompt the user to enter three integers: hours, minutes and seconds.
        Use variables with meaningful names
        Calculate and display the number of equivalent seconds
        */
        Scanner in = new Scanner(System.in);
        int hours, minutes, seconds, total;

        System.out.println("Enter: hours minutes seconds");

        hours = in.nextInt();
        minutes = in.nextInt();
        seconds = in.nextInt();

        total = (hours * 3600) + (minutes * 60) + seconds;
        System.out.println(total);
    }
}

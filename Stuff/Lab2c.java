
/**
 * Write a description of class Lab2c here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Lab2c
{
    public static void main (String[] a) {
        int quarters, dimes, nickels, pennies;
        double total;

        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Enter: quarters dimes nickels pennies");
        double total = (quarters * 0.25) + (dimes * 0.1) + (nickels * 0.5) + (pennies * 0.1);
    }
}

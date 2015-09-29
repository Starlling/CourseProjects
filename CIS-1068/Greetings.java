/*
 * Project Name: Greetings
 * Author: Stephen Guglielmo
 * Date: 2015-05-15
 * Course: CIS-1068-11
 * Lab 1: Prompt user for first and last name,
 * then print back to the screen.
 */

package greetings;
import java.util.*;

public class Greetings {
	public static void main(String[] args) {
		// Setup the Scanner
		Scanner console = new Scanner(System.in);
	
		System.out.println("Welcome to my first Java program\n");
		
		// Get the first name from user
		System.out.print("\tWhat is your first name? ");
		String fname = console.nextLine();
		
		// Get the last name from user
		System.out.print("\tWhat is your last name? ");
		String lname = console.nextLine();
		
		// Print the first and last name with an extra newline.
		System.out.println("\tGreetings, " + fname + " " + lname + "!\n");
		
		System.out.println("Thank you for using my application");
		console.close();
	}
}

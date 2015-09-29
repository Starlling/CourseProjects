/*
 * Author: Stephen Guglielmo
 * Class: CIS-1068-11
 * Date: 2015-05-14
 */

package interactive;
import java.util.Scanner; // So that I can use Scanner 

public class InteractiveClass {
	public static void main(String[] args) {
		// Create the scanner
		Scanner input = new Scanner(System.in);
		
		// Get first name from user
		System.out.print("What is your first name? ");
		String fname = input.next();
		
		// Get age from user
		System.out.print("And how old are you? ");
		String age = input.next();
		
		// Print the vars we just got
		System.out.println(fname + " is " + age + ". That's quite old!");
		
		// Close input to avoid resource leaks
		input.close();
	}
}

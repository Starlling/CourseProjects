/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab 9
 * Date: 2015-06-13
 * Objective: Count the occurrences of digits in a string.
 */
package characterfrequency;
import java.util.Scanner;

public class CharacterFrequency {

	public static void main(String[] args) {
		// Variables and scanner
		String str;
		Scanner input = new Scanner(System.in);
		int[] counts = new int[10]; // indexes 0-9
		
		// Welcome message and prompt for string
		System.out.println("Give me a word of 10 characters.");
		System.out.print("I will tell you if it contains any numbers, and how many of each: ");
		str = input.next();
		input.close();
		
		// Validate length
		if (str.length() != 10) {
			System.out.println("Wrong length, you have entered an invalid word.");
			System.exit(0);
		}
		
		// Cycle through each index in the array (which are numbers 0-9)
		for (int i=0; i < counts.length; i++) {
			// Cycle through each character in the string. See if the character matches the index.
			for (int j=0; j < str.length(); j++) {
				if (str.charAt(j) == ('0' + i)) // Because "0" actually equals 48 in ASCII. Took me a while to figure this out (with some googling).
					counts[i]++;
			}
		}
		
		// Print the results!
		for (int i=0; i < counts.length; i++) {
			System.out.println("Count of " + i + " is " + counts[i] + ".");
		}

	}

}

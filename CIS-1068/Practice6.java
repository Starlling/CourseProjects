/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Practice6, Q4
 * Date: 2015-06-03
 * Objective: Prompt for an int, then print all squares from 1-int
 */
package practice6;
import java.util.Scanner;

public class Practice6 {
	public static void main(String[] args) {
		// Setup vars and scanner
		Scanner input = new Scanner(System.in);
		int x;
		System.out.print("Enter a number: ");
		x = input.nextInt();
		input.close();
		
		for (int i=1; i <= x; i++) {
			System.out.println(i + " * " + i + " = " + i*i);
		}
	}
}

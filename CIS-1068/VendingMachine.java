/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab2, VendingMachine
 * Date: 2015-05-18
 * Objective: Determine the change to be dispensed from a vending machine
 */

package vendingmachine;
import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		System.out.println("Welcome to \"Temple Vending Machine!\"\n");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter price of item: ");
		int price = input.nextInt();
		
		input.close();
		
		// Validate the input
		if (price < 25 || price > 100) {
			System.out.println("Error! The price must be between 25 cents and a dollar!");
		} else if (price % 5 != 0) {
			System.out.println("Error! The price must be in 5-cent increments!");
		} else {
			// OK, price is valid!
			System.out.println("You bought an item for " + price + " cents and paid with a dollar, so your change is:");
			
			// Calculate the change
			int q=0, d=0, n=0, p=0; // Quarters, dimes, nickels, and pennies
			
			int change = 100 - price; // Customer always pays with one dollar bill (100 cents)
			
			// How many quarters?
			if (change >= 75) {
				q = 3;
				change -= 75;
			} else if (change >= 50) {
				q = 2;
				change -= 50;
			} else if (change >= 25) {
				q = 1;
				change -= 25;
			}
			
			// How many dimes (it will be at most 2, else we'd use a quarter)
			if (change >= 20) {
				d = 2;
				change -= 20;
			} else if (change >= 10) {
				d = 1;
				change -= 10;
			}
			
			// How many nickels (at most 1, else we'd just use a dime)
			if (change >= 5) {
				n = 1;
				change -= 5;
			}
			
			// And the rest is pennies
			// But since the price is always in 5 cent increments, this is always 0.
			p = change;
			
			// Print the change!
			System.out.print("\t" + q + " quarter");
			if (q > 1) System.out.print("s"); // For plurals
			
			System.out.print("\n\t" + d + " dime");
			if (d > 1) System.out.print("s"); // For plurals
			
			System.out.print("\n\t" + n + " nickel");
			if (n > 1) System.out.print("s"); // For plurals
			
			System.out.println("\n\t" + p + " pennies"); // This is always 0
			
			System.out.println("Thank you for using \"Temple Vending Machine!\"");
		}
	}
}

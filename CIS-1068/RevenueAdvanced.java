/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab 5, RevenueAdvanced
 * Date: 2015-06-02
 * Objective: Calculate the revenue from a sale, including discounts, validating inputs
 */
package revenueadv;
import java.util.Scanner;

public class RevenueAdvanced {
	public static void main(String[] args) {
		// Setup vars and scanner
		double price, discount=0.0, total, quantity;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to \"Temple\" store");
		System.out.println();
		
		// Prompt the user for price & validate
		System.out.print("Enter item price: ");
		price = input.nextDouble();
		if (price <= 0) {
			// Negatives and zero are invalid
			System.out.println("\tThis is not a valid item price.");
			System.out.println("\tPlease run the program again");
			System.out.println();
			System.out.println("Thank You for using \"Temple\" store");
			System.exit(0);
		}
		
		// Prompt for quantity and validate
		System.out.print("Enter quantity: ");
		quantity = input.nextDouble();
		if (quantity <= 0 || quantity % 1 != 0) {
			// Negatives, zero, and decimals are invalid.
			System.out.println("\tThis is not a valid quantity order.");
			System.out.println("\tPlease run the program again");
			System.out.println();
			System.out.println("Thank You for using \"Temple\" store");
			System.exit(0);
		}
		
		input.close(); // Close the input so Eclipse doesn't complain
		
		System.out.println("\tThe item price: $" + price);
		System.out.println("\tThe order: " + quantity + " item(s)");
		System.out.println("\tThe cost: $" + price * quantity);
		
		// Determine the discount amount based on quantity
		if (quantity >= 150) {
			discount = 0.25;
			System.out.println("\tThe discount: 25%");
		} else if (quantity >= 100) {
			discount = 0.15;
			System.out.println("\tThe discount: 15%");
		} else if (quantity >= 50) {
			discount = 0.10;
			System.out.println("\tThe discount: 10%");
		} else {
			// Discount is initialized at 0 in the beginning; no need to do it again
			System.out.println("\tThe discount: 0%");
		}
		
		System.out.println("\tThe discount amount: $" + discount*price*quantity);
		
		// Calculate and output the total after the discounts
		total = price*quantity - price*quantity*discount; 
		System.out.println("\tThe total: $" + total);
		
		System.out.println();
		System.out.println("Thank You for using \"Temple\" store");
	}
}

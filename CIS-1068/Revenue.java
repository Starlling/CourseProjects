/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab 3, Revenue
 * Date: 2015-05-21
 * Objective: Calculate the revenue from a sale, including discounts
 */
package revenue;
import java.util.Scanner;

public class Revenue {
	public static void main(String[] args) {
		double price=0.0, discount=0.0, total=0.0;
		int quantity=0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to \"Temple\" store");
		
		// Prompt the user for price and quantity
		System.out.print("Enter item price: ");
		price = input.nextDouble();
		System.out.print("Enter quantity: ");
		quantity = input.nextInt();
		
		input.close(); // Close the input so Eclipse doesn't complain
		
		System.out.println("\tThe item price: $" + price);
		System.out.println("\tThe order: " + quantity + " item(s)");
		System.out.println("\tThe cost: $" + price * quantity);
		
		// Determine the discount amount based on quantity
		if (price*quantity >= 150) {
			discount = 0.25;
			System.out.println("\tThe discount: 25%");
		} else if (price*quantity >= 100) {
			discount = 0.15;
			System.out.println("\tThe discount: 15%");
		} else if (price*quantity >= 50) {
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
		
		System.out.println("Thank You for using \"Temple\" store");
	}
}

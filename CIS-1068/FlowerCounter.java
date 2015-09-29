/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab 9
 * Date: 2015-06-13
 * Objective: Use arrays to calculate the total cost of a flower order
 */
package flowercounter;
import java.util.Scanner;

public class FlowerCounter {

	public static void main(String[] args) {
		// Vars and Scanner
		String str;
		int quantity;
		int flowerindex=-1; // The array index of the flower requested, so we can get the respective price
		boolean haveflower=false; // Used in input validation
		double total; // Total cost
		String[] flowers = { "petunia", "pansy", "rose", "violet", "carnation" };
		double[] cost = { 0.50, 0.75, 1.50, 0.50, 0.80 };
		Scanner input = new Scanner(System.in);
		
		// Get the flower input
		System.out.println("What kind of flower would you like?");
		System.out.print("\"petunia\", \"pansy\", \"rose\", \"violet\", \"carnation\": ");
		str = input.next();
		
		// Validate the flower input
		for (int i=0; i < flowers.length; i++) {
			if (str.equalsIgnoreCase(flowers[i])) {
				// We found the input in the array.
				haveflower = true;
				flowerindex = i;
			}
		}
		if (!haveflower) {
			System.out.println("Sorry, we don't have that flower.");
			System.exit(0);
		}
		
		// Get the quantity input
		System.out.print("How many flowers would you like? ");
		quantity = input.nextInt();
		input.close();
		
		total = cost[flowerindex] * quantity;
		System.out.println("Purchasing " + quantity + " of \"" + flowers[flowerindex] + "\" at " + cost[flowerindex] + " cents will cost $" + total);
	}

}

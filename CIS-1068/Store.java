/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Practice 7 - Designing Classes
 * Date: 2015-06-07
 * Objective: Implement Java classes similar to HouseCatalog
 */
package practice7;
import java.util.Scanner;

// Implementation class
class Item {
	private long ItemNumber;
	private String Name;
	private double Price;
	private int Quantity;
	
	/* Prompt user for values
	 * Preconditions: A new object has been created with the Item class
	 * Postconditions: Instance vars have been populated with user data
	 */
	public void readItemData() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter item number (digits only): ");
		ItemNumber = input.nextLong();
		input.nextLine(); // consume the extra \n that nextLong() left behind. This prevents skipping the next line
		System.out.print("Enter item name: ");
		Name = input.nextLine();
		System.out.print("Enter price (e.g. '3.75'): ");
		Price = input.nextDouble();
		System.out.print("Enter quantity (e.g. '4'): ");
		Quantity = input.nextInt();
		System.out.println();
		
		input.close();
	}
	
	/* Display all information for an item
	 * Preconditions: readItemData() has been called to populate the variables
	 * Postconditions: Data is displayed to screen
	 */
	public void displayItem() {
		System.out.println("Item Number:\t" + ItemNumber);
		System.out.println("Item Name:\t" + Name);
		System.out.println("Item Price:\t" + Price);
		System.out.println("Quantity:\t" + Quantity + "\n");
	}

}

// Testing class (main)
public class Store {

	public static void main(String[] args) {
		// Create two objects
		Item firstItem = new Item();
		Item secondItem = new Item();

		// Read the data for each
		firstItem.readItemData();
		secondItem.readItemData();
		
		// Display the data for each
		firstItem.displayItem();
		secondItem.displayItem();
	}

}

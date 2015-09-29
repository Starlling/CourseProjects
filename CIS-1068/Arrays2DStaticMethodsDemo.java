/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Practice 10
 * Date: 2015-06-17
 * Objective: Write methods for 2D array handling.
 */
package practice10;
import java.util.Scanner;

class Array2DExercises {
	
	/* Read the size of a array and read all the elements from the user.
	 * Pre: None.
	 * Post: Return populated array.
	 */
	public static int[][] readInputs() {
		Scanner input = new Scanner(System.in);
		int rows, cols;
		
		// Prompt the user for the size of the array
		System.out.print("\tHow many rows? ");
		rows = input.nextInt();
		System.out.print("\tHow many columns? ");
		cols = input.nextInt();
		System.out.println();
		
		// Create the array based on the user input
		int[][] a = new int[rows][cols];
		
		// Loop through the rows
		for (int i=0; i < a.length; i++) {
			
			// Loop through the cols...
			for (int j=0; j < a[0].length; j++) {
				
				// Prompt the user for the current row+col
				System.out.print("\tEnter [" + i + "][" + j + "]: ");
				a[i][j] = input.nextInt();
			}
		}
		
		System.out.println();
		input.close();
		
		return a;
	}
	
	/* Count the number of times an element contains a single digit 0-9.
	 * Pre: readInputs() was called to create the array.
	 * Post: returns an int of the number of times a single digit appears.
	 */
	public static int countDigits(int[][] a) {
		int count=0;
		
		// Loop through the rows
		for (int i=0; i < a.length; i++) {
			// Loop through the cols...
			for (int j=0; j < a[0].length; j++) {
				if (a[i][j] >= 0 && a[i][j] <= 9)
					count++;
			}
		}
		
		return count;
	}
	
	public static void displayOutputs(int[][] a) {
		System.out.println("2 Dim array: \n");
		
		// Loop through the rows..
		for (int i=0; i < a.length; i++) {
			System.out.print("[");
			// Loop through the cols in each row...
			for (int j=0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
				if (j != a[i].length-1) // Print a comma and space, unless if we're on the last element
					System.out.print(", ");
			}
			System.out.println("]");
		}
		System.out.println();
	}
}

public class Arrays2DStaticMethodsDemo {

	public static void main(String[] args) {
		System.out.println("Lets create a 2Dim array!\n");
		
		// Prompt user for inputs
		int[][] array = Array2DExercises.readInputs();
		
		// Display array
		Array2DExercises.displayOutputs(array);
		
		// Get single digit count and display output message.
		int count = Array2DExercises.countDigits(array);
		System.out.println("You have " + count + " element(s) between 0 and 9.");
	}

}

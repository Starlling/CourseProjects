/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab10: 2D Arrays
 * Date: 2015-06-15
 * Objective: Implement and test some methods involving 2D arrays.
 */
package lab10;
import java.util.Scanner;

class Array2DMethods {
	
	/* Reads the size of a 2D array from the user, then reads values from user.
	 * Pre: None.
	 * Post: Returns populated 2D array.
	 */
	public static int[][] readInputs() {
		Scanner input = new Scanner(System.in);
		int rows, cols;
		
		// Get size of array
		System.out.print("\tHow many rows? ");
		rows = input.nextInt();
		System.out.print("\tHow many columns? ");
		cols = input.nextInt();
		System.out.println();
		
		int[][] a = new int[rows][cols];
		
		// Loop through the rows..
		for (int i=0; i < a.length; i++) {
			// Loop through the cols in each row...
			for (int j=0; j < a[i].length; j++) {
				System.out.print("\tEnter [" + i + "][" + j + "]: ");
				a[i][j] = input.nextInt();
			}
		}
		
		input.close();
		
		return a;
	}
	
	/* Find the max value in the 2D array (including both rows and cols).
	 * Pre: readInputs() was called to create and populate the array.
	 * Post: Returns an int of the max value. 
	 */
	public static int max(int[][] a) {
		// Don't initialize this to zero because the max might be a negative number!
		// Instead, start with the first value in the array.
		int max = a[0][0];
		
		// Loop through the rows..
		for (int i=0; i < a.length; i++) {
			// Loop through the cols in each row...
			for (int j=0; j < a[i].length; j++) {
				if (a[i][j] > max)
					max = a[i][j];
			}
		}
		
		return max;
	}
	
	/* Calculate the sum of all elements in a row.
	 * Pre: 2D array is populated and passed as an argument.
	 * Post: Returns the sum of a row or -1 if row doesn't exist.
	 */
	public static long rowSum(int[][] a, int row) {
		long sum=0;
		
		// Make sure the row exists
		if (row >= a.length)
			return -1;

		// Loop through the cols in each row...
		for (int i=0; i < a[row].length; i++) {
			sum += a[row][i];
		}

		return sum;
	}
	
	/* Calculate the sum of all elements in a column.
	 * Pre: 2D array is populated and passed as an argument.
	 * Post: Returns the sum of a column or -1 if column doesn't exist.
	 */
	public static long columnSum(int[][] a, int col) {
		long sum=0;
		
		// Make sure the column exists
		if (col >= a[0].length)
			return -1;

		// Loop through the rows..
		for (int i=0; i < a.length; i++) {
			sum += a[i][col];
		}

		return sum;
	}
	
	/* Check if the 2D array is "square."
	 * Pre: 2D array is populated and passed as an argument.
	 * Post: Returns true or false.
	 */
	public static boolean isSquare(int[][] a) {
		boolean isSq = true;
		
		// Loop through the rows..
		for (int i=0; i < a.length; i++) {
			if (a[i].length != a.length)
				// If the current column is NOT the same length as the rows
				// This checks for uneven columns.
				isSq = false;
		}
		
		return isSq;
	}
	
	/* Print the 2D array.
	 * Pre: 2D array is populated and passed as an argument.
	 * Post: Array is neatly printed to the screen.
	 */
	public static void displayOutputs(int[][] a) {
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
	}
} // End class

public class Arrays2DDemo {
	
	/* Test the methods defined in the class above */
	public static void main(String[] args) {
		System.out.println("Let's create a 2Dim array!");
		
		int[][] Array = Array2DMethods.readInputs();
		
		// Will return -1 if the row doesn't exist
		System.out.println("\nSum of row 0: " + Array2DMethods.rowSum(Array, 0));
		System.out.println("Sum of row 1: " + Array2DMethods.rowSum(Array, 1));
		System.out.println("Sum of row 2: " + Array2DMethods.rowSum(Array, 2));
		
		// Will return -1 if the col doesn't exist
		System.out.println("\nSum of column 0: " + Array2DMethods.columnSum(Array, 0));
		System.out.println("Sum of column 1: " + Array2DMethods.columnSum(Array, 1));
		System.out.println("Sum of column 2: " + Array2DMethods.columnSum(Array, 2));
		
		System.out.print("\nIs this a square array? ");
		System.out.println(Array2DMethods.isSquare(Array));
		
		System.out.println("\nMax value: " + Array2DMethods.max(Array));
		
		System.out.println("\nHere is your 2Dim array:");
		Array2DMethods.displayOutputs(Array);
	}
}

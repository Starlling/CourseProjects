/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-10-22
 * Project: Sorting Assignment
 * Description: Generate a random array and sort using various methods.
 */

package sorting;
import java.util.Scanner;
import java.util.Random;

public class Sorting {
	// These variables are needed outside the methods because the methods are recursive.
	private static int mergeCalls = 0, mergeMoves = 0, mergeComps = 0;
	private static int quickCalls = 0, quickComps = 0, quickMoves = 0;

	// Set to TRUE to print the array contents before and after sorting
	private static final boolean VERBOSE = false;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt user for array size
		System.out.print("Array size (2048, 4096, 8192, 16384)? ");
		int size = input.nextInt();
		
		// Prompt user for number of runs
		System.out.print("How many repeats? ");
		int repeats = input.nextInt();
		
		// Insertion sort
		System.out.println("INSERTION SORT");
		for (int z=0; z < repeats; z++) {
			insertion(genArray(size), z);
			if (VERBOSE && z < repeats-1) System.out.println(); // For readability
		}
		
		// Merge sort
		System.out.println("MERGE SORT");
		for (int z=0; z < repeats; z++) {
			mergesort(genArray(size), z);
			if (VERBOSE && z < repeats-1) System.out.println(); // For readability
		}
		
		// Quick sort
		System.out.println("QUICK SORT");
		for (int z=0; z < repeats; z++) {
			quicksort(genArray(size), z);
			if (VERBOSE && z < repeats-1) System.out.println(); // For readability
		}
	}
	
	/* This method generates an array filled with pseudo-random numbers. The size
	 * of the array is defined at the top of the class (SIZE).
	 */
	private static int[] genArray(int size) {
		int[] a = new int[size]; // Create the array
		Random rand = new Random(); // Fill it with random ints.
		for (int i=0; i < size; i++) {
			a[i] = rand.nextInt(10000); // To make it easier on the eyes
		}
		return a;
	}
	
	/* This function prints the contents of the given array only if VERBOSE is true
	 */
	private static void print(int[] a) {
		if (!VERBOSE) return;
		
		System.out.print("\t");
		for (int i=0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i < a.length-1) System.out.print(", ");
		}
		System.out.println();
	}
	
	/* This confirms that the array is in increasing order. Needed because humans
	 *	make mistakes, especially when reading a ton of numbers on a screen.
	 */
	private static boolean validate(int[] a) {
		boolean valid = true;
		for (int i=1; i < a.length; i++) if (a[i] < a[i-1]) valid = false;
		return valid;
	}
	
	/* Insertion sort. Efficient for small lists and mostly sorted lists.
	 * This is the method that is most "natural" for humans.
	 * Average case: O(n^2) comparisons and swaps
	 */
	private static void insertion(int[] a, int repeat) {
		long moves = 0, comps = 0; // Number of moves and comparisons
		print(a); // Print unsorted
		long startTime = System.currentTimeMillis();
		
		int temp, j;
		// Iterate through the list, starting at the SECOND element (index 1)
		for (int i=1; i < a.length; i++) {
			
			for (j = i; j > 0 && a[j-1] > a[j]; j--) {
				comps++;
				
				// Switch 'em
				temp = a[j]; // Store the current int
				a[j] = a[j-1]; // Move the smaller int into the current spot
				a[j-1] = temp; // Put the current int in the previous spot (switching them)
				
				moves++;
			}
		}
		
		long endTime = System.currentTimeMillis();
		print(a); // Print sorted
		System.out.println("\tRepeat " + (repeat+1) + "\t\tSize: " + a.length + "\t\tTime to sort: " + (endTime-startTime) + " milliseconds" + "\t\tMoves: " + moves + "\t\tComparisons: " + comps + "\t\tValidated: " + validate(a));
	}
	
	/* This is the entry point of the mergesort algorithm. It sets up some variables,
	 * starts a timer, then calls the mergeRecursive method, then prints the results.
	 * Merge sort is O(n logn).
	 */
	private static void mergesort(int[] a, int repeat) {
		print(a); // Print unsorted
		long startTime = System.currentTimeMillis(); // Start the timer
		
		mergesort(a, 0, a.length-1);
		
		long endTime = System.currentTimeMillis(); // End the timer
		print(a); // Print sorted
		System.out.println("\tRepeat " + (repeat+1) + "\t\tSize: " + a.length + "\t\tTime to sort: " + (endTime-startTime) + " milliseconds" + "\t\tMoves: " + mergeMoves + "\t\tComparisons: " + mergeComps + "\t\tValidated: " + validate(a) + "\t\tMerge Calls: " + mergeCalls);
		mergeCalls = 0; mergeMoves = 0; mergeComps = 0; // Reset the counters when we finish for the next cycle.
	}
	
	/* This is the beginning of the mergesort algorithm. It is a recursive function
	 * that splits the array in half and then sorts smaller pieces.
	 * This method overloads the above mergesort().
	 */
	private static void mergesort(int[] a, int top, int bottom) {
		mergeCalls++;
		if (top != bottom) {
			int middle = (top + bottom) / 2;
			mergesort(a, top, middle);
			mergesort(a, middle+1, bottom);
			merge(a, top, bottom);
		}
	}
	
	private static void merge(int[] a, int top, int bottom) {
		int t = top;
		int middle = (top + bottom) / 2;
		int b = middle + 1;
		int i = 0;
		int[] s = new int[bottom - top + 1];
		
		while (t <= middle && b <= bottom) {
			if (a[t] < a[b]) {
				s[i] = a[t];
				t++;
			} else {
				s[i] = a[b];
				b++;
			}
			i++;
			mergeComps++;
			mergeMoves++;
		}
		
		int last = middle;
		if (b <= bottom) {
			t = b;
			last = bottom;
		}
		
		while (t <= last) {
			s[i] = a[t];
			t++;
			i++;
			mergeMoves++;
		}
		
		for (i = 0; i < s.length; i++) {
			a[i + top] = s[i];
			mergeMoves++;
		}
   }
	
	/* The quicksort algorithm. 
	 */
	private static void quicksort(int[] array, int repeat) {
		print(array); // Print unsorted
		long startTime = System.currentTimeMillis();
		
		quicksort(array, 0, array.length-1);
		
		long endTime = System.currentTimeMillis();
		print(array); // Print sorted
		System.out.println("\tRepeat " + (repeat+1) + "\t\tSize: " + array.length + "\t\tTime to sort: " + (endTime-startTime) + " milliseconds" + "\t\tMoves: " + quickMoves + "\t\tComparisons: " + quickComps + "\t\tValidated: " + validate(array) + "\t\tQuickSort Calls: " + quickCalls);
		quickCalls = 0; quickComps = 0; quickMoves = 0; // Reset the counters when we finish for the next cycle.
	}
	
	/* This method overloads the above quicksort().
	 */
	private static void quicksort(int[] array, int bottom, int top) {
		quickCalls++;
		
		if (bottom < top) {
			int p = quickPartition(array, bottom, top);
			quicksort(array, bottom, p-1);
			quicksort(array, p+1, top);
		}
	}
	
	/* Rearranges the entries in array data between positions indexed by i and j
	 * and returns an array index which guarantees that all entries above it are
	 * larger than the entry it indexes, and all entries below it are smaller.
	 */
	private static int quickPartition(int[] array, int bottom, int top) {
		int save = array[bottom]; // The temp var keeping track of what we're switching
		
		while (bottom != top) {
			
			while (bottom < top && save <= array[top]) {
				// Move the top cursor down until we find a value smaller than save/bottom
				top--;
				quickComps++;
			}
			
			if (bottom != top) {
				array[bottom] = array[top]; // Swap them
				quickMoves++;
			}
			
			while (bottom < top && save >= array[bottom]) {
				// Move the bottom cursor up until we find a value bigger than save/top
				bottom++;
				quickComps++;
			}
			
			if (bottom != top) {
				array[top] = array[bottom]; // Swap them
				quickMoves++;
			}
		}
		
		array[bottom] = save; // Finish the switch
		
		return bottom;
	}
}

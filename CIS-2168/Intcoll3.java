/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-09-08
 * Project: Intcoll Version 3; Assignment 1c
 * Description: Use a boolean array to store values in a collection instead of int[]
 */

package intcoll3;

public class Intcoll3 {
	private boolean[] c;
	private int howmany;

	/* Constructor without parameter. Assumes a collection size of 500.
	 * Initalizes array as false.
	 */
	public Intcoll3() {
		this.c = new boolean[500];
		for (int i = 0; i < this.c.length; i++) this.c[i] = false;
		this.howmany = 0;
	}

	/* Constructor with parameter int for size of collection.
	* Initalizes array as false.
	 */
	public Intcoll3(int i) {
		this.c = new boolean[i];
		for (int j = 0; j < this.c.length; j++) this.c[j] = false;
		this.howmany = 0;
	}

	/* Copy argument list to ourselves. All the elements will be the same for both.
	 * No return. Do nothing if we're trying to copy to ourselves.
	 */
	public void copy(Intcoll3 obj) {
		if (this != obj) { // Prevent P.copy(P)
			this.c = new boolean[obj.c.length];
			
			for (int i=0; i < this.c.length; i++)
				this.c[i] = obj.c[i];
			
			this.howmany = obj.howmany;
		}
	}

	/* Returns true only if parameter int is present in the collection.
	 */
	public boolean belongs(int i) {
		if (i > 0 && i < this.c.length)
			return c[i];
		// Return false if i is negative or out of bounds
		return false;
	}

	/* Adds a int to the collection. Do nothing if it already exists.
	 * Expand the array to i+1 if we run out of room.
	 * No return.
	 */
	public void insert(int i) {
		// If i is not in the collection already - this checks for negatives in belongs()
		if (!belongs(i)) {
			if (i >= this.c.length) { // If we're out of bounds
				boolean[] temp = new boolean[i+1]; // +1 because index is the length-1
				for (int j=0; j < temp.length; j++)
					if (j < this.c.length)
						temp[j] = this.c[j];
					else
						temp[j] = false;
				this.c = temp; // point c to the new array
			}
			
			// Insert it!
			this.c[i] = true;
			this.howmany++;
		}
	}

	/* Remove int i from collection if it exists in the collection.
	 * If it does not exist, do nothing. No return.
	 */
	public void omit(int i) {
		// If i is positive, within the bounds of the array, and already true
		if (i > 0 && i < this.c.length && this.c[i]) {
			this.c[i] = false;
			this.howmany--;
		}
	}

	/* Returns an int of the number of numbers in the collection.
	 */
	public int get_howmany() {
		return this.howmany;
	}

	/* Print each element of a collection on a new line. No return.
	 */
	public void print() {
		System.out.println();
		for (int j=0; j < this.c.length; j++)
			if (this.c[j])
				System.out.println(j);
	}

	/* Return true only if the collections are the same length and contain
	 * the same elements (in any order).
	 */
	public boolean equals(Intcoll3 obj) {
		// Not equal if different number of elements
		if (this.howmany != obj.howmany)
			return false;
		
		// Not equal if any of the elements are missing
		// Since both collections have the same number, we only need
		// to iterate over one array (not both).
		for (int i=0; i < this.c.length; i++) {
			if (this.c[i] && !obj.belongs(i))
				return false;
		}
		
		// Otherwise, they're equal
		return true;
	}
}

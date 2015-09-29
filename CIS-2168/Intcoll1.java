/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-09-01
 * Project: Intcoll Version 1; Assignment 1a
 * Description: Document all methods and finish code for insert
 */

package intcoll1;

public class Intcoll1 {
	private int[] c;

	/* Constructor without parameter. Assumes a collection size of 500.
	 */
	public Intcoll1() {
		this.c = new int[500+1]; // +1 for 0 at end
		this.c[0] = 0;
	}

	/* Constructor with parameter int for size of collection.
	 */
	public Intcoll1(int i) {
		this.c = new int[i+1]; // +1 for 0 at end
		this.c[0] = 0;
	}

	/* Copy one list to another list. All the elements will be the same for both.
	 * No return. Do nothing if we're trying to copy to ourselves.
	 */
	public void copy(Intcoll1 obj) {
		if (this != obj) { // Prevent P.copy(P)
			this.c = new int[obj.c.length];
			
			int j = 0;
			while (obj.c[j] != 0) {
				this.c[j] = obj.c[j];
				j++;
			}
			
			this.c[j] = 0;
		}
	}

	/* Returns true only if parameter int is present in the collection.
	 */
	public boolean belongs(int i) {
		int j = 0;
		// Loop will exit when we reach a 0 or i
		while (this.c[j] != 0 && this.c[j] != i)
			j++;
		return (i > 0 && this.c[j] == i);
	}

	/* Adds a int to the collection. Do nothing if it already exists.
	 * Expand the array (by twice) if we run out of room.
	 * No return.
	 */
	public void insert(int i) {
		if (i > 0) {
			int j = 0;
			// Loop will exit when we reach a 0 or i
			while (this.c[j] != 0 && this.c[j] != i)
				j++;
			
			if (this.c[j] == 0) { // If we reached 0 (do nothing if we reached i)...
				if (j == this.c.length - 1) { // ...and we're at the end of the array (-1 to allow room for the 0 after)
					// Create a bigger array and insert i
					int[] temp = new int[this.c.length*2];
					for (int k=0; k < j; k++)
						temp[k] = this.c[k];
					this.c = temp; // point c to the temp array
				}
				
				// Insert it!
				this.c[j] = i;
				this.c[j + 1] = 0;
			}
		}
	}

	/* Remove int i from collection if it exists in the collection.
	 * If it does not exist, do nothing. No return.
	 */
	public void omit(int i) {
		if (i > 0) {
			int j = 0;
			
			// Loop will exit when we reach a 0 or i
			while (this.c[j] != 0 && this.c[j] != i)
				j++;
			
			// If we reached i (as opposed to 0)
			if (this.c[j] == i) {
				int k = j+1;
				while (this.c[k] != 0)
					k++;
				
				// Replace i with the last item (before 0), then set the last item to 0.
				this.c[j] = this.c[k-1];
				this.c[k-1]=0;
			}
		}
	}

	/* Returns an int of the number of numbers in the collection.
	 */
	public int get_howmany() {
		int j=0, howmany=0;
		
		while (this.c[j] != 0) {
			howmany++;
			j++;
		}
		return howmany;
	}

	/* Print each element of a collection on a new line. No return.
	 */
	public void print() {
		int j = 0;
		System.out.println();
		while (this.c[j] != 0) {
			System.out.println(this.c[j]);
			j++;
		}
	}

	/* Return true only if int in one collection are exactly the same as
	 * another collection.
	 */
	public boolean equals(Intcoll1 obj) {
		int j = 0;
		boolean result = true;
		
		// Make sure all elements of c are in the passed argument 
		while (this.c[j] != 0 && result) {
			result = obj.belongs(this.c[j]);
			j++;
		}
		
		// Make sure all elements of the passed argument are in c
		j = 0;
		while (obj.c[j] != 0 && result) {
			result = belongs(obj.c[j]);
			j++;
		}
		
		return result;
	}
}

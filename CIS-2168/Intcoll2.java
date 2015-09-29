/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-09-03
 * Project: Intcoll Version 2; Assignment 1b
 * Description: Use a private variable instead of "0" as a delimiter in the collections
 */

package intcoll2;

public class Intcoll2 {
	private int[] c;
	private int howmany;

	/* Constructor without parameter. Assumes a collection size of 500.
	 */
	public Intcoll2() {
		this.c = new int[500];
		this.howmany = 0;
	}

	/* Constructor with parameter int for size of collection
	 */
	public Intcoll2(int i) {
		this.c = new int[i];
		this.howmany = 0;
	}

	/* Copy one list to another list. All the elements will be the same for both.
	 * No return. Do nothing if we're trying to copy to ourselves.
	 */
	public void copy(Intcoll2 obj) {
		if (this != obj) { // Prevent P.copy(P)
			this.c = new int[obj.c.length];
			
			int j = 0;
			while (j < obj.howmany) {
				this.c[j] = obj.c[j];
				j++;
			}
			
			this.howmany = obj.howmany;
		}
	}

	/* Returns true only if parameter int is present in the collection.
	 */
	public boolean belongs(int i) {
		int j = 0;
		while (j < this.howmany-1 && this.c[j] != i)
			// Loop will exit when we reach howmany or i
			j++;
		return (i > 0 && this.c[j] == i);
	}

	/* Adds a int to the collection. Do nothing if it already exists.
	 * Expand the array (by twice) if we run out of room.
	 * No return.
	 */
	public void insert(int i) {
		// If i is positive and is not in the collection already
		if (i > 0 && !belongs(i)) {
			
			if (this.howmany == this.c.length) { // If there's no more room in the array
				int[] temp = new int[this.c.length*2];
				for (int j=0; j < this.howmany; j++)
					temp[j] = c[j];
				this.c = temp; // point c to the new array
			}
			
			// Insert it!
			this.c[this.howmany] = i;
			this.howmany++;
		}
	}

	/* Remove int i from collection if it exists in the collection.
	 * If it does not exist, do nothing. No return.
	 */
	public void omit(int i) {
		if (i > 0) {
			int j = 0;
			
			// Loop will exit when we reach howmany or i
			while (j < this.howmany && this.c[j] != i)
				j++;
			
			// If we reached i (as opposed to howmany)...
			if (this.c[j] == i) {
				// Replace i with the last item
				this.howmany--;
				this.c[j] = this.c[this.howmany];
			}
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
		for (int j=0; j < this.howmany; j++)
			System.out.println(this.c[j]);
	}

	/* Return true only if the collections are the same length and contain
	 * the same elements (in any order).
	 */
	public boolean equals(Intcoll2 obj) {
		// Not equal if different number of elements
		if (this.howmany != obj.howmany)
			return false;
		
		// Not equal if any of the elements are missing
		// Since both collections have the same number, we only need
		// to iterate over one array (not both).
		for (int i=0; i < this.howmany; i++) {
			if (!obj.belongs(this.c[i]))
				return false;
		}
		
		// Otherwise, they're equal
		return true;
	}
}

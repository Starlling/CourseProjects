/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-09-29
 * Project: Intcoll Version 5; Assignment 3
 * Description: Implement Incoll using the LinkedList class from the Java API
 */

package intcoll5;
import java.util.LinkedList;
import java.util.ListIterator;

public class Intcoll5 {
	private LinkedList<Integer> c;

	/* Constructor without parameter.
	 */
	public Intcoll5() {
		this.c = new LinkedList<>();
	}

	/* Constructor with parameter.
	 */
	public Intcoll5(int i) {
		// Just call the constructor above. We do the same thing if there's a 
		// parameter or not since a LinkedList is dynamic.
		this();
	}

	/* Copy argument list to ourselves. All the elements will be the same for both.
	 * No return. Do nothing if we're trying to copy to ourselves.
	 */
	public void copy(Intcoll5 obj) {
		if (this != obj) { // Prevent P.copy(P)
			// Create a temp list
			LinkedList<Integer> newlist = new LinkedList<>();
			
			// Iterate through the argument list, setting the corresponding elements
			ListIterator<Integer> iter = obj.c.listIterator();
			while (iter.hasNext()) {
				newlist.add(iter.next());
			}
		
			// Set this list to newlist.
			this.c = newlist;
		}
	}

	/* Returns true only if parameter int is present in the collection.
	 */
	public boolean belongs(int i) {
		// Walk through the list, checking for info=i
		if (i < 0)
			// If negative, return false right away
			return false;
		
		return this.c.contains(i);
	}

	/* Adds a int to the collection. Do nothing if it already exists.
	 * No return.
	 */
	public void insert(int i) {
		// If i is not in the collection already - this checks for negatives in belongs()
		if (!belongs(i)) {
			this.c.addFirst(i);
		}
	}

	/* Remove int i from collection if it exists in the collection.
	 * If it does not exist, do nothing. No return.
	 */
	public void omit(int i) {
		this.c.remove(new Integer(i));
	}

	/* Returns an int of the number of numbers in the collection.
	 */
	public int get_howmany() {
		return this.c.size();
	}

	/* Print each element of a collection on a new line. No return.
	 */
	public void print() {
		ListIterator<Integer> iter = this.c.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().intValue());
		}
	}

	/* Return true only if the collections are the same length and contain
	 * the same elements (in any order).
	 */
	public boolean equals(Intcoll5 obj) {
		// Not equal if different number of elements
		boolean result = (this.get_howmany() == obj.get_howmany());
			
		// Not equal if any of the elements are missing
		// Since both collections have the same number, we only need
		// to walk through one list (not both).
		ListIterator<Integer> iter = obj.c.listIterator();
		while (iter.hasNext() && result) {
			// Set result false if one isn't in the other
			result = this.belongs(iter.next());
		}
		
		return result;
	}
}

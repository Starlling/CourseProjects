/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-09-22
 * Project: Intcoll Version 4
 * Description: Implement Intcoll as a linked list instead of an array.
 */

package intcoll4;

public class Intcoll4 {
	private ListNode c;
	private int howmany;

	/* Constructor without parameter.
	 */
	public Intcoll4() {
		this.c = null;
		this.howmany = 0;
	}

	/* Constructor with parameter.
	 */
	public Intcoll4(int i) {
		// Just call the constructor above. We do the same thing if there's a 
		// parameter or not.
		this();
	}
	
	/* The ListNode class contains a link to the next object of type ListNode and
	 * the data (an int). The Intcoll4 is a collection of ListNode objects.
	 */
	private class ListNode {
		private ListNode link;
		private int info;
		
		public ListNode() {
			this.link = null;
			this.info = 0;
		}
	}

	/* Copy argument list to ourselves. All the elements will be the same for both.
	 * No return. Do nothing if we're trying to copy to ourselves.
	 */
	public void copy(Intcoll4 obj) {
		if (this != obj) { // Prevent P.copy(P)
			ListNode newlist;
			
			if (obj.howmany == 0) {
				// We're copying an empty list
				newlist = null;
			} else {
				ListNode cur = obj.c;

				// Create the new list with the first node
				newlist = new ListNode(); // Create the new list
				newlist.info = cur.info; // Set the info for the first item
				ListNode p = newlist; // Pointer to walk the newlist as we walk cur
				cur = cur.link; // Move to the next item in obj.c

				// Copy the rest of the nodes if they exist
				while (cur != null) {
					p.link = new ListNode(); // Create the next node
					p = p.link; // Move to it
					p.info = cur.info; // Set the info
					cur = cur.link; // Move the current pointer to the next node in obj
				}
			}
			
			this.c = newlist;
			this.howmany = obj.howmany;
		}
	}

	/* Returns true only if parameter int is present in the collection.
	 */
	public boolean belongs(int i) {
		// Walk through the list, checking for info=i
		if (i < 0)
			// If negative, return false right away
			return false;
		
		ListNode cur = this.c;
		while (cur != null && cur.info != i)
			// Loop exits when we reach the end (null) or find i.
			cur = cur.link;
		
		if (cur == null) // We reached the end
			return false;
		else // We reached i
			return true;
	}

	/* Adds a int to the collection. Do nothing if it already exists.
	 * No return.
	 */
	public void insert(int i) {
		// If i is not in the collection already - this checks for negatives in belongs()
		if (!belongs(i)) {
			ListNode next = new ListNode();
			next.info = i;
			next.link = this.c; // This points the new node's link to the beginning of the existing list
			this.c = next;
			this.howmany++;
		}
	}

	/* Remove int i from collection if it exists in the collection.
	 * If it does not exist, do nothing. No return.
	 */
	public void omit(int i) {
		if (belongs(i)) {
			ListNode cur = this.c;
			ListNode prev = null;
			
			while (cur != null && cur.info != i) {
				// Loop exits when we reach the end (null) or find i.
				prev = cur;
				cur = cur.link;
			}
			
			if (cur != null) { // We found i; don't do (cur.info == i) to avoid a possible null pointer dereference
				if (prev == null) {
					// If i is the first Node in the list,
					// set c to the next item in the list (it's link).
					this.c = cur.link;
				} else {
					// Link the previous node with the next node (thus skipping over the current node).
					prev.link = cur.link;
				}
				this.howmany--;
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
		ListNode cur = c;
		while (cur != null) {
			System.out.println(cur.info);
			cur = cur.link;
		}
	}

	/* Return true only if the collections are the same length and contain
	 * the same elements (in any order).
	 */
	public boolean equals(Intcoll4 obj) {
		// Not equal if different number of elements
		boolean result = (this.howmany == obj.howmany);
			
		// Not equal if any of the elements are missing
		// Since both collections have the same number, we only need
		// to walk through one list (not both).
		ListNode cur = this.c;
		while (cur != null && result) {
			result = obj.belongs(cur.info);
			cur = cur.link;
		}
		
		return result;
	}
}

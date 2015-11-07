/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-10-31
 * Project: StringColl and MultiStringColl assignment
 * Description: Modify StringColl to accept duplicate strings.
 *		This adds a "occurances" counter instead of actually inserting dupes.
 */

package multistringcoll;

public class MultiStringColl {
	private btNode c;
	private int howmany;

	/* Constructor without parameter.
	 */
	public MultiStringColl() {
		this.c = null;
		this.howmany = 0;
	}

	/* Constructor with parameter. Ignore the parameter and call the default constructor.
	 */
	public MultiStringColl(int i) {
		this();
	}
	
	/* The class for the nodes of the tree.
	*/
	private static class btNode {
		private final String info;
		private btNode left, right;
		private int occurances;
		
		// We should never create a node that is empty.
		public btNode(String str, btNode l, btNode r, int occurs) {
			this.info = str;
			this.left = l;
			this.right = r;
			this.occurances = occurs;
		}
	}

	/* Copy argument list to ourselves. All the elements will be the same for both.
	 * No return value. Do nothing if we're trying to copy to ourselves.
	 */
	public void copy(MultiStringColl obj) {
		if (this != obj) { // Prevent P.copy(P)
			this.c = copyRecursive(obj.c);
			this.howmany = obj.howmany;
		}
	}
	
	/* Create the root node, then recurisvely copy each half of the tree.
	*/
	private btNode copyRecursive(btNode node) {
		btNode newlist = null;
		
		if (node != null)
			newlist = new btNode(node.info, copyRecursive(node.left), copyRecursive(node.right), node.occurances);
		
		return newlist;
	}

	/* Returns the number of times the parameter is present in the collection.
	 */
	public int belongs(String str) {
		btNode p = this.c; // Pointer to traverse
		
		// Walk through the list, checking for info=str until the end
		while (p != null && !p.info.equals(str)) {
			// While(we didn't reach the end of a branch, and we haven't found i yet)
			if (p.info.compareTo(str) > 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		
		if (p == null)
			// We didn't find str
			return 0;
		else
			return p.occurances;
	}

	/* Adds a string to the collection. If the string is already in the collection,
	 * increment the "occurances" counter.
	 * No return value.
	 */
	public void insert(String str) {
		btNode p = this.c; // Pointer to move through the tree
		btNode parent = null; // Keeps track of the parent node

		if (p == null) {
			// The root is null, so just put it here.
			this.c = new btNode(str, null, null, 1);

		} else {
			// Traverse the tree in the proper direction to find where i should go
			while (p != null && !str.equals(p.info)) {
				// whie(not at end of tree, and we didn't find str)
				if (p.info.compareTo(str) > 0) {
					parent = p;
					p = p.left;
				} else {
					parent = p;
					p = p.right;
				}
			}

			// While loop exited, so we reached an empty spot or str.
			
			if (p == null) {
				// We reached the end, str is not in the collection. Add it.
				
				// Find out which side of the parent str should go, then insert it.
				if (parent.info.compareTo(str) > 0)
					// parent.info wont be a null pointer deref because we have at least one node
					parent.left = new btNode(str, null, null, 1);
				else
					parent.right = new btNode(str, null, null, 1);
			
			} else {
				// str is in the collection already. Increment the occurances counter.
				p.occurances++;
			}

		}
		this.howmany++;
	}

	/* Remove a single occurance of str from collection if it exists in the collection.
	 * If it does not exist, do nothing. No return.
	 */
	public void omit(String str) {
		// Check for an empty collection to avoid a pointer deref below
		if (this.c == null) return;
		
		btNode parent = null; // Keeps track of parent node
		btNode p = this.c; // Pointer to traverse
		
		// Traverse in the proper direction until we reach the end or str
		while (!p.info.equals(str)) {
			parent = p;
			
			if (p.info.compareTo(str) > 0)
				p = p.left;
			else
				p = p.right;
		}
		
		// p now points to the node that contains str.
		
		// If we have multiple occurances, just decrement the counters and return.
		if (p.occurances > 1) {
			p.occurances--;
			this.howmany--;
			return;
		}
		
		btNode p2 = p; // Keeps track of the node under p

		if (p.right == null) { // No right sibling
			p2 = p.left; // Could be null
			
		} else if (p.left == null) { // No left sibling
			p2 = p.right; // Could also be null
			
		} else { // Two siblings

			btNode p3 = p.left; // Keeps track of the other node under p

			if (p3.right == null) {
				// Move one of p's child under the other child
				p2 = p3;
				p2.right = p.right;
				
			} else {

				while (p3.right.right != null) {
					p3 = p3.right;
				}

				p2 = p3.right;
				p3.right = p2.left;
				p2.right = p.right;
				p2.left = p.left;
			}
		}

		if (parent == null) {
			c = p2; // p2 will be null if there's no right sibling.
			
		} else if (parent.right == p) {
			parent.right = p2; // "skip over" p from parent to p2
			
		} else {
			parent.left = p2; // Will be null if removing leaf
		}

		this.howmany--;
	}

	/* Returns an int of the number of numbers in the collection.
	 */
	public int get_howmany() {
		return this.howmany;
	}

	/* Print each element of a collection on a new line. No return.
	 */
	public void print() {
		System.out.println("\tHow Many: " + this.howmany);
		
		printRecursive(c);
	}
	
	/* The recursive function that print() uses. Simple display of node info.
	 * This uses in-order (Left, Root, Right).
	 */
	private void printRecursive(btNode node) {
		if (node != null) {
			printRecursive(node.left);
			
			if (node.occurances == 1)
				System.out.println("\t" + node.info);
			else
				System.out.println("\t" + node.info + " (" + node.occurances + ")");
			
			printRecursive(node.right);
		}
	}

	/* Return true only if the collections are the same length and contain
	 * the same elements in the same locations.
	 */
	public boolean equals(MultiStringColl obj) {
		// Not equal if different number of elements
		boolean result = (this.howmany == obj.howmany);
			
		if (result == true)
			result = compareNodes(obj.c, this.c);
		
		return result;
	}
	
	/* Recursively compare two nodes. Used in equals().
	 */
	private boolean compareNodes(btNode node1, btNode node2) {
		if (node1 == null || node2 == null)
			// If both null, they're equal. If only one is null, then return false (nodes not equal).
			return node1 == node2;
		
		if (!node1.info.equals(node2.info) && node1.occurances != node2.occurances)
			// If the info isn't equal, then return false (the nodes aren't equal).
			return false;
		
		return compareNodes(node1.left, node2.left) && compareNodes(node1.right, node2.right);
	}
}
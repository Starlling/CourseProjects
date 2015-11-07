/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-10-31
 * Project: StringColl and MultiColl assignment
 * Description: Modify Intcoll6 (Binary search tree) to accept strings.
 */

package stringcoll;

public class StringColl {
	private btNode c;
	private int howmany;

	/* Constructor without parameter.
	 */
	public StringColl() {
		this.c = null;
		this.howmany = 0;
	}

	/* Constructor with parameter.
	 */
	public StringColl(int i) {
		this.c = null;
		this.howmany = 0;
	}
	
	// The inner class for btNode
	private static class btNode {
		private String info;
		private btNode left, right;

		public btNode() {
			info = "";
			left = right = null;
		}

		public btNode(String str, btNode l, btNode r) {
			info = str;
			left = l;
			right = r;
		}
	}

	/* Copy argument list to ourselves. All the elements will be the same for both.
	 * No return. Do nothing if we're trying to copy to ourselves.
	 */
	public void copy(StringColl obj) {
		if (this != obj) { // Prevent P.copy(P)
			this.c = copyRecursive(obj.c);
			this.howmany = obj.howmany;
		}
	}
	
	private btNode copyRecursive(btNode node) {
		btNode newlist = null;
		
		if (node != null) {
			newlist = new btNode(); // Create the root node
			newlist.info = node.info;
			
			// Recursively copy each half of the tree after the root node
			newlist.left = copyRecursive(node.left);
			newlist.right = copyRecursive(node.right);
		}
		
		return newlist;
	}

	/* Returns true only if parameter int is present in the collection.
	 */
	public boolean belongs(String str) {
		// Walk through the list, checking for info=str
		
		btNode p = this.c; // Pointer to traverse
		
		while (p != null && !p.info.equals(str)) {
			// While we didn't reach the end of a branch, and we haven't found i yet...
			
			if (p.info.compareTo(str) > 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		
		return p != null;
	}

	/* Adds a int to the collection. Do nothing if it already exists.
	 * No return.
	 */
	public void insert(String str) {
		// If str is not in the collection already
		if (belongs(str))
			return;
			
		btNode p = this.c; // Pointer to move through the tree
		btNode parent = null; // Keeps track of the parent node

		// The root is null, so just put it here.
		if (p == null) {
			this.c = new btNode(str, null, null);

		} else {

			// Traverse the tree in the proper direction to find where i should go
			while (p != null) {
				if (p.info.compareTo(str) > 0) {
					parent = p;
					p = p.left;
				} else {
					parent = p;
					p = p.right;
				}
			}

			// While loop exited, so we reached an empty spot.
			// Find out which side of the parent i should go, then insert it.
			if (parent.info.compareTo(str) > 0)
				// parent.info wont be a null pointer deref because we have at least one node
				// as checked above by if (p == null).
				parent.left = new btNode(str, null, null);
			else
				parent.right = new btNode(str, null, null);

		}
		this.howmany++;
	}

	/* Remove str from collection if it exists in the collection.
	 * If it does not exist, do nothing. No return.
	 */
	public void omit(String str) {
		if (!belongs(str))
			return; // Don't do anything if str isn't in the list
		
		
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
		
		btNode p2 = p; // Another pointer

		if (p.right == null) { // No right sibling
			p2 = p.left; // Could be null
			
		} else if (p.left == null) { // No left sibling either
			p2 = p.right; // Could also be null
			
		} else { // Two siblings

			btNode p3 = p.left;

			if (p3.right == null) {
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
			parent.right = p2;
			
		} else {
			parent.left = p2;
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
		
		printRecursiveVerbose(c);
		//printRecursive(c);
	}
	
	/* The recursive function that print() uses.
		Prints the info of children as well.
	 */
	private void printRecursiveVerbose(btNode node) {
		if (node != null) {
			printRecursiveVerbose(node.left);
			
			System.out.println("\tInfo: " + node.info);
			
			if (node.left != null)
				System.out.println("\tLeft child: " + node.left.info);
			else
				System.out.println("\tLeft child is null!");
			
			if (node.right != null)
				System.out.println("\tRight child: " + node.right.info);
			else
				System.out.println("\tRight child is null!");
			
			System.out.println();
			
			printRecursiveVerbose(node.right);
		}
	}
	
	/* The recursive function that print() uses. Simple display of node info.
	 * This uses in-order (Left, Root, Right).
	 */
	private void printRecursive(btNode node) {
		if (node != null) {
			printRecursive(node.left);
			System.out.println("\t" + node.info);
			printRecursive(node.right);
		}
	}

	/* Return true only if the collections are the same length and contain
	 * the same elements in the same locations.
	 */
	public boolean equals(StringColl obj) {
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
		
		if (!node1.info.equals(node2.info))
			// If the info isn't equal, then return false (the nodes aren't equal).
			return false;
		
		return compareNodes(node1.left, node2.left) && compareNodes(node1.right, node2.right);
	}
}
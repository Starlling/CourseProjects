/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-11-01
 * Project: Hash Table
 * Description: Implement a hash table for ints. Use chaining to resolve conflicts.
 */
package hashtable;

public class HashTable {
	private int howmany;
	private final node[] table;
	
	/* Set this to the key you want to use for the hashing function.
	 * eg: mod(i,MODULO_KEY)
	 * This is used to calculate the hash key in the hash() method, as well as
	 * used to determine the size of the hash key array since the max value of
	 * mod(n,m) is m-1.
	 */
	private final int MODULO_KEY = 13;
	
	/* Constructor. The size of the array is MODULO_KEY because the output range
	 * of the hash() method is 0 to MODULO_KEY-1.
	 */
	public HashTable() {
		this.howmany = 0;
		this.table = new node[MODULO_KEY];
	}
	
	/* This is the node class for the array of linked-lists.
	 */
	private static class node {
		private final int info;
		private node link;

		/* Constructor. Requires an int.
		 */
		public node(int info) {
			this.info = info;
			this.link = null;
		}
	}
	
	/* This is the hash function.
	 */
	private int hash(int i) {
		return i % MODULO_KEY;
	}
	
	/* This inserts a value into the hash table using a linked list. If the hash
	 * address is already occupied, it puts the new value in the FRONT of the linked list.
	 * It does not allow duplicates to be added.
	 */
	public void insert(int i) {
		if (belongs(i))
			return; // Don't add duplicates
		
		int key = hash(i);
		
		if (this.table[key] == null) {
			// The hash address is not used, so create a new node here.
			this.table[key] = new node(i);
		
		} else {
			// Hash address is already pointing to a node. This implies there is
			// one or more hash addresses already in use here. Add i to the front.
			node next = new node(i);
			next.link = this.table[key]; // Point the new node's link to the existing list
			this.table[key] = next; // Point the array index to the new node
		}
		
		this.howmany++;
	}
	
	/* This removes a value from the hash table. It does nothing if the value is
	 * not already in the table.
	 */
	public void remove(int i) {
		if (!belongs(i))
			return; // Not in the table
		
		int key = hash(i);
		
		// Traverse though the linked list
		node p = this.table[key]; // Pointer to traverse
		node parent = null; // Keep track of parent
		
		while (p.info != i) { // Wont reach NULL because we know i is in the list
			parent = p;
			p = p.link;
		}
		
		if (parent == null) {
			// i is the first item. If i is the only item, p.link will be null, so
			// this still works for that case as well.
			this.table[key] = p.link;
		
		} else {
			// i is somewhere after the beginning of the linked list. Set parent's
			// link to i's link, skipping i. This still works if i is the last item
			// because p.link will be null.
			parent.link = p.link;
		}
		
		this.howmany--;
	}
	
	/* Return the number of integers in the hash table.
	 */
	public int gethowmany() {
		return this.howmany;
	}
	
	/* Print the hash table. This has to iterate through the entire array, checking
	 * each index. If the index has a linked list, we then traverse the list.
	 * This only prints the array index if it is not NULL.
	 */
	public void print() {
		System.out.println("\tHow Many: " + this.howmany);
		
		for (int i=0; i < this.table.length; i++) {
			
			if (this.table[i] != null) {
				// Traverse though the linked list until we reach the end
				node p = this.table[i]; // Pointer to traverse the list
				
				String str = "";
				while (p != null) {
					
					// Because nobody likes trailing commas...
					if (str.equals(""))
						str = Integer.toString(p.info);
					else
						str += ", " + Integer.toString(p.info);
					
					p = p.link;
				}
				
				System.out.println("\t" + i + ": " + str);
			}
		}
	}
	
	/* This searches the table (and traverses the linked-list if needed) to determine
	 * if integer i is in the table or not.
	 */
	public boolean belongs(int i) {
		int key = hash(i);
		
		if (this.table[key] == null)
			return false;
		
		// We must traverse the list to see if i exists in it.
		node p = this.table[key]; // Pointer to traverse the list
		while (p != null && p.info != i) {
			// Loop exits when we reach the end (null) or find i.
			p = p.link;
		}
		
		return p != null;
	}
}

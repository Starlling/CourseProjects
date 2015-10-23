/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-10-22
 * Project: Hash Table
 * Description: Implement a hash table. This uses chaining to resolve conflicts.
 */
package hashtable;

import java.util.Random;

public class HashTableClient {
	// SIZE must be prime and approximately double the number of expected entries
	// to avoid too many collisions.
	private static final int SIZE = 19;

	public static void main(String[] args) {
		HashTable ht = new HashTable(SIZE);
		Random rand = new Random();
		
		// Generate SIZE/2 random numbers and insert them into the hash table
		for (int i=0; i < SIZE/2; i++) {
			ht.insert(rand.nextInt(1000)); // 0 through 1000, to make it easier on the eyes
		}
		
		System.out.println("Rand Only: ");
		ht.print();
		
		// Insert a few non-random entries so we can remove() them
		ht.insert(13);
		ht.insert(25);
		ht.insert(40);
		
		System.out.println("\nAdded 13, 25, and 40: ");
		ht.print();
		
		ht.remove(13);
		ht.remove(25);
		ht.remove(40);
		
		System.out.println("\nRemoved 13, 25, and 40: ");
		ht.print();
	}
}

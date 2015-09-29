/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab7, NimGame
 * Date: 2015-06-04
 * Objective: Create a two-player implementation of the game Nim
 */
package lab7;
import java.util.Scanner;
import java.util.Random;

public class NimGame {

	public static void main(String[] args) {
		// Setup vars, scanner, and random
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		String player1, player2; // Player names
		String currentPlayer, otherPlayer; // Holds the two players (this swaps back and forth for each iteration)
		String pile; // The player's choice for their turn
		int a, b, c; // The three piles
		int howmany; // How many to remove for each turn

		// Get players's names and validate
		System.out.println("Welcome to the game of Nim!");
		System.out.println("The player that empties the last pile looses!\n");
		System.out.print("Player 1, enter your name: ");
		player1 = input.nextLine();
		if (player1.length() == 0) {
			System.out.println("Invalid name");
			System.exit(0);
		}
		System.out.print("Player 2, enter your name: ");
		player2 = input.nextLine();
		if (player2.length() == 0) {
			System.out.println("Invalid name");
			System.exit(0);
		}
		
		// Generate the three piles, 5-10 inclusive
		a = rand.nextInt(6) + 5;
		b = rand.nextInt(6) + 5;
		c = rand.nextInt(6) + 5;
		
		// Start the game! Who's turn is it first?
		currentPlayer = player1;
		otherPlayer = player2;
		
		while (true) {
			// Keep going until a winner is found and we break;
			
			// Print the piles
			System.out.println();
			System.out.print("A: "); for (int i=0; i < a; i++) System.out.print("*"); System.out.println("\t(" + a + ")");
			System.out.print("B: "); for (int i=0; i < b; i++) System.out.print("*"); System.out.println("\t(" + b + ")");
			System.out.print("C: "); for (int i=0; i < c; i++) System.out.print("*"); System.out.println("\t(" + c + ")");
			
			// After printing the piles above, check to see if there's an automatic winner
			// (Only one item left total)
			if (a+b+c == 1) {
				// There's only one item left in any of the piles, so the otherPlayer automatically wins!
				System.out.println("There's only one item left. " + currentPlayer + " must take it,\nthus " + otherPlayer + " wins the game!");
				System.exit(0);
			}
			
			// Keep looping indefinitely until a correct pile is selected
			while (true) {
				System.out.print(currentPlayer + ", choose a pile: ");
				pile = input.next();
				pile = pile.toUpperCase();
				
				if (pile.equals("A") || pile.equals("B") || pile.equals("C")) {	
					// Validate the pile isn't empty
					if ((pile.equals("A") && a == 0) || (pile.equals("B") && b == 0) || (pile.equals("C") && c == 0)) {
						System.out.println("Nice try, " + currentPlayer + "! That pile is empty! Try again.");
					} else {
						break; // Exit the while() because we got a correct input
					}
				} else {
					System.out.println("Invalid pile! Try again.");
				}
			}
			
			// Keep looping indefinitely until a correct number is entered
			while (true) {
				System.out.print(currentPlayer + ", how many to remove from pile " + pile + "? ");
				howmany = input.nextInt();
				
				if (howmany > 0) {
					if ((pile.equals("A") && howmany > a) || (pile.equals("B") && howmany > b) || (pile.equals("C") && howmany > c)) {
						// The input is greater than the number in the pile
						System.out.println("Pile " + pile + " doesn't have that many. Try again.");
					} else {
						break; // Exit the while() because we got a correct input 
					}
				} else {
					// Negative input
					System.out.println("Invalid amount! Try again.");
				}
			} // while(true) for the pile
			
			// Update the pile from the user's entry
			if (pile.equals("A")) a -= howmany;
			if (pile.equals("B")) b -= howmany;
			if (pile.equals("C")) c -= howmany;
			
			// Check to see if they took the whole pile to finish the game
			if (a == 0 && b == 0 && c == 0) {
				// The player who did NOT take the last one is the winner (otherPlayer)
				System.out.println("There is nothing left in any of the piles!\n" + currentPlayer + "took the last piece, so " + otherPlayer + " wins the game!");
				System.exit(0);
			}
			
			// Swap the players for the next iteration
			if (currentPlayer.equals(player1)) {
				currentPlayer = player2;
				otherPlayer = player1;
			} else {
				currentPlayer = player1;
				otherPlayer = player2;
			}
						
		
		} // while(true) for the entire game
	
	} // main()
} // class NimGame

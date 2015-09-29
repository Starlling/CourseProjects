/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab2, Water Well
 * Date: 2015-05-18
 * Objective: Calculate the amount of water that can be stored in a well
 */

package waterwell;
import java.util.Scanner;

public class WaterWell {

	public static void main(String[] args) {
		// Print welcome message3
		System.out.println("This program calculates how much water will be available in a well.");
		System.out.println();
		
		// Setup the scanner for input
		Scanner input = new Scanner(System.in);
		
		// Prompt the user for the information
		System.out.print("What is the radius of the casing in inches? ");
		int radiusin = input.nextInt();
		System.out.print("What is the depth of the well in feet? ");
		int depth = input.nextInt();
		
		// Convert inches to feet
		double radiusft = radiusin / 12.0;
		
		// Calculate the volume in cubic feet
		// pi * r^2 * depth
		double volume = 3.1415 * (radiusft * radiusft) * depth;
		
		// Calculate the number of gallons that can fit in volume
		// 1 cubic foot = 7.48 gallons of water
		double gallons = volume * 7.48;
		
		System.out.println("The well contains " + gallons + " gallons.");
		System.out.println();
		
		// Print the ending message
		System.out.println("Program successfully ended");
		System.out.println("Please run the program again to do another calculation");
		
		input.close();
	}

}

/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab4, Temperature
 * Date: 2015-05-28
 * Objective: Convert between celsius and fahrenheit
 */
package temperature;
import java.util.Scanner;

public class Temperature {

	public static void main(String[] args) {
		// Setup variables and scanner
		Scanner input = new Scanner(System.in);
		double temp = 0, newtemp = 0;
		String output = null, measurement = null;
		
		// Welcome messages
		System.out.println("Welcome to Temple Weather Channel"); 
		System.out.println("Temperature Conversion Program");
		
		// Prompt the user for temperature and measurement type
		System.out.print("\t[Q1] Enter a temperature in degrees (for example 29.6): ");
		temp = input.nextDouble();
		System.out.print("\t[Q2] Enter 'F' (or 'f') for Fahrenheit or 'C' (or 'c') for Celsius: ");
		measurement = input.next();
		
		input.close(); // Close the Scanner input
		
		// Generate an output message based on measurement type
		switch (measurement) {
		case "F":
		case "f":
			newtemp = 5 * (temp - 32) / 9;
			output = temp + " degrees F = " + newtemp + " degrees Celsius.";
			break;
		case "C":
		case "c":
			newtemp = (9 * (temp) / 5) + 32;
			output = temp + " degrees C = " + newtemp + " degrees Fahrenheit.";
			break;
		default:
			output = "\tUnknown units\n\tCannot do calculation\n\tPlease next time enter either 'F' for Fahrenheit or 'C' for Celsius.";
		}
		
		// Print the output message
		System.out.println(output);
		System.out.println("Program ended.");
	}

}

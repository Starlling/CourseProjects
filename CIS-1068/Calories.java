/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab4, Calories
 * Date: 2015-05-28
 * Objective: Calculate number of chocolate bars to maintain weight
 */
package calories;
import java.util.Scanner;

public class Calories {

	public static void main(String[] args) {
		// Setup variables and scanner
		Scanner input = new Scanner(System.in);
		int age = 0, height = 0, weight = 0;
		String gender = null, activity = null, error = "";
		double bmr = 0;

		// Welcome message
		System.out.println("This program will calculate the number of 230 calorie\ncandy bars to eat to maintain your weight.");
		
		// Prompt for user information
		System.out.print("\t[Q1] What is your age in years? ");
		age = input.nextInt();
		System.out.print("\t[Q2] What is your total height in inches? ");
		height = input.nextInt();
		System.out.print("\t[Q3] What is your weight in pounds? ");
		weight = input.nextInt();
		System.out.print("\t[Q4] Enter 'M' (or 'm') for male calculation or 'F' (or 'f') for female: ");
		gender = input.next();
		System.out.println("\t[Q5] Are you:\n\t\tA. Sedentary\n\t\tB. Somewhat active (exercise occasionally)\n\t\tC. Active (exercise 3-4 days per week)\n\t\tD. Highly active (exercise every day)\n");
		System.out.print("\t[Q6] Enter A, B, C, or D: ");
		activity = input.next();
		
		input.close(); // Close the Scanner input
		
		// Calculate BMR based on gender
		switch (gender) {
		case "F":
		case "f":
			bmr = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
			break;
		case "M":
		case "m":
			bmr = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
			break;
		default:
			error = "Invalid entry for gender.";
		}
		
		// Modify BMR based on activity level
		switch (activity) {
		case "A":
		case "a":
			// Sedentary: Increase BMR by 20%
			bmr += bmr*0.2;
			break;
		case "B":
		case "b":
			// Somewhat active: Increase BMR by 30%
			bmr += bmr*0.3;
			break;
		case "C":
		case "c":
			// Active: Increase BMR by 40%
			bmr += bmr*0.4;
			break;
		case "D":
		case "d":
			// Highly active: Increase BMR by 50%
			bmr += bmr*0.5;
			break;
		default:
			error = "Invalid entry for activity level.";
			
		}
		
		if (error.length() != 0) {
			// If there is an error, print it instead of the results
			System.out.println(error);
		} else {
			System.out.println("\n\tWith those measurements, you should eat " + bmr/230 + " candy bars per day to maintain the same weight.");
		}
		System.out.println("Program ended.");
	}

}

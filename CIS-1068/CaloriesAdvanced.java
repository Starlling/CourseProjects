/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab 6, CaloriesAdvanced
 * Date: 2015-06-02
 * Objective: Calculate the number of chocolate bars to maintain weight
 */
package caloriesadv;
import java.util.Scanner;

public class CaloriesAdvanced {

	public static void main(String[] args) {
		// Setup vars and scanner
		Scanner input = new Scanner(System.in);
		String firstName, lastName, gender, actlevel;
		int age;
		double height, weight, bmr, bars;
		
		// Welcome message
		System.out.println("This program will calculate the number of 230 calorie\ncandy bars to eat to maintain your weight.\n");
		
		// Prompt first name, convert to upper case, and validate.
		System.out.print("\t[Q1] What is your first name? ");
		firstName = input.nextLine();
		firstName = firstName.toUpperCase();
		if (firstName.length() == 0) {
			System.out.println("\n\tYou have entered Invalid entry for first name.\n");
			System.out.println("Program ended.");
			System.exit(0);
		}
		
		// Prompt for last name, convert to upper case, and validate.
		System.out.print("\t[Q2] What is your last name? ");
		lastName = input.nextLine();
		lastName = lastName.toUpperCase();
		if (lastName.length() == 0) {
			System.out.println("\n\t" + firstName + ", you have entered Invalid entry for last name.\n");
			System.out.println("Program ended.");
			System.exit(0);
		}
		
		// Prompt and validate age
		System.out.print("\t[Q3] What is your age in years? ");
		age = input.nextInt();
		if (age > 125 || age < 1) {
			System.out.println("\n\t" + firstName + " " + lastName + ", you have entered Invalid entry for age.\n");
			System.out.println("Program ended.");
			System.exit(0);
		}
		
		// Prompt and validate height
		System.out.print("\t[Q4] What is your total height in inches? ");
		height = input.nextDouble();
		if (height > 108 || height < 1) {
			System.out.println("\n\t" + firstName + " " + lastName + ", you have entered Invalid entry for height.\n");
			System.out.println("Program ended.");
			System.exit(0);
		}
		
		// Prompt and validate weight
		System.out.print("\t[Q5] What is your weight in pounds? ");
		weight = input.nextDouble();
		if (weight > 1400 || weight < 1) {
			System.out.println("\n\t" + firstName + " " + lastName + ", you have entered Invalid entry for weight.\n");
			System.out.println("Program ended.");
			System.exit(0);
		}
		
		// Prompt and validate gender
		System.out.print("\t[Q6] Enter \"Male\" or \"Female\": ");
		gender = input.next();
		if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
			System.out.println("\n\t" + firstName + " " + lastName + ", you have entered Invalid entry for gender.\n");
			System.out.println("Program ended.");
			System.exit(0);
		}
		
		// Prompt and validate activity level
		System.out.println("\t[Q7] What is your Activity Level?");
		System.out.println("\t\tA. Sedentary\t(Little or no exercise)");
		System.out.println("\t\tB. Moderate\t(exercise occasionally)");
		System.out.println("\t\tC. Vigorous\t(exercise 3-4 days per week)");
		System.out.println("\t\tD. Extreme\t(exercise every day)\n");
		System.out.print("\t\tEnter Sedentary, Moderate, Vigorous, or Extreme: ");
		actlevel = input.next();
		if (!actlevel.equalsIgnoreCase("sedentary") && !actlevel.equalsIgnoreCase("moderate") && !actlevel.equalsIgnoreCase("vigorous") && !actlevel.equalsIgnoreCase("extreme")) {
			System.out.println("\n\t" + firstName + " " + lastName + ", you have entered Invalid entry for activity.\n");
			System.out.println("Program ended.");
			System.exit(0);
		}
		
		// No more inputs
		input.close();
		
		// All the inputs are valid, now calculate the bmr
		if (gender.equalsIgnoreCase("female")) {
			bmr = 655 + (4.3 * weight) + (4.7 * height)	- (4.7 * age);
		} else {
			// This must be "male" because the input was validated above
			bmr = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		}
		
		// Adjust bmr for the activity level
		switch (actlevel.toLowerCase()) {
		case "sedentary":
			bmr += bmr*0.20;
			break;
		case "moderate":
			bmr += bmr*0.30;
			break;
		case "vigorous":
			bmr += bmr*0.40;
			break;
		case "extreme":
			bmr += bmr*0.50;
			break;
		// There wont be any default case here because we validated the input above
		}
		
		// Calculate # of chocolate bars based on bmr
		bars = bmr / 230;
		
		// Output and closing message
		System.out.println("\n\t" + firstName + " " + lastName + ", with those measurements, you should eat " + bars + " candy bars\n\tper day to maintain the same weight.\n");
		System.out.println("Program ended.");
	}

}

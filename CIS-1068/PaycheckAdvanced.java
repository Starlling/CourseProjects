/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab 5, PaycheckAdvanced
 * Date: 2015-06-02
 * Objective: Calculate the paycheck for a Temple employee, validating input
 */
package paycheckadv;
import java.util.Scanner;

public class PaycheckAdvanced {
	public static void main(String[] args) {
		// Setup variables and scanner
		double eid, hourlySalary, totalHours, otHours, regHours, netPay; // Use doubles in order to validate input below using modulus
		Scanner input = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Welcome to \"TEMPLE HUMAN RESOURCES\"\n");
		
		// Prompt and validate for the employee ID
		System.out.print("\tEnter Employee Number: ");
		eid = input.nextDouble();
		// Check for negatives, zero, and for decimals
		if (eid <= 0 || eid % 1 != 0) {
			System.out.println("\tThis is not a valid Employee Number.");
			System.out.println("\tPlease run the program again");
			System.out.println();
			System.out.println("Thank you for using \"TEMPLE HUMAN RESOURCES\"");
			System.exit(0);
		}
		
		// Cast to int to print "123" instead of "123.0"
		int eidint = (int) eid;
		
		// Prompt and validate the hourly salary
		System.out.print("\tEnter Hourly Salary: ");
		hourlySalary = input.nextDouble();
		if (hourlySalary <= 0) {
			// Negative and zero values are invalid.
			System.out.println("\tThis is not a valid hourly salary amount.");
			System.out.println("\tPlease run the program again");
			System.out.println();
			System.out.println("Thank you for using \"TEMPLE HUMAN RESOURCES\"");
			System.exit(0);
		}
		
		// Prompt and validate the weekly time
		System.out.print("\tEnter Weekly Time: ");
		totalHours = input.nextDouble();
		if (totalHours <= 0) {
			// Negative and zero values are invalid.
			System.out.println("\tThis is not a weekly time.");
			System.out.println("\tPlease run the program again");
			System.out.println();
			System.out.println("Thank you for using \"TEMPLE HUMAN RESOURCES\"");
			System.exit(0);
		}
		
		input.close(); // Close the Scanner input so Eclipse wont complain
		System.out.println("\t==============================");
		
		// Output and calculate their pay
		System.out.println("\tEmployee #: " + eidint);
		System.out.println("\tHourly Salary: $" + hourlySalary);
		System.out.println("\tWeekly Time: " + totalHours);
		
		// Calculate number of OT hours
		if (totalHours >= 40) {
			regHours = 40;
			otHours = totalHours - 40;
		} else {
			regHours = totalHours;
			otHours = 0;
		}
		System.out.println("\tRegular Pay for " + regHours + " hour(s): $" + hourlySalary*regHours);
		System.out.println("\tOvertime Pay for " + otHours + " hour(s): $" + hourlySalary*1.5*otHours);
		
		// Calculate net pay
		netPay = hourlySalary*regHours + hourlySalary*1.5*otHours;
		System.out.println("\tNet Pay: $" + netPay);
		
		// Closing messages
		System.out.println("\t==============================");
		System.out.println("Thank you for using \"TEMPLE HUMAN RESOURCES\"");
	}

}

/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab 3, Paycheck
 * Date: 2015-05-21
 * Objective: Calculate the paycheck for a Temple employee
 */
package paycheck;
import java.util.Scanner;

public class Paycheck {

	public static void main(String[] args) {
		long eid=0; // Use long to allow for large employee IDs
		double hSalary=0.0, wHours=0.0, otHours=0.0, net=0.0;
		
		Scanner input = new Scanner(System.in);
		
		// Prompt the user for their work information
		System.out.println("Welcome to \"TEMPLE HUMAN RESOURCES\"\n");
		System.out.print("\tEnter Employee Number: ");
		eid = input.nextLong();
		System.out.print("\tEnter Hourly Salary: ");
		hSalary = input.nextDouble();
		System.out.print("\tEnter Weekly Time: ");
		wHours = input.nextInt();
		
		input.close();
		
		// Output and calculate their pay
		System.out.println("\n\tEmployee #: " + eid);
		System.out.println("\tHourly Salary: $" + hSalary);
		System.out.println("\tWeekly Time: " + wHours + " hour(s)");
		System.out.println("\tRegular Pay for 40.0 hour(s): $" + hSalary*40);
		
		// Calculate number of OT hours
		if (wHours >= 40) {
			otHours = wHours - 40;
		} // else it's 0 by default (initialized above)
		System.out.println("\tOvertime Pay for " + otHours + " hour(s): $" + hSalary*1.5*otHours);
		
		// Calculate net pay
		net = hSalary*40 + hSalary*1.5*otHours;
		System.out.println("\tNet Pay: $" + net);
		System.out.println("\nThank you for using \"TEMPLE HUMAN RESOURCES\"");
	}

}

/* Name: Stephen Guglielmo
 * Course: CIS-1068-11
 * Project: Lab 8: Health Record Demo
 * Date: 2015-06-08
 * Objective: Represent a patient entry in a health record database, and calcuate BMI.
 */
package lab8;
import java.util.Scanner;

class HealthRecord {
	// Instance Vars and Scanner.
	private int ssn, age;
	private String firstName, lastName, email;
	private long phoneNumber;
	private double weight, height;
	Scanner input = new Scanner(System.in);
	
	/* Setter methods.
	 * These validate the input read by readInputs(), then set
	 * the private instance variables to the proper values.
	 */
	private void setSSN(String newSSN) {
		// Read it as a string, then use a regex to make sure it's 9 chars and all digits
		while (!newSSN.matches("^[0-9]{9}$")) {
			// Leave the loop when we get valid input.
			System.out.print("Invalid input: Must be 9 digits and no hyphens or spaces.\nTry again: ");
			newSSN = input.next();
		}
		ssn = Integer.parseInt(newSSN); // Convert the (numerical) string to an int. From StackOverflow.
	}
	
	private void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	private void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	private void setAge(int newAge) {
		while (newAge < 1 || newAge > 125) {
			// Exit the loop when we get valid input.
			System.out.print("Invalid input: Must be a number between 1 and 125, inclusive.\nTry again: ");
			newAge = input.nextInt();
		}
		age = newAge;
	}
	
	private void setPhoneNumber(String newPhoneNumber) {
		// Read it as a string and use a regex to make sure it's 10 char and all digits
		while (!newPhoneNumber.matches("^[0-9]{10}$")) {
			System.out.print("Invalid input: Must be 10 digits and no hyphens, parenthesis, or spaces.\nTry again: ");
			newPhoneNumber = input.next();
		}
		phoneNumber = Long.parseLong(newPhoneNumber); // Convert the (numerical) string to a long. From StackOverflow
	}
	
	private void setEmail(String newEmail) {
		email = newEmail;
	}
	
	private void setWeight(double newWeight) {
		while (newWeight < 1 || newWeight > 1400) {
			System.out.print("Invalid input: Must be a number between 1 and 1400, inclusive.\nTry again: ");
			newWeight = input.nextDouble();
		}
		weight = newWeight;
	}
	
	private void setHeight(double newHeight) {
		while (newHeight < 1 || newHeight > 108) {
			System.out.print("Invalid input: Must be a number between 1 and 108, inclusive.\nTry again: ");
			newHeight = input.nextDouble();
		}
		height = newHeight;
	}
	
	/* Getter Methods.
	 * These return the values from the private instance variables.
	 */
	private int getSSN() {
		return ssn;
	}
	
	private String getFirstName() {
		return firstName;
	}
	
	private String getLastName() {
		return lastName;
	}
	
	private int getAge() {
		return age;
	}
	
	private long getPhoneNumber() {
		return phoneNumber;
	}
	
	private String getEmail() {
		return email;
	}
	
	private double getWeight() {
		return weight;
	}
	
	private double getHeight() {
		return height;
	}
	
	/* Prompt the user to input the data for the 8 instance variables.
	 * This calls the 8 private setter methods above to save the data.
	 * Input validation is done within the setter methods, not here.
	 * Precondition: Object has been created.
	 * Postcondition: Instance variables are validated and populated.
	 */
	public void readInputs() {
		System.out.print("Enter SSN: ");
		setSSN(input.next()); // Converted to an int after validation.
		
		System.out.print("Enter first name: ");
		setFirstName(input.next());
		
		System.out.print("Enter last name: ");
		setLastName(input.next());
		
		System.out.print("Enter age: ");
		setAge(input.nextInt());
		
		System.out.print("Enter phone number: ");
		setPhoneNumber(input.next()); // Converted to an long after validation.
		
		System.out.print("Enter email: ");
		setEmail(input.next());
		
		System.out.print("Enter weight (lbs): ");
		setWeight(input.nextDouble());
		
		System.out.print("Enter height (in): ");
		setHeight(input.nextDouble());
		System.out.println();
	}
	
	/* Calculate the BMI based on the values from the instance variables.
	 * Precondition: readInputs() has been called already.
	 * Postcondition: Returns a double of the calculated BMI.
	 */
	private double calculateBMI() {
		double bmi = (weight / (height * height)) * 703;
		return bmi;
	}
	
	/* Output the data on the patient to the screen.
	 * Precondition: readInputs() has been called.
	 * Postcondition: Instance variables and output from calculateBMI() printed to the screen.
	 */
	public void display() {
		// Use two \t's for the shorter names so that the values line up.
		System.out.println("*** Patient Data ***");
		System.out.println("SSN:\t\t" + getSSN());
		System.out.println("First Name:\t" + getFirstName());
		System.out.println("Last Name:\t" + getLastName());
		System.out.println("Age:\t\t" + getAge());
		System.out.println("Phone number:\t" + getPhoneNumber());
		System.out.println("Email:\t\t" + getEmail());
		System.out.println("Weight:\t\t" + getWeight());
		System.out.println("Height:\t\t" + getHeight());
		double bmi = calculateBMI();
		System.out.println("Calculated BMI:\t" + bmi + "\n");
	}
}

public class HealthRecordDemo {
	public static void main(String[] args) {
		System.out.println("Welcome to the health record management program!\n");
		
		HealthRecord patient = new HealthRecord();
		patient.readInputs();
		patient.display();
		
		System.out.println("Thank you for using the health record management program!");
	}

}

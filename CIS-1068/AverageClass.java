package average;
import java.util.Scanner;

public class AverageClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three integers: ");
		
		// Get the three inputs
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();
		
		// Calculate the total and print it
		double total = num1 + num2 + num3;
		System.out.println("The total is " + total + ".");
		
		// Calculate the average and print it
		double average = (num1 + num2 + num3) / 3;
		System.out.println("The average is " + average + ".");
		
		input.close();
	}

}

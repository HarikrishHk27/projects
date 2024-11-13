package oop3;

import java.util.Scanner;

public class ExceptionHandlingExample {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number to divide 100 by: ");

		try {

			int number = scanner.nextInt();
			int result = 10 / number;
			System.out.println("Result: 10 / " + number + " = " + result);
		} 
		catch (ArithmeticException e) {
			System.out.println("Error: Cannot divide by zero.");
		} 
		catch (Exception e) {
			System.out.println("Error: Invalid input. Please enter a valid integer.");
		} 
		finally {
			System.out.println("Example for ExceptionHandling");
		}
	}
}

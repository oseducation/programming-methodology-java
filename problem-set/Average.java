/*
 * File: FindRange.java
 * --------------------
 * This program is a stub for the FindRange problem, which finds the
 * smallest and largest values in a list of integers.
 */

import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {
	private double getAvarage(int firstNumber, int secondNumber) {
		int sum = firstNumber + secondNumber; // Sum of numbers
		double avarage = (double) sum / 2; // Cast to double and divide by 2
		return avarage;
	}

	public void run() {
		int firstNumber = readInt("Enter first number: ");
		int secondNumber = readInt("Enter second number: ");
		println(getAvarage(firstNumber, secondNumber));
	}

}


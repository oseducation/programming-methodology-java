/*
 * File: Average.java
 * ---------------------------------
 * Average
 * კონსოლიდან წაიკითხეთ ორი რიცხვი, დაბეჭდეთ მათი საშუალო არითმეტიკული.
 */
import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {
	private double getAvarage(int firstNumber, int secondNumber) {
		int sum = firstNumber + secondNumber; // Sum of numbers
		double avarage = (double) sum / 2; // Cast to double and divide by 2
		return avarage;
	}

	public void run() {
		// Getting input values
		int firstNumber = readInt("Enter first number: ");
		int secondNumber = readInt("Enter second number: ");
		println(getAvarage(firstNumber, secondNumber));
	}

}


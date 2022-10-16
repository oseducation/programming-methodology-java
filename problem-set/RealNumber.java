/*
 * File: RealNumber.java
 * ---------------------
 * 
 * ამოცანის პირობა:
 * 	კონსოლიდან წაიკითხეთ ნამდვილი რიცხვი და დაბეჭდეთ მისი მთელი ნაწილი და მისი
 *	წილადი ნაწილი. მაგალითად, მომხმარებელმა თუ შეიყვანა 3.14 თქვენმა პროგრამამ უნდა
 *	დაბეჭდოს 3 და 0.14.
 * 
 */

import acm.program.*;

public class BlankClass extends ConsoleProgram {
	public void run() {
		// We get a real number and store it in a variable.
		double realNumber = readDouble("Input real number: ");
		
		// A method that separates a whole number from a fraction.
		separateNumber(realNumber);
	}

	/* With separateNumber we can first split the real number
	 * into its integer and fractional parts and then print the answer.
	 */
	private void separateNumber(double realNumber) {
		
		// By casting, we turn the value of the float type variable into an int.
		int integralPart = (int) realNumber;
		
		// By subtracting the whole number, we are left with only the fractional part.
		double fractionalPart = realNumber - integralPart;
		
		// Print our results.
		printResult(integralPart, fractionalPart);	
	}
	
	/* Prints our program's results */
	private void printResult(int integralPart, double fractionalPart) {
		
		println("Integral Part: " + integralPart);
		println("Fractional Part: " + fractionalPart);	
		
		/* Example Output:
		   "Integral Part: 3
		    Fractional Part: 0.14" */
	}
	
/*	We can write separateNumber without an additional variable
 * 	and store fractionalPart directly in realNumber.*/
 
	private void separateNumberAlternative(double realNumber) {
		int integralPart = (int) realNumber;
		realNumber -= integralPart;
		printResult(integralPart, realNumber);	
	}




}


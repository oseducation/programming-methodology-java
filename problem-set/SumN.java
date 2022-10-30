/*
 * File: SumN.java
 * ---------------------------------
 * კონსოლიდან წაიკითხეთ n, შემდეგ წაიკითხეთ n ცალი მთელი რიცხვი და დაბეჭდეთ ჯამი.
 */

import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {

	public void run() {
		
		//Getting number of input values
		int n = readInt("Enter n: ");
		int result = 0;
		int tmp;
		
		//Getting numbers from user and increase value of result every iteration
		for(int i = 0; i < n; i++) {
			tmp = readInt("Enter a number for sum: ");
			result += tmp;
		}
		
		println("Sum of received " + n + " numbers is " + result);
	}

}


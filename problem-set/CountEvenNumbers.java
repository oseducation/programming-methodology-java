// importing console program
import acm.program.ConsoleProgram;

/*
 * 	This program reads integers from user until he enters -1 and counts how many
 * 	even numbers are among the entered numbers.
 */

public class CountEvenNumbers extends ConsoleProgram {

	// This global variable is the indicator that we should stop reading integers
	// form user and print the output
	private final static int SENTINEL = -1;

	public void run() {
		// The variable which stores total number of even numbers
		int evens = 0;
		// Reading integers from user and increment 'even' variable if the given number
		// is even
		while (true) {
			int input = readInt("Enter the number or -1 for stop");
			// Check if the number is SENTINEL and stop reading if it is
			if (input == SENTINEL) {
				break;
			}
			if (input % 2 == 0) {
				evens++;
			}
		}
		// Printing the result
		println("The total number of even numbers are: " + evens);
	}
}

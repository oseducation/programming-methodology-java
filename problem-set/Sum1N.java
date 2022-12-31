import acm.program.ConsoleProgram;
/*
 * File: Sum1N.java
 * -----------------
 * In this problem, we read a number and then calculate the sum from 1 to n.
 * Problem review: read an integer N, then print the sum of the numbers from 1 to n.
 */

public class Sum1N extends ConsoleProgram {
	public void run() {
		int n = readInt(); // user inputs an integer n.
		int sum = 0; // define variable which will store result.
		for (int i = 1; i < n; i++) {
			sum += i; // start from 1 to n, add each number in variable sum.
		}
		println(sum);
	}
}

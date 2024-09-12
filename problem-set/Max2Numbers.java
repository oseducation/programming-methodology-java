/*
 * File: Max2Numbers.java
 * --------------------
 * კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი, იპოვეთ და დაბეჭდეთ ამ
 * რიცხვებს შორის ორი მაქსიმალური რიცხვი.
 */

import acm.program.*;

public class Max2Numbers extends ConsoleProgram {

	public void run() {
		// Input
		int input[] = readInput();

		// Find first 2 maximums
		int maxs[] = findMaximums(input);

		// Print
		println();
		println("1st Maximum: " + maxs[0]);
		println("2nd Maximum: " + maxs[1]);
	}

	private int[] readInput() {
		// 1. Read N
		int n = readInt("Input N: ");

		// 2. Read total of N integers
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = readInt("Input number #" + (i + 1) + ": ");
		}
		return arr;
	}

	/*
	 * Return array of length = 2 where 0th element is the maximum and 1st element
	 * is the second maximum
	 */
	private int[] findMaximums(int[] input) {
		int maxs[] = new int[2];

		// Iteration 1
		int maxInd1 = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > input[maxInd1]) {
				maxInd1 = i;
			}
		}
		maxs[0] = input[maxInd1];

		// Iteration 2
		int maxInd2 = (maxInd1 + 1) % input.length;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > input[maxInd2] && i != maxInd1) {
				maxInd2 = i;
			}
		}
		maxs[1] = input[maxInd2];

		return maxs;
	}

}

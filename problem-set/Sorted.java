/*
 * File: Sorted.java
 */

import acm.program.*;

public class Sorted extends ConsoleProgram {

	public void run() {
		/**
		 * Reads number of input-numbers, creates array of that size and write
		 * every number in it
		 */
		int n = readInt();
		
		int numbers[] = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = readInt();
		}

		// Prints the answer
		if (isSorted(numbers)) {
			println("sorted");
		} else {
			println("not sorted");
		}
	}

	/**
	 * Pre Condition - input numbers are already in numbers array
	 * 
	 * Post Condition - tells us if the array is sorted or not
	 * 
	 * @param numbers
	 *            array of int's
	 * @return boolean, true if array is sorted, otherwise false
	 */
	private boolean isSorted(int numbers[]) {
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < numbers[i - 1]) {
				return false;
			}
		}
		return true;
	}

}

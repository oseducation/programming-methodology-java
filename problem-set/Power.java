
/*
 * File: Power.java
 * ---------------------
 * 
 * ამოცანის პირობა:
 * მომხმარებელს შეყავს n და m დაბეჭდეთ n^m
 */

import acm.program.*;

public class Power extends ConsoleProgram {
	public void run() {
		// read input
		int n = readInt("n: ");
		int m = readInt("m: "); 
		println("n^m = " + pow(n, m));
	}

	// returns n^m
	private int pow(int n, int m) {
		int result = 1;
		for (int i = 0; i < m; i++) {
			result *= n;
		}
		return result;
	}
}

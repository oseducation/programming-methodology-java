/*
 * File: ForN.java
 * --------------------
 * კონსოლიდან წაიკითხეთ მთელი რიცხვი n და შემდეგ n ჯერ დაბეჭდეთ “hello ” + i, სადაც i
 * იცვლება 0 დან n-1 მდე.
 */

import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {

	public void run() {

		// Read Input
		int n = readInt();

		for (int i = 0; i < n; i++) {
			println("Hello " + i);
		}
	}
}

import java.io.BufferedReader;

import acm.program.*;
import acm.util.*;

public class BlankConsole extends ConsoleProgram {
	
	public void run() {
		int a = readInt("Enter the first Integer: ");
		int b = readInt("Enter the second Integer: ");
		maxTwoInts(a, b);
	}

	private void maxTwoInts(int a, int b) {
		int bigger;
		if(a > b) {
			bigger = a;
		} else {
			bigger = b;
		}
		println("The bigger integer of the two is " + bigger);
	}
	
}

import java.io.BufferedReader;

import acm.program.*;
import acm.util.*;

public class BlankConsole extends ConsoleProgram {
	
	public void run() {
		int a = readInt("Enter the first Integer: ");
		int b = readInt("Enter the second Integer: ");
		int bigger = a > b ? a : b;
		print("The bigger integer of the two is " + bigger);
	}
	
}
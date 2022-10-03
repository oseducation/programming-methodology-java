
import acm.program.*;

public class average15 extends ConsoleProgram {

	public void run() {
		getAverage();
	}

	// reads 2 integers from console and outputs their average
	private void getAverage() {
		int a = readInt("Enter number #1: "); // read first integer
		int b = readInt("Enter number #2: "); // read second integer
		println((double) (a + b) / 2); // output average
	}
}

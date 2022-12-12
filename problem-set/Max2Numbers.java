import acm.program.ConsoleProgram;

public class Max2Numbers extends ConsoleProgram {
	
	public void run() {
		int n = readInt("enter number of elements: ");
		int max1Elem = Integer.MIN_VALUE;
		int max2Elem = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			int newElem = readInt("enter " + i + "th number: ");
			if (newElem > max1Elem) {
				max2Elem = max1Elem;
				max1Elem = newElem;
			} else if (newElem > max2Elem) {
				max2Elem = newElem;
			}
		}
		println("The 1st max number is: " + max1Elem);
		println("The 2nd max number is: " + max2Elem);
	}
	
}

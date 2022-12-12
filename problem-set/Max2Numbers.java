import acm.program.ConsoleProgram;

public class Max2Numbers extends ConsoleProgram {
	
	public void run() {
		int n = readInt("enter number of elements: ");
		int maxNumber1 = Integer.MIN_VALUE;
		int maxNumber2 = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			int newElem = readInt("enter " + i + "th number: ");
			if (newElem > maxNumber1) {
				maxNumber2 = maxNumber1;
				maxNumber1 = newElem;
			} else if (newElem > maxNumber2) {
				maxNumber2 = newElem;
			}
		}
		println("The 1st max number is: " + maxNumber1);
		println("The 2nd max number is: " + maxNumber2);
	}
	
}

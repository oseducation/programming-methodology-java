/*
 * File: LeastCommonMultiple.java
 * ------------------------------
 *
 * ამოცანის პირობა: მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის
 * უმცირესი საერთო ჯერადი. 
 */
import acm.program.*;

public class LeastCommonMultiple extends ConsoleProgram {

	/*
	 * This method checks if first passed argument is common multiple
	 * of other two arguments
	 */
	private boolean isCommonMultiple(int cur, int firstNum, int secondNum) {
		return cur % firstNum == 0 && cur % secondNum == 0;
	}
	
	/*
	 * This method receives two integers and return least common multiple of them
	 */
	private int findLcm(int firstNum, int secondNum) {		
		int maxNum = Math.max(firstNum, secondNum);
		int lastNum = firstNum * secondNum;
		
		int res = lastNum;
		
		for (int i = maxNum; i < lastNum; i++) {
			if (isCommonMultiple(i, firstNum, secondNum)) {
				res = i;
				return res;
			}
		}
		
		return res;
	}
	
	public void run() {
		int firstNum = readInt("Enter first number: ");
		int secondNum = readInt("Enter second number: ");
		
		while (firstNum <= 0) {
			firstNum = readInt("Enter positive integer");
		}
		
		while (secondNum <= 0) {
			firstNum = readInt("Enter positive integer");
		}
		
		int result = findLcm(firstNum, secondNum);
		println("LCM is: " + result);
	}
}


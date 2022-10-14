/*
* File: NumberOfDivisors.java
* ---------------------------

* ამოცანის პირობა:
* მომხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს n ის გამყოფების რაოდენობა
*/
import acm.program.*;

public class NumberOfDivisors extends ConsoleProgram {
	
	/*
	 * This method counts divisors of the passed number
	 * In comparison with bellow method, this method works faster and does less operations
	 */
	private int countDivisorsFaster(int num) {
	
		int cnt = 0;
		int sqrtN = (int) Math.sqrt(num);
				
		for (int i = 1; i <= sqrtN; i++) {
			if (num % i == 0) {
				cnt += 2;
			}
		}
		
		if (sqrtN * sqrtN == num) {
			cnt--;
		}
		
		return cnt;
	}
	
	/*
	 * This method counts how many divisors passed number has, using for loop
	 */
	private int countDivisors(int num) {
		
		int cnt = 0;

		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				cnt += 1;
			}
		}
		
		return cnt;
	}
	
	public void run() {
		int num = readInt("Enter a number: ");
			
		// In case entered number is not natural
		while (num <= 0) {
			num = readInt("Please enter positive number: ");
		}		
		
		int divs1 = countDivisors(num);
		int divs2 = countDivisorsFaster(num);
		
		println("The number: " + num + " has " + divs1 + " divisors");
		println("The number: " + num + " has " + divs2 + " divisors (Faster Method)");	
	}
}

/* File: StringToInteger.java
 * ---------------------------------
 * დაწერეთ stringToInteger მეთოდი, რომელსაც გადაეცემა სტრინგი და აბრუნებს მთელ რიცხვს.
 * ჩათვალეთ, რომ გადაცემული სტრინგი მხოლოდ ციფრებისგან შედგება და არ იწყება 0-ით.
 * მაგალითად “234” გადაცემის შემთხვევაში მეთოდმა უნდა დააბრუნოს 234. ასევე ჩათვალეთ,
 * რომ დაბრუნებული მნიშვნელობა დადებითია და ეტევა int-ში.
 */

import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {
	
	//Function bellow transforms received string into the Integer
	private int stringToInteger(String num) {
		
		int result = 0;
		
		for(int i = 0; i < num.length(); i++) {
			result *= 10;
			result += (num.charAt(i) - '0');
		}
		
		return result;
	}
	
	public void run() {
		
		//Getting input from user
		String num = readLine("Enter number in string: ");
		
		//Checking if received string is not empty
		if(num.length() != 0) {
			int result = stringToInteger(num);
			println("Converted: " + result);
			
		}else {
			println("No valid string received.");
		}
	}
}


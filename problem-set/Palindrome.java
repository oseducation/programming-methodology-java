/*
 * File: Palindrome.java
 * ---------------------
 * დაწერეთ პრედიკატ მეთოდი რომელსაც გადაეცემა სტრინგი და რომელიც დაადგენს არის თუ
 * არა მოცემული ტექსტი პალინდრომი
 */

import acm.program.*;

public class Palindrome extends ConsoleProgram {
	public void run() {
		String input = readLine("Some string: ");
		
		if (isPalindrome(input)) {
			println("This string is palindrome.");
		} else {
			println("This string is not palindome.");
		}
	}
	
	// checks if s is palindrome
	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
}
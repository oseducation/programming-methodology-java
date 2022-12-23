/*
 * File: ReverseInt .java
 * ---------------------------------
 * User enters an integer, print the number obtained by inverting the digits, 1256 -> 6521.
 */

import acm.program.*;

public class reverseInt extends ConsoleProgram {
	
    public void run() {
		int input = readInt("Enter number to reverse: ");
		println(reverseInt(input)); //print the number obtained by inverting the digits.
	}
	
	/**
	 * PreCondition - Gets one integer input.
	 * PostCondition - return the number obtained by inverting the digits.
	 * */
	private int reverseInt(int input){
		int result = 0;
		boolean negative = false;
		
		if(input < 0){
			negative = true;
			input = -input;
		}
		
		while(input > 0){
			result = result * 10 + input % 10;
			input /= 10;
		}
		
		if(negative){
			return -result;
		}
		return result;
	}
}

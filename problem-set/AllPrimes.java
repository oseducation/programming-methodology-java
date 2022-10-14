/*
 * File: AllPrimes.java
 * --------------------
 * This program is a stub for the AllPrimes problem, which finds and
 * prints first 1000000 prime numbers.
 */

import acm.program.*;

public class AllPrimes extends ConsoleProgram {
	
	private final int N = 1000000;
	
	public void run() {
		printPrimeNumbers(N);
	}
	
	/**
	 * PreCondition - Gets one integer n  
	 * 
	 * PostCondition - Prints all the prime numbers between 1 - n (n is included)
	 * */
	private void printPrimeNumbers(int n) {
		for(int i = 2; i<=n; i++) {
			if(isPrime(i)) println(i);
		}
	}

	/**
	 * PreCondition - Gets one integer n
	 * 
	 * PostCondition - returns boolean, if n is prime returns true, otherwise false
	 *  */
	private boolean isPrime(int n) {
		if (n < 2) return false;
		
		for(int i = 2; i <= Math.sqrt(n); i++){
			if(n % i == 0) return false; 
		}
		return true;
	}
}

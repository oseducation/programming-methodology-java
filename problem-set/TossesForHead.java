/*
 * File: TossesForHead.java
 * ----------------------------
 * თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები და დათვალოთ საშუალოდ
 * რამდენჯერ უნდა ავაგდოთ მონეტა რათა ამოვიდეს ბორჯღალო
 */

import stanford.karel.*;

public class TossesForHead extends ConsoleProgram{

	private static final int SIMULATION_NUM = 1000000;

	public void run() {
		//create Random Generator.
		RandomGenerator rgen = RandomGenerator.getInstance();
		//Variable to sum up all flip numbers to get head.
		int flipNum = 0;
		//Simulating coin flips.
		for(int i = 0; i < SIMULATION_NUM; i++) 
			flipNum += simulateFlips(rgen);
		//Get average number.
		double averageFlipNum = (double) flipNum / SIMULATION_NUM;
		//Print message.
		println("Average coin flip number to get head is " + averageFlipNum + ".");
	}
	
	private int simulateFlips(RandomGenerator rgen) {
		//From start counter is 0.
		int flipNumToGetHead = 0;
		while(true) {
			//If Random Generator returns true, means we flipped head.
			boolean coin = rgen.nextBoolean();
			//Increase counter.
			flipNumToGetHead++;
			//If coin flipped on head, while should break.
			if(coin)
				break;
		}
		return flipNumToGetHead;
	}
	
}


/*
 * File: Addition.java
 * ---------------------
 *
 * ამოცანის პირობა:
 * კარელმა უნდა შეკრიბოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე m
 * ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n+m ბრილიანტი. ჩათვალეთ, რომ
 * კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.
 *
 */

import stanford.karel.SuperKarel;

public class Addition extends SuperKarel {

	public void run() {
		move(); // (1, 1) -> (2, 1)
		transferFrom2x1();
		move(); // (2, 1) -> (3, 1)
		transferFrom3x1();
	}

   
	/*
	 * transfers beepers from (2, 1) to (4, 1)
	 *
	 * precondition: (2, 1) facing east
	 * postcondition: (2, 1) facing east
	 */
	private void transferFrom2x1() {
		while (beepersPresent()) {
			pickBeeper();
			move(); // (2, 1) -> (3, 1);
			move(); // (3, 1) -> (4, 1);
			putBeeper();
			turnAround(); // facing west
			move(); // (4, 1) -> (3, 1)
			move(); // (3, 1) -> (2, 1)
			turnAround(); // facing east
		}
	}


	/*
	 * transfers beepers from (3, 1) to (4, 1)
	 *
	 * precondition: (3, 1) facing east
	 * postcondition: (3, 1) facing east
	 */
	private void transferFrom3x1() {
		while (beepersPresent()) {
			pickBeeper();
			move(); // (3, 1) -> (4, 1);
			putBeeper();
			turnAround(); // facing west
			move(); // (4, 1) -> (3, 1)
			turnAround(); // facing east
		}
	}
}

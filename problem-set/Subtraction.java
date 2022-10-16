/*
 * File: Subtraction.java
 * ----------------------------
 * Subtraction დაეხმარება კარელს ბიპერების გამოკლებაში.
 * 
 * ამოცანის პირობა:
 * კარელმა უნდა გამოაკლოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე
 * m ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n-m ბრილიანტი. ჩათვალეთ, რომ
 * კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს და ჩათვალეთ, რომ n>=m.
 * 
 * დამატებითი ახსნის სანახავად იხილეთ /problem-set/Subtraction.md
 */

import stanford.karel.*;

public class BlankKarel extends SuperKarel {
	public void run() {
		move();
		move(); //get to 3x1 position
		subtractFromThree();
		moveBackwards();
		transferLeftovers();
	}
    /*
     * For every beeper in 3x1 position, this method
     * takes one beeper from 3x1 and one from 2x1.
     * After exiting the loop, n-m beepers are left
     * on position 2x1.
     */
	private void subtractFromThree() {
		while(beepersPresent()) {
			pickBeeper();
			moveBackwards();
			pickBeeper();
			move();
		}
	}
    /*
     * For every beeper left at 2x1 position,
     * this method moves one beeper from 2x1
     * to 4x1. After exiting the loop, n-m
     * beepers will be located on 4x1 position.
     */
	private void transferLeftovers() {
		while(beepersPresent()) {
			pickBeeper();
			move();
			move();
			putBeeper();
			moveBackwards();
			moveBackwards();
		}
	}
    /*
     * This method helps Karel move backwards by
     * one block. Karel retains orientation.
     */
	private void moveBackwards() {
		turnAround();
		move();
		turnAround();
	}
}




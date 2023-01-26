/*
* File: SteepleChase.java
* -----------------------
* Karel runs a steeple chase the is 9 avenues long.
* Hurdles are of arbitrary height and placement.
*/
import stanford.karel.*;

public class SteepleChaseWithComments extends SuperKarel {
	/*
	 * To run a race that is 9 avenues long, we need to move forward or jump hurdles
	 * 8 times.
	 */
	public void run() {
		for (int i = 0; i < 8; i++) {
			if (frontIsClear()) {
				move();
			} else {
				jumpHurdle();
			}
		}
	}

	/*
	 * Pre-condition: Facing East at bottom of hurdle 
	 * Post-condition: Facing East at bottom in next avenue after hurdle
	 */
	private void jumpHurdle() {
		ascendHurdle();
		move();
		descendHurdle();
	}

	/*
	 * Pre-condition: Facing East at bottom of hurdle 
	 * Post-condition: Facing East immediately above hurdle
	 */
	private void ascendHurdle() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		}
		turnRight();
	}

	/*
	 * Pre-condition: Facing East above and immediately after hurdle 
	 * Post-condition: Facing East at bottom of hurdle
	 */
	private void descendHurdle() {
		turnRight();
		moveToWall();
		turnLeft();
	}

	/*
	 * Pre-condition: none 
	 *Post-condition: Facing first wall in whichever direction Karel was facing previously
	 */
	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
}


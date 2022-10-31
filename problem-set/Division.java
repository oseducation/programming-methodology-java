import stanford.karel.SuperKarel;

public class Division extends SuperKarel {
	public void run() {
		move(); // We need to stand on correct starting point.
		while (beepersPresent()) {
			doMainOperation();
		}
		collectBeepers();
	}

	/*
	 * This method describes the main operation. we need to move on third square
	 * first. suppose, we have n beepers on second square and m on third square.
	 * We need to do subtraction n/m times and save that result on fourth
	 * square.
	 */
	private void doMainOperation() {
		move();
		subtractSecondSquare();
		resetThirdSquare();
	}

	/*
	 * starting position: 3x1, facing east ending position: 5x1, facing east/
	 */
	private void subtractSecondSquare() {
		while (beepersPresent()) {
			subtractOperation(); // this line subtracts third square's beepers
									// // from second square's beepers
		}
		increaseResult(); // this method calculates final answer on 4x1 square.
	}

	/*
	 * this method increases result each time by one.
	 */
	private void increaseResult() {
		move();
		putBeeper();
		move();
	}

	/*
	 * this is the main method for subtraction operation for second and third
	 * squares.
	 */
	private void subtractOperation() {
		pickBeeper();
		turnAround();
		move();
		pickBeeper();
		turnAround();
		move();
		move();
		move();
		putBeeper();
		turnAround();
		move();
		move();
		turnAround();
	}

	/*
	 * starting position: 5x1, facing east ending position: 2x1, facing east
	 * this function picks all beepers from 5x1 square and return to third
	 * square to start subtract operation again.
	 */
	private void resetThirdSquare() {
		while (beepersPresent()) {
			pickBeeper();
			turnAround();
			move();
			move();
			putBeeper();
			turnAround();
			move();
			move();
		}
		returnToSecondSquare(); // return to main square to start operation
								// again.
	}

	// starting position 5x1, facing east
	// end position 2x1, facing east.
	private void returnToSecondSquare() {
		turnAround();
		move();
		move();
		move();
		turnAround();
	}

	/*
	 * we need this method to leave beepers only on fourth square. it picks
	 * beepers from third square. starting position 2x1, facing east. end
	 * position: 3x1, facing east.
	 */
	private void collectBeepers() {
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
	}
}
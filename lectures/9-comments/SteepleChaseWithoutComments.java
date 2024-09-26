import stanford.karel.*;

public class SteepleChaseWithoutComments extends SuperKarel {
	
	public void run() {
		for (int i = 0; i < 8; i++) {
			if (frontIsClear()) {
				move();
			} else {
				jumpHurdle();
			}
		}
	}

	private void jumpHurdle() {
		ascendHurdle();
		move();
		descendHurdle();
	}

	private void ascendHurdle() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		}
		turnRight();
	}

	private void descendHurdle() {
		turnRight();
		moveToWall();
		turnLeft();
	}

	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}

}


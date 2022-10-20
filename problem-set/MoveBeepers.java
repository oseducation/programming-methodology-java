/*
 * File: MoveBeepers.java
 * ----------------------------
 * MoveBeepers
 * ცარიელ სამყაროში კარელი დგას 1x1 უჯრაზე. 5x1 უჯრაზე დევს 10 ცალი ბრილიანტი.
 * კარელმა ათივე ბრილიანტი უნდა გადაიტანოს 6x1 უჯრაზე.
 * დეტალური ახსნა შეგიძლიათ იხილოთ MoveBeepers.md ფაილში.
 */

import stanford.karel.*;

public class KarelProgramSample extends Karel {
	private void moveFourTimes() {
		// Karel stands on the cell 1x1.
		for (int i = 0; i < 4; i++) {
			move();
		}
		// Karel stands on the cell 5x1.
	}

	private void pickTenBeepers() {
		for (int i = 0; i < 10; i++) {
			pickBeeper();
		}
		// Karel picks 10 beepers, still stands on the cell 5x1.
	}

	private void putTenBeepers() {
		for (int i = 0; i < 10; i++) {
			putBeeper();
		}
		// Karel puts 10 beepers on the cell 6x1.
	}

	public void run() {
		moveFourTimes();
		pickTenBeepers();
		move(); // Karel moves on the cell 6x1.
		putTenBeepers();
	}

}


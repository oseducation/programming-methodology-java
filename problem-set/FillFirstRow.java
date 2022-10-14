/*
 * File: FillFirstRow.java
 * ----------------------------
 * კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას პირველი ქუჩა ბრილიანტებით. ანუ პირველი ქუჩის 
 * ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. ჩათვალეთ რომ საწყისი სამყარო 
 * ცარიელი არ არის და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი) 
 * ბრილიანტი დევს.
 */

import stanford.karel.*;

public class FillFirstRow extends SuperKarel {

	public void run() {
		//Karel is already on the first row;
		//Karel should move until it face the wall.
		while(frontIsClear()) {
			//While moving, it should place beepers, but if beeper
			//already presents, there is no need to put it.
			checkBeeper();
			//Moving to the next box.
			move();
		}
		//Karel is facing the wall, now it should check the last box.
		checkBeeper();
	}
	
	//Karel checks beepers, if no beepers present, it puts them in
	//the box, where it is standing.
	private void checkBeeper() {
		if (noBeepersPresent())
			 putBeeper();
	}

}

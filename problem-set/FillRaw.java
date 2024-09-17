@@ -1,31 +0,0 @@
/*
* File: FillRaw.java
 * ----------------------------
 * FillRaw დაეხმარება კარელს, შეავსოს ქუჩა ბიპერებით,
 * რომელზედაც ის ამჟამად იმყოფება.
 * 
 * ამოცანის პირობა:
 * კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას პირველი ქუჩა ბრილიანტებით. ანუ პირველი
 * ქუჩის ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. ჩათვალეთ რომ საწყის
 * სამყაროში ბრილიანტები არსად არ დევს.
 */

import stanford.karel.*;

public class FillRaw extends SuperKarel {

	public void run() {
                // Karel must follow the street until it faces the wall.
                // So the execution must be run while front is clear.
                while(frontIsClear()) {
                // While it moves through the street, it places the beepers on the road.
                putBeeper();
                // After placing the beeper, it needs to move to the next box.
                move();
                }
                // Keep in mind the Off-by-one error
                // Take a look at /problem-set/FillRaw.md for further explanation
                putBeeper();
	}

}
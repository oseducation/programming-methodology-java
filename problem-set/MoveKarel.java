/*
 * File: MoveKarel.java
 * ----------------------------
 * MoveKarel დაეხმარება კარელს ბრილიანტის გადატანაში.
 * 
 * ამოცანის პირობა:
 * ცარიელ სამყაროში კარელი დგას 1x1 უჯრაზე. 3x1 უჯრაზე დევს ბრილიანტი, კარელმა 
 * ბრილიანტი უნდა გადაიტანოს 4x1 უჯრაზე და დაამთავროს მუშაობა.
 * 
 * დამატებითი ახსნის სანახავად იხილეთ /problem-set/MoveKarel.md
 */

import stanford.karel.*;

public class BlankKarel extends SuperKarel {
    public void run() {
		move();
        move(); //get to 3x1
        pickBeeper();
        move(); //get to 4x1
        putBeeper();
	}
}

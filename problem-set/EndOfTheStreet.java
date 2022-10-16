
/*
 * File: EndOfTheStreet.java
 * ----------------------------
 * EndOfTheStreet დაეხმარება კარელს გავიდეს პირველი ქუჩის ბოლოში.
 * 
 * ამოცანის პირობა:
 * ცარიელ სამყაროში კარელი დგას 1x1 უჯრაზე, გაიყვანეთ იგი პირველი ქუჩის ბოლომდე. 
 * გაითვალისწინეთ, რომ სამყაროს ზომა არ იცით. თქვენი პროგრამა უნდა მუშაობდეს 
 * ნებისმიერი ზომის სამყაროსათვის.
 * 
 * დამატებითი ახსნის სანახავად იხილეთ /problem-set/EndOfTheStreet.md
 */

import stanford.karel.*;

public class EndOfTheStreet extends SuperKarel {
	public void run() {
		while(frontIsClear()) {
			move(); //Karel should move until it faces a wall.
		}
	}
}


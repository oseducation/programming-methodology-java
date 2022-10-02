

/*
 * File: Sum1N.java
 * ----------------------------
 * Sum1N დაბეჭდავს  1 დან მომხმარებლის რიცხვამდე ყველა ნატურალური რიცხვის ჯამს.
 * 
 * ამოცანის პირობა:
 * მომხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს 1 დან n მდე რიცხვების ჯამი
 */
import acm.program.*;


public class Sum1N extends ConsoleProgram {

	public void run() {
		int num = 0;
		while(num<=0) {
			num = readInt("Enter n: ");
		}
		int sumFormula = (num*(num+1)) / 2;
		println( "Sum of first n natural numbers is : " + sumFormula);
	}
	
}

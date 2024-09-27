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
		int sum = 0;
                while(true){
		   int num = readInt("Enter n: ");
                   if(num > 0){
                      for(int i = 1; i < num;i++){
                         sum = sum + i;
                      }
                      break;
                   }
                }

		println( "Sum of natural numbers untill n is : " + sum);
	}
	
}

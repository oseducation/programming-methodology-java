/*
 * File: RemoveDuplicated.java
 * ---------------------------------
 * დაწერეთ მეთოდი რომელიც გადაცემული ტექსტიდან შლის დუბლირებულ სიმბოლოებს,
 * ანუ თუ ტექსტიში რომელიმე სიმბოლო მეორდება, უნდა დარჩეს მხოლოდ ყველაზე მარცხენა.	 
 */
import java.util.ArrayList;
import java.util.List;

import acm.program.*;


public class RemoveDuplicated extends ConsoleProgram {

	public void run() {
		String str = readLine("Enter string: ");
		str = removeDuplicates(str);
		println(str);
	}
	
	// returns new string with no duplicates (leaves the left most dupliate)
	private String removeDuplicates(String str) {
		List<Character> usedChars = new ArrayList<Character>();
		String res = "";
		for(int i = 0; i<str.length();i++) {
			char ch = str.charAt(i);
			if(!contains(usedChars,ch)) {
				res+=ch;
				usedChars.add(ch);
			}
		}
		return res;
	}
	
	
	//returns true if ls contains ch element
	private boolean contains(List<Character> ls, char ch) {
		for(int i = 0; i<ls.size();i++) {
			if(ls.get(i) == ch) {
				return true;
			}
		}
		return false;
	}

}
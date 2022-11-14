/*
 * File: ReverseInts.java
 * ----------------------------
 * ReverseInts-ის საშუალებით მომხმარებლის მიერ შემოყვანილ რიცხვებს დავბეჭდავთ შებრუნებული მიმდევრობით.
 * 
 * ამოცანის პირობა:
 * კონსოლიდან შეგვყავს რიცხვები მანამ სანამ არ შეიყვანთ -1-ს, დაბეჭდეთ შეყვანილი რიცხვები შებრუნებული მიმდევრობით.
 * 
 * დამატებითი ახსნის სანახავად იხილეთ /problem-set/ReverseInts.md
 */
import java.util.*;

import acm.program.*;

public class BlankClass extends ConsoleProgram {
	private static final int SENTINEL = -1;
	public void run() {
		println("This program reverses the elements in an ArrayList.");
		println("Use " + SENTINEL + " to signal the end of the list.");
		ArrayList<Integer> list = readArrayList();
		reversePrintArrayList(list);
	}
	/*
	 * This method reads user input and saves all
	 * values in an Integer ArrayList. After SENTINEL
	 * is entered, ArrayList is returned.
	 */
	private ArrayList<Integer> readArrayList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true) {
			int n = readInt("Enter a number: ");
			if(n == SENTINEL) break;
			list.add(n);
		}
		return list;
	}
	/*
	 * This method takes an Integer ArrayList and
	 * prints it's elements one by one in reverse.
	 */
	private void reversePrintArrayList(ArrayList<Integer> list) {
		int length = list.size();
		for(int i=length-1;i>=0;i--) {
			println(list.get(i));
		}
	}
}
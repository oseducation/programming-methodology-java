/* File: Sort.java
 * ---------------------------------
 * კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი, დაალაგეთ რიცხვები 
 * ზრდადობით და დაბეჭდეთ.
 */

import java.util.ArrayList;
import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {

	private ArrayList<Integer> selectionSort(ArrayList<Integer> array) {

		int pos;
		int temp;

		for (int i = 0; i < array.size(); i++) {

			pos = i;

			//Find minimal elements index
			for (int j = i + 1; j < array.size(); j++) {

				if (array.get(j) < array.get(pos)) {
					pos = j;
				}
			}
				
			//Swap minimal and i'th elements
			temp = array.get(pos);
			array.set(pos, array.get(i));
			array.set(i, temp);
		}

		return array;
	}
	
	private void printArray(ArrayList<Integer> array) {
		
		for(int i = 0; i < array.size(); i++) {
			
			println(i + " --- " + array.get(i));
		}
	}

	public void run() {

		int n = readInt("N: ");
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		//Fill ArrayList
		for (int i = 0; i < n; i++) {
			int newNum = readInt("Enter Num: ");
			array.add(newNum);
		}

		array = selectionSort(array);
		printArray(array);
	}

}

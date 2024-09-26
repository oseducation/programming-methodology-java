import java.util.HashMap;

import acm.program.ConsoleProgram;
import stanford.karel.SuperKarel;

public class NumberOfNames extends ConsoleProgram {
	public void run() {
		HashMap<String, Integer> myHashMap = new HashMap<>();
		buildHashMap(myHashMap);
		writeStatistics(myHashMap);
	}

	private void buildHashMap(HashMap<String, Integer> myHashMap) {
		while (true) {
			String str = readLine("Enter a word: ");
			if (str.equals(""))
				break;
			if (myHashMap.containsKey(str)) {
				int frequency = myHashMap.get(str);
				frequency += 1;
				myHashMap.put(str, frequency);
			} else {
				myHashMap.put(str, 1);
			}
		}
	}

	private void writeStatistics(HashMap<String, Integer> myHashMap) {
		for (String word : myHashMap.keySet()) {
			println(word + " occurs " + myHashMap.get(word) + " times.");
		}
	}
}
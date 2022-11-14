// Importing console program
import acm.program.ConsoleProgram;

public class MostFrequentSymbol extends ConsoleProgram {
	
	// This program reads string from console and prints the most frequent symbol in it
	public void run() {
		while(true) {
			String input = readLine("Enter the string: ");
			// Initialising array with 26 so that each index has frequency value of the corresponding
			// character.
			int[] frequencies = new int[26];
			countFrequencies(frequencies, input);
			char result = findMostFrequentSymbol(frequencies, input);
			println("The most frequent symbol is: " + result);
		}
	}

	// This method searches and returns the most frequent character
	private char findMostFrequentSymbol(int[] frequencies, String input) {
		int maxFreq = 0;
		char result = 'a';
		for(int i = 0; i < frequencies.length; i++) {
			if(maxFreq < frequencies[i]) {
				result = (char)('a' + i);
				maxFreq = frequencies[i];
			}
		}
		return result;
	}

	// This method counts the frequencies of the characters and stores them in array
	private void countFrequencies(int[] frequencies, String input) {
		for(int i = 0; i < input.length(); i++) {
			char curChar = input.charAt(i);
			int index = -1;
			if(isUpperCase(curChar)) {
				index = curChar - 'A';
			} else if(isLowerCase(curChar)){
				index = curChar - 'a';
			} else {
				continue;
			}
			frequencies[index]++;
		}
	}

	// This method checks if the character is lower case or not
	private boolean isLowerCase(char curChar) {
		if(curChar >= 'a' && curChar <= 'z') {
			return true;
		} else {
			return false;
		}
	}

	// This method checks if the character is upper case or not
	private boolean isUpperCase(char curChar) {
		if(curChar >= 'A' && curChar <= 'Z') {
			return true;
		} else {
			return false;
		}
	}
}

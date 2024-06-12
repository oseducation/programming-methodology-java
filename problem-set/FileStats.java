/*
 * File: FileStats.java
 * ----------------------------
 * დაწერეთ პროგრამა რომელიც ფაილიდან წაიკითხავს ტექტს და დათვლის შემდეგ
 * სტატისტიკებს: სიმბოლოების რაოდენობა, სიტყვების რაოდენობა(სიტყვები სფეისებით
 * გამოყოფილია ერთმანეთისგან), წინადადებების რაოდენობა. რამდენი წინდადება მთავრდება
 * წერტილით, კითხვის ნიშნით და ძახილის ნიშნით?
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

public class FileStats extends ConsoleProgram {

	public void run() {
		// Read Content
		String content = readContent("FileStats.java");

		// Check If Error
		if (content == null)
			return;

		// Evaluate
		int symbolCount = countSymbols(content);
		int wordCount = countWords(content);
		int sentenceCount = countSentences(content);
		int sentencesWithDot = countSentences(content, ".");
		int sentencesWithQuestionMark = countSentences(content, "?");
		int sentencesWithExclamationPoint = countSentences(content, "!");

		// Print Results
		println("Total Symbols: " + symbolCount);
		println("Total Words: " + wordCount);
		println("Total Sentences: " + sentenceCount);
		println("Total Sentences Ending with . : " + sentencesWithDot);
		println("Total Sentences Ending with ? : " + sentencesWithQuestionMark);
		println("Total Sentences Ending with ! : " + sentencesWithExclamationPoint);
	}

	// Read content and write the whole file in one string.
	private String readContent(String fileName) {
		try {
			String content = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = br.readLine(); // 1. read current line

				if (line == null) { // 2. if (line == null) => there are no more lines to read
					break;
				}

				// 3. at this point (line != null) => there are more lines to read
				content += line + '\n'; // 4. append content current line
			}
			br.close();
			return content;
		} catch (Exception e) {
			println(e);
		}
		return null;
	}

	// Count symbols of content
	private int countSymbols(String content) {
		return content.length();
	}

	// Count words by StringTokenizer.
	private int countWords(String content) {
		StringTokenizer st = new StringTokenizer(content);
		return st.countTokens();
	}

	// Count sentences by calling overloaded function
	private int countSentences(String content) {
		return countSentences(content, ".?!");
	}

	// Count sentences depends on marks. Mark is symbol at the end of sentence.
	private int countSentences(String content, String marks) {
		StringTokenizer st = new StringTokenizer(content, marks);
		return st.countTokens() - 1;
	}

}
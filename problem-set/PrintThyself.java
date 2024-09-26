/* File: PrintThyself.java
 * ---------------------------------
 * დაწერეთ პროგრამა რომელიც წაიკითხავს თავის თავს 
 * ფაილიდან და დაბეჭდავს კონსოლში
 */

import java.io.BufferedReader;
import java.io.FileReader;

import acm.graphics.GOval;
import acm.program.*;

public class ConsoleProgrammSample extends ConsoleProgram {
	
	private static final String FILE_NOT_FOUND_MESSAGE = "- ERROR - Can't Locate Recevied File - ERROR -";
	
	private String readFile(String fileName) {
		
		//Trying To Open File
		try {
			
			String result = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			while(true) {
				
				//Reading Every Line Of File
				String newLine = br.readLine();
				//If newLine == null, It Means That There Are No More Line To Read, So While Loop Breaks
				if(newLine == null) break;
				
				//Add newLine To "result"
				result += newLine + '\n';
			}
			
			br.close();
			//Return Result
			return result;
			
		}catch(Exception e) {
			
			System.out.print(e);
		}
		
		//Return Error Message, If Code Catches Errors
		return FILE_NOT_FOUND_MESSAGE;
	}
	
	public void run(){
		
		//Read File Content
		String fileName = readLine("Enter FileName: ");
		String result = readFile(fileName);
		
		//Print File Content
		println("Received File Contains Text: ");
		println(result);
		
	}
	
}

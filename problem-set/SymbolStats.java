/*
 * File: SymbolStats.java
 * ----------------------------
 * ამოცანის პირობა:
 * კონსოლიდან შეგყვავს ტექსტი პროგრამამ უნდა დაბეჭდოს სტატისტიკა რომელი სიმბოლო
 * რამდენჯერ გვხვდება
 */

import acm.program.ConsoleProgram;

import java.util.Map;

public class SymbolStats extends ConsoleProgram {

    public void run() {
        String text = readLine("Enter the text: ");
        countStatistics(text);
    }

    // counting the ocurrencies of all the distinct characters
    private void countStatistics(String text){
        String usedCharacters = "";
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(usedCharacters.indexOf(ch) == -1){
                usedCharacters += ch;
                int num = countCharacters(text , ch);
                println(ch + ": " + num);
            }
        }
    }

    // counting the number of occurrencies of a specific character in the text
    private int countCharacters(String text , char ch){
        int count = 0;
        for(int i = 0; i < text.length(); i++){
            char current = text.charAt(i);
            if(current == ch){
                count++;
            }
        }
        return count;
    }
}

/*
 * File: SymbolOccurrences.java
 * ---------------------
 * ამოცანის პირობა:
 * მომხმარებელს კონსოლიდან შეჰყავს ტექსტი და სიმბოლო,
 * თქვენმა პროგრამამ უნდა იპოვოს რამდენჯერ გვხვდება მოცემულ ტექსტში მოცემული სიმბოლო.
 */

import acm.program.ConsoleProgram;

public class SymbolOccurrences extends ConsoleProgram {

    public void run() {
        // input
        String text = readLine("text: ");
        char symbol = readChar();

        int res = count(text, symbol);

        // print result
        println("Total: " + res);
    }

    /* Asks user to prompt exactly one symbol */
    private char readChar() {
        String symbol = readLine("symbol: ");
        while (symbol.length() != 1) {
            symbol = readLine("Please enter one symbol: ");
        }
        return symbol.charAt(0);
    }

    /* Counts symbol occurrences */
    private int count(String text, char ch) {
        int cnt = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                cnt++;
            }
        }
        return cnt;
    }
}
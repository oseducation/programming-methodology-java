/*
 * File: Anagrams.java
 * ---------------------
 *
 * ამოცანის პირობა:
 * დაწერეთ მეთოდი, რომელსაც გადაეცემა ორი სტრინგი და აბრუნებს true-ს თუკი ეს ორის
 * სტრინგი ერთმანეთის ანაგრამაა, ხოლო წინააღმდე შემთხვევაში აბრუნებს false-ს. ჩათვალეთ,
 * რომ ორივე სტრინგი მხოლოდ ლათინური ალფავიტის პატარა ასოებისგან შედგება.
 * იმპლემენტაცია გააკეთეთ მასივების გამოყენებით შემდეგი ალგორითმით: თითოეული
 * სიტყვისთვის დათვალეთ თითოეული სიმბოლოს რაოდენობა(‘a’-‘z’) და შეინახეთ მასივში.
 * შემდეგ შეადარეთ ერთმანეთს მასივები.
 */

import acm.program.ConsoleProgram;

public class Anagrams extends ConsoleProgram {
    private final int NUM_CHARS = 26;

    public void run() {
        // Input
        String s1 = readLine("String N1: ");
        String s2 = readLine("String N2: ");

        boolean result = isAnagram(s1, s2);

        // Print result
        if (result) {
            println("They are anagrams.");
        } else {
            println("They are not anagrams.");
        }
    }

    private boolean isAnagram(String s1, String s2) {
        // Count char frequencies
        int[] arr1 = countFrequency(s1);
        int[] arr2 = countFrequency(s2);

        for (int i = 0; i < NUM_CHARS; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] countFrequency(String s) {
        int[] arr = new int[NUM_CHARS];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';  // Evaluate char index in array
            arr[index]++;
        }
        return arr;
    }
}

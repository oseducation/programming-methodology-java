import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class NumberOfWords extends ConsoleProgram {
    public void run() {
        String userWord = readLine();
        println(getWordNum(userWord));
    }

    private int getWordNum(String userWord) {
        StringTokenizer tok = new StringTokenizer(userWord);
        int result = 0;
        while(tok.hasMoreTokens()) {
            tok.nextToken();
            result++;
        }
        return result;
    }
}
/*
 * File: Prime.java
 * ---------------------------------
 * დაწერეთ პროგრამა რომელიც დაადგენს შეყვანილი რიცხვი მარტივია თუ არა.
 */
 
import acm.program.ConsoleProgram;

public class Prime extends ConsoleProgram {
    public void run(){
        int p = readInt("Enter a number: ");
        if(isPrime(p)){
            println("Yes");
        } else {
            println("No");
        }
    }
    private boolean isPrime(int p){
        // we check whether a number is less than two, because all the numbers lower than two is not a prime.
        if(p < 2) return false;
        // we iterate over the numbers and check if it is a divisor of p.
        for(int i = 2; i < p; i++){
            // we return false if we found a number that is a divisor of p.
            if(p % i == 0){
                return false;
            }
        }
        // we return true if "if" statemant was not satisfied at least once.
        return true;
    }
}

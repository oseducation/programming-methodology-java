import acm.program.ConsoleProgram;

public class GreatestCommonDivisor extends ConsoleProgram {

    public void run() {
        // Read input
        int x = readInt("Enter first number: ");
        int y = readInt("Enter second number: ");
        // Get the answer using gcd method
        int answer = gcd(x, y);
        // Print the answer
        println("The greatest common divisor of " + x + " and " + y + " is: " + answer);
    }

    private int gcd(int x, int y) {
        // Iterate through all numbers from 2 to the smallest of two
        for (int i = Math.min(x, y); i >= 2; i--) {
            // Check if both x and y are divisible by i
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }
}

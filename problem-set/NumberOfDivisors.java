import acm.program.ConsoleProgram;

public class NumberOfDivisors extends ConsoleProgram {
    public void run() {
        int n = readInt();
        // If n is 0, it has infinity of divisors
        if (n == 0) {
            println("Infinity of divisors");
            return;
        }
        // If n is negative
        if (n < 0) {
            n = -n;
        }
        int answer = findNumberOfDivisors1(n);
        println(answer);
    }

    // Finds number of divisors, loop until n
    private int findNumberOfDivisors1(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                counter++;
            }
        }
        return counter;
    }

    // Finds number of divisors, loop until sqrt(n)
    private int findNumberOfDivisors2(int n) {
        int counter = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == Math.sqrt(n)) {
                    counter++;
                } else {
                    counter += 2;
                }
            }
        }
        return counter;
    }
}

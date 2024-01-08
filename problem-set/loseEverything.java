import acm.program.*;
import acm.util.RandomGenerator;

public class loseEverything extends ConsoleProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int balance = 1000;

	int askUser(String message, int lowerBound, int upperBound) {
		int num = readInt(message);
		while (num < lowerBound || num > upperBound) {
			num = readInt("Wrong input, try again: ");
		}
		return num;
	}

	private void simulateGame(int deposit) {
		while (deposit > 0) {
			int bet = askUser("Place your bet: ", 0, deposit);
			int guess = askUser("Choose number between 0 and 36: ", 0, 36);
			int num = rgen.nextInt(0, 36);
			if (guess == num) {
				deposit *= 2;
				println("You Win! current balance: " + deposit);
			} else {
				deposit -= bet;
				println("You lose. current balance: " + deposit);
			}
		}

		println("Game Over, Good Game");
	}

	public void run() {
		int deposit = balance;
		simulateGame(deposit);
	}

}
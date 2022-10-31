import acm.program.*;
import acm.util.RandomGenerator;

public class tossesFor3Heads extends ConsoleProgram {

	private RandomGenerator rand = RandomGenerator.getInstance();
	private static final int numExperiments = 100000;
	private static final int numHeads = 3;

	public void run() {
		println(avrgTosses(numHeads, numExperiments));
	}

	private double avrgTosses(int numHeads, int numExperiments) {
		int average = 0;
		for (int i = 0; i < numExperiments; i++) {
			average += simulation(numHeads);
		}

		return (double) average / numExperiments;
	}

	private int simulation(int numHeads) {
		int heads = 0;
		int flips = 0;
		while (heads != numHeads) {
			boolean flip = rand.nextBoolean();
			if (flip) {
				heads++;
			} else {
				heads = 0;
			}
			flips++;
		}

		return flips;
	}
}
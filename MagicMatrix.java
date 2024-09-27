import acm.program.ConsoleProgram;

public class MagicMatrix extends ConsoleProgram {

	private boolean magicMatrix(int[][] inp) {
		if (inp.length == 0 || inp.length != inp[0].length) {
			return false;
		}
		for (int r = 0; r < inp.length; r++) {
			for (int c = 0; c < inp[0].length; c++) {
				int rightNum = r * inp.length + c + 1;
				if (inp[r][c] != rightNum) {
					return false;
				}
			}
		}
		return true;
	}
}

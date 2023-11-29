import acm.program.ConsoleProgram;

public class MaxRect  extends ConsoleProgram {

    private int maxRect(int[][] arr) {
        int max = 0;
	for (int r = 0; r < arr.length; r++) {
	    for (int c = 0; c < arr[r].length; c++) {
	    
		if (arr[r][c] == 1) {
		    for (int i = r; i < arr.length; i++) {
			for (int j = c; j < arr[i].length; j++) {
			
			    if (arr[i][j] == 1) {
				if (allOnes(arr, r, c, i, j)) {
				    if ((i - r + 1) * (j - c + 1) > max) {
					max = (i - r + 1) * (j - c + 1);
				    }
				}
			    }
			    
			}
		    }
		}
		
	    }
	}
	return max;
    }

    private boolean allOnes(int[][] arr, int r, int c, int i, int j) {
	for (int k = r; k <= i; k++) {
	    for (int p = c; p <= j; p++) {
		if (arr[k][p] != 1) {
		    return false;
		}
	    }
        }
	return true;
    }
}
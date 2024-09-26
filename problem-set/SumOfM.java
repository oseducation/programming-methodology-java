import java.io.BufferedReader;
import java.util.Arrays;

import acm.graphics.GRect;
import acm.program.*;
import acm.util.*;

public class SumOfM extends ConsoleProgram {
	
	public void run() {
		int m = readInt("Enter sum: ");
		int n = readInt("Enter the amount of elements: ");
		int[] arr = readArray(n);
		Arrays.sort(arr);
		printPair(arr, m);
	}
	
	private boolean contains(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            
            if (arr[mid] == x)
                return true;
            
            if (arr[mid] > x)
                return contains(arr, l, mid - 1, x);
            
            return contains(arr, mid + 1, r, x);
        }
        return false;
    }
	
	private void printPair(int[] arr, int sum) {
		for(int i = 0; i < arr.length; i++) {
			if(contains(arr, i, arr.length-1, sum - arr[i])) {
				println(arr[i] + " + " + (sum - arr[i]) + " equals the sum");
				return;
			}
		}
		println("Sorry, no pairs could be found");
	}
	
	private int[] readArray(int size) {
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = readInt("? ");
		}
		return arr;
	}
}

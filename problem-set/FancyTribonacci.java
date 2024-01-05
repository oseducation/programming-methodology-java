import acm.program.ConsoleProgram;

public class FancyTribonacci extends ConsoleProgram {

	/* The special symbol that breaks the input stream */
	private static final int DELIMITER = -1;
	
	public void run() {
		// Receive first 3 elements of the sequence A
		int A0 = readNumber("A", 0);
		int A1 = readNumber("A", 1);
		int A2 = readNumber("A", 2);
		
		// For debugging purposes:
		printSequence(A0, A1, A2, 20);
		
		// Read the first element of the sequence B
		int B0 = readNumber("B", 1);
		
		// Is the sequence A made of only zeros?
		if(A0 == 0 && A1 == 0 && A2 == 0) {
			solveZeroSpecialCase(B0);
		} else {
			solveProblem(A0, A1, A2, B0);
		}
	}
	
	/**
	 * Solves the special case when every member of A is 0
	 * Precondition: A0 = A1 = A2 = 0
	 */
	private void solveZeroSpecialCase(int currentElement) {
		int currentIndex = 1;
		boolean isResultPositive = true;
		while(true) {
			if(currentElement != 0) {
				isResultPositive = false;
			}
			currentElement = readNumber("B", currentIndex);
			if(currentElement == DELIMITER) {
				break;
			}
			currentIndex++;
		}
		if(isResultPositive) {
			println("Yes 0");
		} else {
			println("No");
		}
	}
	
	/**
	 * Precondition: A0, A1, A2 are not all zeros
	 */
	private void solveProblem(int A0, int A1, int A2, int B0) {
		int B1 = readNumber("B", 1);
		// The sequence B only consists of one element
		if(B1 == DELIMITER) {
			solveProblemForOneElement(A0, A1, A2, B0);
		} else {
			int B2 = readNumber("B", 2);
			// The sequence B is a pair
			if(B2 == DELIMITER) {
				solveProblemForPair(A0, A1, A2, B0, B1);
			} else {
				// The sequence B is at least a triplet
				solveExtendedProblem(A0, A1, A2, B0, B1, B2);
			}
		}
	}
	
	/**
	 * Solves the problem when the length of the sequence B is 1
	 */
	private void solveProblemForOneElement(int A0, int A1, int A2, int B0) {
		int firstIndexOfElement = findFirstIndexOfElement(A0, A1, A2, B0);
		if(firstIndexOfElement == -1) {
			println("No");
		} else {
			println("Yes " + firstIndexOfElement);
		}
	}
	
	/**
	 * Solves the problem when the length of the sequence B is 2
	 */
	private void solveProblemForPair(int A0, int A1, int A2, int B0, int B1) {
		int firstIndexOfPair = findFirstIndexOfPair(A0, A1, A2, B0, B1);
		
		if(firstIndexOfPair == -1) {
			println("No");
		} else {
			println("Yes " + firstIndexOfPair);
		}
	}
	
	/**
	 * Solves the problem when the length of the sequence B >= 3
	 */
	private void solveExtendedProblem(int A0, int A1, int A2, int B0, int B1, int B2) {
		// Now we have B0, B1, B2
		int indexOfTriplet = findIndexOfTriplet(A0, A1, A2, B0, B1, B2);
		
		boolean resultIsPositive = true;
		if(indexOfTriplet == -1) {
			resultIsPositive = false;
		}
		
		int nextIndex = 3;
		int numberOfElements = 3;
		while(true) {
			int nextElement = readNumber("B", nextIndex);
			
			if(nextElement == DELIMITER) {
				break;
			}
			
			int nextElementIndex = findNth(A0, A1, A2, indexOfTriplet + numberOfElements);
			if(nextElementIndex != nextElement) {
				resultIsPositive = false;
			}
			
			numberOfElements++;
			nextIndex++;
		}
		
		if(resultIsPositive) {
			println("Yes " + indexOfTriplet);
		} else {
			println("No");
		}
	}
	
	/**
	 * Reads the number from the user
	 */
	private int readNumber(String sequenceName, int index) {
		return readInt(sequenceName + index + ": ");
	}
	
	/**
	 * Finds the Nth element of the given Tribonacci Sequence
	 * Precondition: A0, A1 and A2 should be passed as first 3 arguments
	 * Postcondition: Returns the Nth element of the given sequence
	 */
	private int findNth(int prevPrev, int prev, int current, int n) {
		if(n == 0) {
			return prevPrev;
		}
		if(n == 1) {
			return prev;
		}
		if(n == 2) {
			return current;
		}
		for(int currentIndex = 2; currentIndex < n; currentIndex++) {
			int nextElement = prevPrev + prev + current;
			prevPrev = prev;
			prev = current;
			current = nextElement;
		}
		return current;
	}
	
	/**
	 * Finds where the first occurence of the element is located in the given sequence 
	 * Precondition: len(B) == 1
	 * Postcondition: Returns -1 if B is not a subsequence of A, otherwise returns n
	 *	that satisfies A_n = B_0
	 */
	private int findFirstIndexOfElement(int A0, int A1, int A2, int element) {
		int currentIndex = 0;
		while(true) {
			int currentElement = findNth(A0, A1, A2, currentIndex);
			if(element == currentElement) {
				return currentIndex;
			}
			if(currentElement > element) {
				break;
			}
			currentIndex++;
		}
		return -1;
	}
	
	/** 
	 * Finds where the first occurence of the pair is located in the given sequence
	 * Precondition: len(B) == 2
	 * Postcondition: Returns -1 if B is not a subsequence of A, otherwise returns n
	 *	that satisfies A_n = B_0
	 */
	private int findFirstIndexOfPair(int A0, int A1, int A2, int firstElement, int secondElement) {
		int currentIndex = 0;
		while(true) {
			int currentElement = findNth(A0, A1, A2, currentIndex);
			int nextElement = findNth(A0, A1, A2, currentIndex + 1);
			
			if(firstElement == currentElement && nextElement == secondElement) {
				return currentIndex;
			}
			
			if(currentElement > secondElement) {
				break;
			}
			
			currentIndex++;
		}
		return -1;
	}
	
	/**
	 * Finds where the subsequence B is located in the sequence A
	 * Precondition: len(B) >= 3
	 * Postcondition: Returns -1 if B is not a subsequence of A, otherwise returns n
	 * 	that satisfies A_n = B_0
	 */
	private int findIndexOfTriplet(int A0, int A1, int A2, int firstElement, int secondElement, int thirdElement) {
		int currentIndex = 0;
		while(true) {
			int currentElement = findNth(A0, A1, A2, currentIndex);
			int nextElement = findNth(A0, A1, A2, currentIndex + 1);
			int nextNextElement = findNth(A0, A1, A2, currentIndex + 2);
			
			if(firstElement == currentElement &&
					nextElement == secondElement &&
					nextNextElement == thirdElement) 
			{
				return currentIndex;
			}
			
			if(currentElement > secondElement) {
				break;
			}
			
			currentIndex++;
		}
		return -1;
	}
	
	/**
	 * For debugging purposes only, prints first numberOfElements members of A
	 */
	private void printSequence(int A0, int A1, int A2, int numberOfElements) {
		for(int currentIndex = 0; currentIndex < numberOfElements; currentIndex++) {
			print(findNth(A0, A1, A2, i) + " ");
		}
		println();
	}
	
}

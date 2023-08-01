import java.io.BufferedReader;

import acm.program.*;
import acm.util.*;

public class BlankConsole extends ConsoleProgram {
	
	public void run() {
		solveMaze();
	}

	private void solveMaze() {
		while(noBeepersPresent()) {
			if(rightIsBlocked()) {
				if(frontIsClear())  {
					move();
				} else {
					while(frontIsBlocked()) 
						turnRight();
				}
			} else {
				turnRight();
				move();
			}
		}
	}
	
}

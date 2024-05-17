import acm.graphics.*;
import acm.program.GraphicsProgram;

/*
 * File: EmptyGrid.java
 * ---------------------
 * 
 *  ამოცანის პირობა:
 * 	ხაზებით ბადის დახატვა 10x10 ზე
 * 
 */


public class EmptyGrid extends GraphicsProgram {
	
	private static final int CELLS = 10; // Number of cells

	public void run() {
		emptyGrid(); // Main method.
	}

	/* The main method that will draw the grid on the canvas */
	private void emptyGrid() {
		
		/* Calculate a gap between each row and column */ 
		int rowGap = getHeight() / CELLS; 
		int columnGap = getWidth() / CELLS;

		drawGrid(rowGap, columnGap); // Draws grid.
		//drawGridAlternative(rowGap, columnGap); // Draws grid with an alternative solution
	}
	
	
	/* This method uses GLine to draw lines on the canvas. */ 
	private void drawGrid(int rowGap, int columnGap) {
		
		/* Draw Rows */
		for(int row = 0; row <= CELLS; row++) {
			
			/* Coordinates */ 
			double x0 = 0;
			double x1 = getWidth();
			double y = row * rowGap;

			GLine line = new GLine(x0, y, x1, y); 
			add(line); 
		}
		
		/* Draw Columns */
		for(int col = 0; col <= CELLS; col++) {
			
			/* Coordinates */
			double y0 = 0;
			double y1 = getHeight();
			double x = col * columnGap;

			GLine line = new GLine(x, y0, x, y1);
			add(line);
		}
	}
	
	/* An alternative solution to the problem.
	 * Instead of GLine, we can use GRect and draw a grid with rectangles. */
	private void drawGridAlternative(int rowGap, int columnGap) {
			
		/* Draw Rectangles */
		for(int row = 0; row < CELLS; row++) { // For each row
			for(int col = 0; col < CELLS; col++) { // For each column
				
				/* Coordinates and size*/ 
				double width = columnGap;
				double height = rowGap;
				double x = col * width;
				double y = row * height;

				GRect rect = new GRect(x, y, width, height);
				add(rect);
			}
		}
	
	}

}


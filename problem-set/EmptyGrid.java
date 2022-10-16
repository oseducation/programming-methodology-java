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


public class BlankClass extends GraphicsProgram {
	
	private static final int CELLS = 10; // Number of cells

	public void run() {
		emptyGrid(); // Main method.
	}

	/* The main method that will draw the grid on the canvas */
	private void emptyGrid() {
		
		/* Calculate a gap between each row and column */ 
		int rowGap = calculateGap(0); 
		int columnGap = calculateGap(1);

		drawGrid(rowGap, columnGap); // Draws grid.
		//drawGridAlternative(rowGap, columnGap); // Draws grid with an alternative solution
	}
	

	/* This method calculates the gap between rows and columns.
	   The method is passed a number - 0 or 1 (int index). We mark 0 as a row and 1 as a column.
	   Because of this marking we don't have to write two methods for rows and for columns. */
	private int calculateGap(int index) {
		
		/* Get width or height of the window depending on index value */ 
		int size = getHeight();
		if(index == 1) size = getWidth();
		
		/* return number of lines which will fit in our window */ 
		return size / CELLS;
	}
	
	/* This method uses GLine to draw lines on the canvas. */ 
	private void drawGrid(int rowGap, int columnGap) {
		
		/* Draw Rows */
		for(int row = 0; row <= CELLS; row++) {
			
			/* Coordinates */ 
			double x0 = 0;
			double x1 = getWidth();
			double y = row * rowGap;

			GLine line = new GLine(x0, y, x1, y); // Initialise GLine object.
			add(line); // Adds a line on the canvas.
		}
		
		/* Draw Columns */
		for(int col = 0; col <= CELLS; col++) {
			
			/* Coordinates */
			double y0 = 0;
			double y1 = getHeight();
			double x = col * columnGap;

			GLine line = new GLine(x, y0, x, y1); // Initialise GLine object.
			add(line); // Adds a line on the canvas.
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

				GRect rect = new GRect(x, y, width, height); // Initialise GRect object.
				add(rect); // Add rectangle on the canvas.
			}
		}
	
	}

}


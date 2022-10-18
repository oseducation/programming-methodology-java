/*
 * File: ChessBoard.java
 * ----------------------------
 * ჭადრაკის დაფის დახატვა 8x8-ზე.
 */

import java.awt.Color;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;;

public class ChessBoard extends GraphicsProgram {

	private int N_ROW = 8;
	private int N_COL = 8;

	@Override
	public void run() {
		double cellSize = calculateCellSize();
		drawCheckerboard(cellSize);
	}

	/*
	 * Calculates cell size by evaluating and finding minimal value by which canvas
	 * can be filled in height or in widh
	 */
	private double calculateCellSize() {
		double height = getHeight();
		double width = getWidth();

		// evaluate both size according to height and width
		double sizeAccordingToWidth = width / N_COL;
		double sizeAccordingToHeight = height / N_ROW;

		// return minimum
		if (sizeAccordingToWidth > sizeAccordingToHeight) {
			return sizeAccordingToHeight;
		} else {
			return sizeAccordingToWidth;
		}
	}

	/*
	 * Draw whole checkerboard with N_COL rows (default 8 rows)
	 */
	private void drawCheckerboard(double cellSize) {
		for (int i = 0; i < N_COL; i++) {
			drawCheckerboardCol(cellSize, i);
		}
	}

	/*
	 * Draw one column of chekerboard with N_ROW cells (default 8 cells)
	 */
	private void drawCheckerboardCol(double cellSize, int rowNum) {
		for (int i = 0; i < N_ROW; i++) {
			drawCheckerboardCell(cellSize, rowNum, i);
		}
	}

	/*
	 * Draw one cell of checkerboard on (rowNum, colNum) coordinates with size of
	 * rectSize
	 * 
	 * Disclaimer: (rowNum, colNum) are coordinates on checkerboard. They should be
	 * converted into pixels
	 */
	private void drawCheckerboardCell(double cellSize, int rowNum, int colNum) {
		double x = cellSize * rowNum;
		double y = cellSize * colNum;

		GRect cell = new GRect(x, y, cellSize, cellSize);
		cell.setFilled(true);
		if ((rowNum + colNum) % 2 == 1) {
			cell.setColor(Color.BLACK);
		} else {
			cell.setColor(Color.ORANGE);
		}
		add(cell);
	}
}

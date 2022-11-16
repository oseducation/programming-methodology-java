/*
 * File: ResizableGrid.java
 * ----------------------------
 * მთელ ფორმაზე ბადის დახატვა, ისე რომ ფორმის ზომის ცვლილებაზე ბადის უჯრის ზომაც
 * პროპორციულად იზრდებოდეს.
 */

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class GraphicsProgramSample extends GraphicsProgram implements ComponentListener {

	// Size of the board
	private final int BOARD_WIDTH = 10;
	private final int BOARD_HEIGHT = 10;

	public void run() {
		addComponentListener(this);
	}

	public void componentResized(ComponentEvent e) {
		drawBoard(getWidth(), getHeight());
	}

	// This method draw board with (width, height) size
	private void drawBoard(int width, int height) {
		removeAll();
		int cellWidth = width / BOARD_WIDTH; // Width of each cell
		int cellHeight = height / BOARD_HEIGHT; // Height of each cell
		for (int k = 0; k < BOARD_WIDTH; k++) {
			for (int i = 0; i < BOARD_HEIGHT; i++) {
				// Coordinates of the (k,i) cell will be (k * cellWidth, i * cellHeight)
				GRect cell = new GRect(k * cellWidth, i * cellHeight, cellWidth, cellHeight);
				add(cell);
			}
		}
	}

	public void componentHidden(ComponentEvent e) {
	}

	public void componentMoved(ComponentEvent e) {
	}

	public void componentShown(ComponentEvent e) {
	}

}


import java.awt.Color;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class house extends GraphicsProgram {
	private static final int WALL_WIDTH = 300;
	private static final int WALL_HEIGHT = 300;
	private static final int ROOF_HEIGHT = 100;
	private static final int HANDLE_OFFSET = 15;
	private static final int HANDLE_SIZE = 5;
	private static final Color WALL_CLR = Color.GRAY;
	private static final Color ROOF_CLR = Color.BLACK;
	private static final Color WINDOW_CLR = Color.YELLOW;
	private static final Color DOOR_CLR = Color.DARK_GRAY;
	private static final Color HANDLE_CLR = Color.BLACK;

	public void run() {
		drawHouse();
	}

	private void drawHouse() {
		drawWall();
		drawWindows();
		drawDoor();
		drawRoof();
	}

	private void drawWall() {
		GRect wall = new GRect(getWidth() / 2 - WALL_WIDTH / 2, getHeight() - WALL_HEIGHT, WALL_WIDTH, WALL_HEIGHT);
		wall.setFilled(true);
		wall.setColor(WALL_CLR);
		add(wall);
	}

	private void drawWindows() {
		GRect window1 = new GRect(getWidth() / 2 - 3 * WALL_WIDTH / 8, getHeight() - 2 * WALL_HEIGHT / 3,
				WALL_WIDTH / 4, WALL_HEIGHT / 5);
		window1.setFilled(true);
		window1.setFillColor(WINDOW_CLR);
		add(window1);
		GRect window2 = new GRect(getWidth() / 2 + WALL_WIDTH / 8, getHeight() - 2 * WALL_HEIGHT / 3, WALL_WIDTH / 4,
				WALL_HEIGHT / 5);
		window2.setFilled(true);
		window2.setFillColor(WINDOW_CLR);
		add(window2);
	}

	private void drawDoor() {
		GRect door = new GRect(getWidth() / 2 - WALL_WIDTH / 8, getHeight() - WALL_HEIGHT / 3, WALL_WIDTH / 4,
				WALL_HEIGHT / 3);
		door.setFilled(true);
		door.setColor(DOOR_CLR);
		add(door);
		GOval handle = new GOval(getWidth() / 2 - WALL_WIDTH / 8 + HANDLE_OFFSET,
				getHeight() - WALL_HEIGHT / 3 + 2 * HANDLE_OFFSET, HANDLE_SIZE, HANDLE_SIZE);
		handle.setFilled(true);
		handle.setColor(HANDLE_CLR);
		add(handle);
	}

	private void drawRoof() {
		GLine line1 = new GLine(getWidth() / 2 - WALL_WIDTH / 2, getHeight() - WALL_HEIGHT, getWidth() / 2,
				getHeight() - WALL_HEIGHT - ROOF_HEIGHT);
		line1.setColor(ROOF_CLR);
		add(line1);
		GLine line2 = new GLine(getWidth() / 2, getHeight() - WALL_HEIGHT - ROOF_HEIGHT,
				getWidth() / 2 + WALL_WIDTH / 2, getHeight() - WALL_HEIGHT);
		line1.setColor(ROOF_CLR);
		add(line2);
	}

}
/*
 * File: MovingBall.java
 * ---------------------
 * 
 * დაწერეთ პროგრამა სადაც იქნება კანვასზე ბურთის მოძრაობა მარცხენა კედლის შუა წერტილიდან მარჯვენა კედლამდე.
 * 
 */

import acm.program.*;
import acm.graphics.GOval;

public class MovingBall extends GraphicsProgram {
	
	private final static int DIAMETER = 100;
	private final static int VELOCITY = 5;
	private final static int PAUSE_tIME = 10;
	
	public void run() {
		GOval ball = drawBall();
		move(ball);
	}
	
	// add ball on canvas
	private GOval drawBall() {
		GOval circle = new GOval(DIAMETER, DIAMETER);
		circle.setFilled(true);
		add(circle, 0, getHeight() / 2.0 - DIAMETER / 2.0);
		return circle;
	}
	
	// move ball from left to right wall
	private void move(GOval circle) {
		while (true) {
			if (circle.getX() >= getWidth() - DIAMETER)
				break;
			circle.move(VELOCITY, 0);
			pause(PAUSE_tIME);
		}
	}
}
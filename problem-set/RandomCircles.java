/*
 * File: RandomCircles.java
 * ----------------------------
 * კანვასზე დახატეთ 1000 შემთხვევითი რადიუსის მქონე შემთხვევითი ფერით გაფერადებული
 * წრე, შემთხვევით კოორდინატებზე.
 * 
 * დეტალური ამოხსნა იხილეთ RandomCircles.md ფაილში.
 */

import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.program.*;
import acm.util.RandomGenerator;

public class GraphicsProgramSample extends GraphicsProgram {

	public void run() {
		for (int i = 0; i < 1000; i++) {
			drawRandomCircle();
		}
	}

	// Draws random circle on the screen.
	private void drawRandomCircle() {
		RandomGenerator rand = new RandomGenerator();
		GPoint location = new GPoint(rand.nextInt(0, getWidth()), rand.nextInt(0, getHeight())); // Generating random X and Y on the screen
		Color color = rand.nextColor();
		int radius = rand.nextInt(10, 100); // The smallest circle will have radius 10, The largest one - 100
		GOval circle = getCircle(location, color, radius);
		add(circle);
	}

	// Creates and returns circle with the given parameters.
	private GOval getCircle(GPoint location, Color color, int radius) {
		GOval circle = new GOval(radius * 2, radius * 2); // We should multiply radius by 2 to get the diameter
		circle.setFilled(true);
		circle.setFillColor(color);
		circle.setLocation(location.getX() - radius, location.getY() - radius); // location is the center of the circle.
		return circle;
	}

}


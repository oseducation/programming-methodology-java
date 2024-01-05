/*
 *	File: RotatingStar.java
 *	-----------------------
 *	This program draws a customizable star and makes it rotate 
 */

import java.util.ArrayList;

import acm.graphics.*;
import acm.program.*;
import javafx.util.Pair;

public class RotatingStar extends GraphicsProgram {

	// Size of the application
	int appWidth = 1000;
	int appHeight = 1000;

	// Center the star will be generated at
	GPoint center = new GPoint(appWidth / 2, appHeight / 2);
	// Amount of corners the star will have
	int points = 5;
	// Amount of points jumped from start to end of single line
	int jumpAm = 2;
	// Radius of the star
	int length = 400;
	// The degree at which the star spins in one iteration
	double speed = 0.5;
	// The delay between iterations
	int delay = 5;

	public void run() {
		setSize(appWidth, appHeight);

		Pair<ArrayList<GLine>, ArrayList<Double>> starInfo = generateStar();
		// Lines the star contains
		ArrayList<GLine> starLines = starInfo.getKey();
		// The degree of each line
		ArrayList<Double> starDegs = starInfo.getValue();

		while (true) {
			rotateStar(starLines, starDegs);
			pause(delay);
		}
	}

	/*
	 * Pre-Condition : None
	 * 
	 * Post-Condition : Displays the star and returns all the relevant information about it
	 */
	private Pair<ArrayList<GLine>, ArrayList<Double>> generateStar() {
		// Amount of radians between each corner
		double jumpDeg = 2 * Math.PI / points;

		ArrayList<GLine> lineRes = new ArrayList<GLine>();
		ArrayList<Double> degRes = new ArrayList<Double>();
		for (int i = 0; i < points; i++) {
			// Get cords of the start and end of a line
			GPoint start = getPointOnCircle(i * jumpDeg);
			// End corner is always jumpAm amount of corners after the starting corner
			GPoint end = getPointOnCircle((i + jumpAm) * jumpDeg);

			GLine curLine = new GLine(
					start.getX(), start.getY(), 
					end.getX(), end.getY());

			lineRes.add(curLine);
			degRes.add(i * jumpDeg);
			add(curLine);
		}
		return new Pair<ArrayList<GLine>, ArrayList<Double>>(lineRes, degRes);
	}

	/*
	 * Pre-Condition : None
	 * 
	 * Post-Condition : Returns the coordinates of a point on the star circle at deg radians
	 */
	private GPoint getPointOnCircle(double deg) {
		return new GPoint(
				center.getX() + length * Math.cos(deg), 
				center.getY() + length * Math.sin(deg));
	}

	/*
	 * Pre-Condition : Star has to be already generated
	 * 
	 * Post-Condition : Rotates the star by speed radians
	 */
	private void rotateStar(ArrayList<GLine> starLines, ArrayList<Double> starDegs) {
		double jumpDeg = 2 * Math.PI / points;
		for (int i = 0; i < points; i++) {
			// Calculate the next rotation degrees
			double nextDeg = (starDegs.get(i) + speed) % (2 * Math.PI);
			
			// Move line points
			GPoint nextStart = getPointOnCircle(nextDeg);
			GPoint nextEnd = getPointOnCircle(nextDeg + jumpAm * jumpDeg);

			starLines.get(i).setStartPoint(nextStart.getX(), nextStart.getY());
			starLines.get(i).setEndPoint(nextEnd.getX(), nextEnd.getY());
			starDegs.set(i, nextDeg);
		}
	}
}
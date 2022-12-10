/*
 * File: PaintLine.java
 * ----------------------------
 * Paint-ის მონაკვეთის ხატვის გაკეთება, ჯერ აჭერ მაუსს, ფიქსირდება ერთი წვერო, მერე
 * მაუსის მოძრაობისას მონაკვეთიც მოძრაობს რადგან მეორე წვერო არაა დაფიქსირებული და
 * კლიკით ფიქსირდება მეორე წვეროც.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class PaintLine extends GraphicsProgram {

	
	private boolean startClicked;
	private boolean endClicked;
	private GLine line;

	//in the start there are no points clicked.
	//adding mouse listeners.
	public void init() {
		startClicked = false;
		endClicked = false;
		addMouseListeners();
	}
	
	//if starting point isn't clicked yet and user clicked it now,
	//add add line on those coordinates.
	//else if end point isn't clicked yet and user clicked it,
	//mark its boolean as true.
	public void mouseClicked(MouseEvent e) {
		if (!startClicked) {
			line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
			add(line);
			startClicked = true;
		} else if (!endClicked) {
			endClicked = true;
		}
	}
	
	//if starting point has already set, update line ending point
	//to show that line ending point is moving with cursor.
	public void mouseMoved(MouseEvent e) {
		if (startClicked && !endClicked) 
			line.setEndPoint(e.getX(), e.getY());
	}

}

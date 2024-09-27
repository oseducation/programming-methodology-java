/*
 * File: Pencil.java
 * ---------------------------- 
 * ამოცანის პირობა:
 * გააკეთეთ Paint-ის ფანქრის ანალოგიური ხელსაწყო. კერძოდ, მაუსის ყოველ მოძრაობაზე
 * ეკრანზე დაამატეთ გაფერადებული წრეწირები იმავე წერტილში სადაც მაუსი მდებარეობს.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Target extends GraphicsProgram
{
	private static final int DIAMETER = 50;
	public void init() {
		addMouseListeners();
	}
	
	public void run()
	{
		
	}	
	public void mouseMoved(MouseEvent e) {
		GOval oval = new GOval(e.getX(),e.getY(),DIAMETER,DIAMETER);
		oval.setFillColor(Color.BLUE);
		oval.setFilled(true); 
		add(oval);
	}
	
}
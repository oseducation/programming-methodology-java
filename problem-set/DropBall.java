/*
 * File: DropBall.java
 * ----------------------------
 * This program is a stub for the DropBall problem.
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.*;

public class GraphicsProgramSample extends GraphicsProgram {
    /** Variables */
    private static final int BALL_RADIUS = 25;
    private GOval ball;

    public void run() {
        ball = createBall(BALL_RADIUS, Color.BLACK);
        addMouseListeners();
        while (true) {
            ball.move(0, 2);
            pause(10);
        }
    }

    /**
     * Create and return GOval object according its arguments
     * 
     * @param radius type - integer, radius of the circle
     * @param c      type - Color, color of the circle
     * @return type - GOval, the circle
     */
    private GOval createBall(int radius, Color c) {
        GOval circle = new GOval(2 * BALL_RADIUS, 2 * BALL_RADIUS);
        circle.setFilled(true);
        circle.setFillColor(c);
        return circle;
    }

    public void mousePressed(MouseEvent event) {
        add(ball, event.getX() - BALL_RADIUS, event.getY() - BALL_RADIUS);
    }

}

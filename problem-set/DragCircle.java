/*
 * File: DragCircle.java
 * ----------------------------
 * ამოცანის პირობა:
 * წრეწირის drag ით გადაადგილება.
 */


import java.awt.*;
import java.awt.event.MouseEvent;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class DragCircle extends GraphicsProgram{

    RandomGenerator rd = RandomGenerator.getInstance();
    GOval circle;

    // drawing random circle
    public void drawCircle(){
        double radius = rd.nextDouble(0 , Math.min(getWidth() , getWidth())/2);
        Color color = rd.nextColor();
        double x = rd.nextDouble(0 , getWidth() - 2*radius);
        double y = rd.nextDouble(0 , getHeight() - 2*radius);
        circle = new GOval(x , y , 2*radius , 2*radius);
        circle.setFilled(true);
        circle.setFillColor(color);
        add(circle);
    }

    public void run(){
        drawCircle();
        addMouseListeners();
    }

    // moving circle with mouse
    public void mouseDragged(MouseEvent e){
        double x = e.getX();
        double y = e.getY();
        Object current = getElementAt(x , y);
        if(current == circle) {
            circle.setLocation(x - circle.getHeight() / 2, y - circle.getWidth() / 2);
        }
    }
}
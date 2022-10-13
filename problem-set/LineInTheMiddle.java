/*
 * File: LineInTheMiddle.java
 * ---------------------
 *
 * ამოცანის პირობა:
 * დაწერეთ პროგრამა, რომლიც ეკრანის შუაში გაავლებს ჰორიზონტალურ ხაზს.
 *
 */

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class LineInTheMiddle extends GraphicsProgram {
    public void run() {
        drawLine();
    }

    private void drawLine() {
        double width =  getWidth();     // get canvas width
        double height = getHeight();    // get canvas height

        GLine line = new GLine(0, height / 2, width, height / 2);
        add(line);  // add line to canvas
    }
}

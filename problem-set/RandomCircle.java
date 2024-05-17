/*
 * File: RandomCircle.java
 * ----------------------------
 * ამოცანის პირობა:
 * 33. დაწერეთ პროგრამა რომელიც კანვასზე დახატავს შემთხვევითი ფერის მქონე წრეწირს,
 *     რაიდიუსიც შემთხვევით აირჩეით შეზღუდული რეინჯიდან.
 */

import java.awt.Color;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class RandomCircle extends GraphicsProgram{
    
    private RandomGenerator rg = RandomGenerator().getInstance();
    
    public void run(){
        drawCircle();
    }

    // randomly generating the position, the color and the diameter of a circle.
    private void drawCircle(){
        double diameter = rg.nextDouble(0 , Math.min(getWidth(),getHeight()));
        double upperX = rg.nextDouble(0 , getWidth() - diameter);
        double upperY = rg.nextDouble(0 , getHeight() - diameter);
        GOval circle = new GOval(upperX , upperY , diameter , diameter);
        Color color = rg.nextColor();
        circle.setFilled(true);
        circle.setColor(color);
        add(circle);

    }


}

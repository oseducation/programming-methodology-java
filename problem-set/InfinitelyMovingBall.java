import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/*
 * File: InfinitelyMovingBall.java
 * ---------------------
 * ამოცანის პირობა:
 * წინა ამოცანის გაგრძელება.
 * დაამატეთ ვერტიკალური კედლებიდან ასხლეტვა, ანუ ბურთი მოძრაობს მარცხენა კედლიდან მარჯვნივ.
 * როგორც კი მარჯვენა კედელს დაეტაკება იმავე სიჩქარით უნდა გააგრძელოს მოძრაობა მაჯვენა კედლიდან მარცხნივ.
 * როგორც კი მარცხენა კედელს დაეტაკება უნდა გააგრძელოს მარჯვნივ და ა.შ. უსასრულოდ.
 */
public class InfinitelyMovingBall extends GraphicsProgram {
    private final int RADIUS = 50;
    private final int DELAY = 10;

    private final double VELOCITY = 7;
    private GOval ball;

    public void run() {
        // Init ball
        createBall();

        // Move ball infinitely
        double ballDx = VELOCITY;
        while (true) {
            double currDx;
            if (ballDx > 0) {   // moving right
                currDx = Math.min(ballDx, getWidth() - ball.getX() - 2 * RADIUS);
            } else {            // moving left
                currDx = Math.max(ballDx, -ball.getX());
            }

            ball.move(currDx, 0);

            if (ball.getX() <= 0 || ball.getX() >= getWidth() - 2 * RADIUS) { // ball reach the bounds
                ballDx *= -1;
            }
            pause(DELAY);
        }

    }

    private void createBall() {
        double x = 0;
        double y = getHeight()/2 - RADIUS;
        ball = new GOval(x, y, 2 * RADIUS, 2 * RADIUS);
        ball.setFilled(true);
        add(ball);
    }
}

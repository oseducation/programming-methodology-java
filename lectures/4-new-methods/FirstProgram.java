import stanford.karel.*;

public class FirstProgram extends Karel {
    public void run() {
        move();
        pickBeeper();
        turnLeft();
        move();
        turnRight();
        move();
        move();
        putBeeper();
        move();
    }

    private void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
import stanford.karel.*;

public class FirstProgram extends Karel {
    public void run() {
        move();
        pickBeeper();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
        turnLeft();
        move();
        move();
        putBeeper();
        move();
    }
}

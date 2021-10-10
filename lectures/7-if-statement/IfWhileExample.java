import stanford.karel.*;

public class IfWhileExample extends Karel {
    public void run() {
        while (frontIsClear()) {
            if (beepersPresent()) {
                pickBeeper();
            }
            move();
        }
        if (beepersPresent()) {
            pickBeeper();
        }
    }
}
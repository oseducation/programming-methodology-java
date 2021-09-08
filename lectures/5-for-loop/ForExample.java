import stanford.karel.*;

public class ForExample extends Karel {
    public void run() {
        for (int i = 0; i < 99; i++) {
            move();
        }
        pickBeeper();
    }
}
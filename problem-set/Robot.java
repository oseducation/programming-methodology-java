
// Importing graphics program.
import acm.program.GraphicsProgram;
// Import for colours.
import java.awt.Color;
// Import for rectangles.
import acm.graphics.GRect;

public class Robot extends GraphicsProgram {

	// Some useful constants
	private static final int FACE_LENGTH = 300;
	private static final int FACE_WIDTH = 400;
	private static final int EYE_SIZE = 50;
	private static final int NECK_WIDTH = 100;
	private static final int NECK_HEIGHT = 300;
	private static final int MOUTH_WIDTH = 100;
	private static final int MOUTH_HEIGHT = 20;
	private static final int MOUTH_OFFSET = 70;

	public void run() {
		drawRobot();
	}

	// This problem can be divided into 4 sub-problems.
	private void drawRobot() {
		drawNeck();
		drawFace();
		drawEyes();
		drawMouth();
	}

	// This method draws the face of the robot. Robot has gray rectangle face.
	private void drawFace() {
		GRect face = new GRect(getWidth() / 2 - FACE_WIDTH / 2, getHeight() / 2 - FACE_LENGTH / 2, FACE_WIDTH,
				FACE_LENGTH);
		face.setFilled(true);
		face.setFillColor(Color.LIGHT_GRAY);
		add(face);
	}

	// This method draws the eyes of the robot. Robot has round black eyes.
	private void drawEyes() {
		// Lets create one universal method in order to not repeat the code.
		drawOneEye(getWidth() / 2 - FACE_WIDTH / 3);
		drawOneEye(getWidth() / 2 + FACE_WIDTH / 3 - EYE_SIZE);
	}
	
	// This method takes the eye width as a parameter and draws black eye with that width.
	private void drawOneEye(int width) {
		GRect eye = new GRect(width, getHeight() / 2 - FACE_LENGTH / 6, EYE_SIZE, EYE_SIZE);
		eye.setFilled(true);
		eye.setColor(Color.BLACK);
		add(eye);
	}

	// This method draws the mouth of the robot. Robot has black rectangle mouth.
	private void drawMouth() {
		GRect mouth = new GRect(getWidth() / 2 - MOUTH_WIDTH / 2, getHeight() / 2 + MOUTH_OFFSET, 
				MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.BLACK);
		add(mouth);
	}

	// This method draws the neck of the robot. Robot has gray rectangle neck.
	private void drawNeck() {
		GRect neck = new GRect(getWidth() / 2 - NECK_WIDTH / 2, getHeight() - NECK_HEIGHT, NECK_WIDTH, NECK_HEIGHT);
		neck.setFilled(true);
		neck.setFillColor(Color.LIGHT_GRAY);
		add(neck);
	}
}

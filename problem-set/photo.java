
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

/*-
 * გააკეთეთ ფოტოების აპლიკაცია.
 * 
 * აპლიკაციას უნდა ჰქონდეს ტექსფილდი სადაც შეიძლება ფოტოს(ფაილის) მისამართის
 * ჩაწერა. ენტერზე დაჭერის შემდეგ ეს ფოტო უნდა გამოჩნდეს ფანჯრის ცენტრში.
 * 
 * image inputs:
 * 	1. s25/naruto.png
 * 	2. s25/bleach.png
 */
public class photo extends GraphicsProgram {

	private JTextField inputText;

	private static final int INPUT_SIZE = 20;

	private void displayError(String imagePath) {
		IODialog dial = getDialog();
		dial.showErrorMessage("Image path does not exist");
	}

	private void addImage(String imageLink) {
		removeAll();

		GImage image = new GImage(imageLink);
		double x = (getWidth() - image.getWidth()) / 2;
		double y = (getHeight() - image.getHeight()) / 2;
		add(image, x, y);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inputText) {
			String immageLink = inputText.getText();
			try {
				addImage(immageLink);
			} catch (Exception ex) {
				displayError(immageLink);
			}
		}
	}

	public void init() {
		inputText = new JTextField(INPUT_SIZE);
		add(inputText, SOUTH);
		inputText.addActionListener(this);
	}

}
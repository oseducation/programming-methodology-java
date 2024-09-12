/*
 * File: Chat.java
 * ---------------------
 * 
 * ამოცანის პირობა:
 * 	თქვენი ამოცანაა გრაფიკული პროგრამის საშუალებით გააკეთოთ ჩატი. ფანჯარაზე, SOUTH
 *	რეგიონზე უნდა გქონდეთ ერთი ტექსტფილდი და ერთი ღილაკი ტექტით Enter.
 *	ტექსტფილდში ტექსტის შეყვანის მერე Enter ჭილაკზე დაჭერით ტექსტი უნდა
 *	იწერებოდეს(იხატებოდეს) კანვასზე ხოლო ტექსტფილდში კი ტექსტი იშლებოდეს. ხელახლა
 *	ტექსტის შეყვანისას ახალი ტექსტი წინა ტექსტის ქვემოთ უნდა გამოცნდეს(როგორც ჩატში
 *	ხდება ხოლმე. თუკი ტექსტი ჩაცდება ეკრანს არაუშავს.
 * 
 */

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acmx.export.javax.swing.JButton;
import acmx.export.javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BlankClass extends GraphicsProgram {
	private static final int BOTTOMSPACE = 30; // The distance between the bottom edge of the window and the last message.
	private static final int X = 15; // The distance between the left edge of the window and messages.
	private static final int GAP = 15; // The distance between messages.
	
	private ArrayList<String> chat; // Stores all messages.
	private JTextField txtField; // Textfield element.
	private JButton enterBtn; // send button element.
	
	public void init() {
		createFieldsAndVector();
		addActionListeners(); // Add ActionListeres to the program.
	}
	
	/* Method initializes textfield and button, the ArrayList structure, and displays the canvas elements */
	private void createFieldsAndVector() {
		
		/* Textfield */
		txtField = new JTextField(20);
		add(txtField, SOUTH);
		txtField.addActionListener(this);
		
		/* Send Button */
		enterBtn = new JButton("Enter");
		add(enterBtn, SOUTH);
		enterBtn.addActionListener(this);
		
		/* ArrayList*/ 
		chat = new ArrayList<>();
	}
	
	/* The method updates the sequence of messages displayed on the canvas
	 * according to the elements of the ArrayList. */
	private void update() {	
		removeAll(); // Removes everything from the canvas.
		int y = getHeight() - BOTTOMSPACE; //Stores y coordinate.
		
		/* For each message */
		for (int i = chat.size() - 1; i >= 0; i--) {
			String message = chat.get(i);
			add(new GLabel(message, X, y));
			y -= GAP;
		}
	}
	
	/* If the client presses enter button or press enter on the keyboard,
	 * the method will read the textfield value, add it to the ArrayList,
	 * and update the canvas.
	 */
	public void actionPerformed(ActionEvent e) {
			String input = txtField.getText();
			txtField.setText(""); // Makes textfield empty.
			
			/* Check for empty string */ 
			if(input != "") {
				chat.add(input);
				update();
			}
	}
	
}
/*
 * File: SchoolGraphics.java
 * ----------------------------
 * ამოცანის პირობა:
 * ჩათვალეთ რომ წინა ამოცანაში აღწერილი School კლასი უკვე არსებობს და შეგიძლიათ
 * გამოყენება. დაწერეთ გრაფიკული პროგრამა რომელიც მოგვცემს საშუალებას დავამატოთ
 * სკოლის შესახებ მონაცემები და შემდეგ გავფილტროთ. სურათზე ნაჩვენებია თუ როგორ უნდა
 * გამოიყურებოდეს გრაფიკული პროგრამა:
 */
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.graphics.GLabel;
import acm.program.*;

public class SchoolGraphics extends GraphicsProgram {
	
	private final int RESULT_X = 40;
	private final int LINE_H = 30;
	
	private JTextField teachField = new JTextField(15);
	private JTextField subjField = new JTextField(15);
	private JTextField pupilField = new JTextField(15);
	
	private JButton addTeachButton = new JButton("Add Teach");
	private JButton addSubjButton = new JButton("Add Subj");
	private JButton addPupilButton = new JButton("Add Pupil");
	
	private JButton displayPupilsButton = new JButton("Display Pupils");
	private JButton displayTeachersButton = new JButton("Display Teachers");
	
	private School school = new School();

	public void init() {
		setSize(1300, 800);
		
		initFields();
		
		addActionListeners();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addTeachButton) {
			onAddTeachButtonCLicked();
			
		} else if (e.getSource() == addSubjButton) {
			onAddSubjButtonCLicked();
			
		} else if (e.getSource() == addPupilButton) {
			onAddPupilButtonCLicked();
			
		} else if (e.getSource() == displayPupilsButton) {
			onDisplayPupilsClicked();
			
		} else if (e.getSource() == displayTeachersButton) {
			onDisplayTeachersClicked();
		}	
	}
	
	private void onDisplayTeachersClicked() {
		String pupil = pupilField.getText();
		Iterator<String> it = school.getTeachers(pupil);
		drawIterator(it);
		clearFields();
	}
	
	private void onDisplayPupilsClicked() {
		String teacher = teachField.getText();
		Iterator<String> it = school.getPupils(teacher);
		drawIterator(it);
		clearFields();
	}
	
	private void onAddTeachButtonCLicked() {
		String teacher = teachField.getText();
		if (!teacher.isEmpty()) {
			school.addTeacher(teacher);
			clearFields();
		}
	}
	
	private void onAddSubjButtonCLicked() {
		String teacher = teachField.getText();
		String subject = subjField.getText();
		
		if (!teacher.isEmpty() && !subject.isEmpty()) {
			school.addSubject(teacher, subject);
			clearFields();
		}
	}
	
	
	private void onAddPupilButtonCLicked() {
		String subject = subjField.getText();
		String pupil = pupilField.getText();
		
		if (!subject.isEmpty() && !pupil.isEmpty()) {
			school.addPupil(pupil, subject);
			clearFields();
		}
			
	}	
	
	private void initFields() {
		JLabel teachLabel = new JLabel("Teach:");
		JLabel subjLabel = new JLabel("Subj:");
		JLabel pupilLabel = new JLabel("pupil:");
		
		add(teachLabel, SOUTH);
		add(teachField, SOUTH);
		
		add(subjLabel, SOUTH);
		add(subjField, SOUTH);
		
		add(pupilLabel, SOUTH);
		add(pupilField, SOUTH);
		
		add(addTeachButton, SOUTH);
		add(addSubjButton, SOUTH);
		add(addPupilButton, SOUTH);
		
		add(displayPupilsButton, SOUTH);
		add(displayTeachersButton, SOUTH);
	}
	
	private void clearFields() {
		teachField.setText("");
		subjField.setText("");
		pupilField.setText("");
	}

	private void drawIterator(Iterator<String> it) {
		if (it == null)
			return;
		
		removeAll();
		
		GLabel result = new GLabel("Results: ");
		int y = LINE_H;
		add(result, RESULT_X,y);
		while (it.hasNext()) {
			GLabel label = new GLabel(it.next());
			y += LINE_H;
			add(label, RESULT_X, y);
		}
	}
}
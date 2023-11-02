import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import acm.program.ConsoleProgram;

public class School extends ConsoleProgram {
	ArrayList<String> teachers; 
	ArrayList<String> subjects;
	ArrayList<String> students;

	Map<String, ArrayList<String>> teachSubj;
	Map<String, ArrayList<String>> subjPupils;

	public School() {
		teachers = new ArrayList<String>();
		subjects = new ArrayList<String>();
		students = new ArrayList<String>();
##
		teachSubj = new HashMap<>();
		subjPupils = new HashMap<>();
	}

	public void addTeacher(String teacher) {
		teachers.add(teacher);
		teach.put(teacher, null);
	}

	public void addSubject(String teacher, String subject) {
		if (teachers.contains(teacher)) {
			if (teachSubj.get(teacher) == null) {
				ArrayList<String> helper = new ArrayList<String>();
				teachSubj.put(teacher, helper);
			}
			if (!teachSubj.get(teacher).contains(subject)) {
				teachSubj.get(teacher).add(subject);
			}
			if (!subjects.contains(subject)) {
				subjects.add(subject);
			}
		}
	}

	public void addPupil(String pupil, String subject) {
		if (subjects.contains(subject)) {
			if (subjPupils.get(subject) == null) {
				ArrayList<String> helper = new ArrayList<String>();
				subjPupils.put(subject, helper);
			}

			subjPupils.get(subject).add(pupil);
			
			students.add(pupil);
		}
	}

	public Iterator<String> getTeachers(String pupil) {
		if (students.contains(pupil)) {
			ArrayList<String> result = new ArrayList<String>();
			for (String teacher : teachSubj.keySet()) {
				ArrayList<String> subj = teachSubj.get(teacher);
				if (subj != null) {
					for (int i = 0; i < subj.size(); i++) {
						ArrayList<String> pupils = subjPupils.get(subj.get(i));
						if (pupils != null) {
							if (pupils.contains(pupil)) {
								result.add(teacher);
								break;
							}
						}
					}
				}
			}
			return result.iterator();
		}
		return null;
	}

	public Iterator<String> getPupils(String teacher) {
		if (teachers.contains(teacher)) {
			ArrayList<String> result = new ArrayList<String>();
			
			ArrayList<String> subj = teachSubj.get(teacher);
			if (subj != null) {
				for (int i = 0; i < subj.size(); i++) {
					ArrayList<String> pupils = subjPupils.get(subj.get(i));
					if(pupils != null){
						for (int j = 0; j < pupils.size(); j++) {
							result.add(pupils.get(j));
						}
					}
				}
			}
			return result.iterator();
		}
		return null;
	}

	public void removeTeacher(String teacher) {
		teachers.remove(teachers.indexOf(teacher));
		teachSubj.remove(teacher);
	}
}
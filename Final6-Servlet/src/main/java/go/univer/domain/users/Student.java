package go.univer.domain.users;

import go.univer.domain.Major;
import go.univer.domain.Subject;

import java.util.List;

public class Student extends User {
	private List<Subject> exams;
	private Major major;
	private int schoolScore;
}

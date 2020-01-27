package go.univer.domain.users;

import go.univer.domain.Major;
import go.univer.domain.Exam;

import java.util.List;

public class Student extends User {
	private List<Exam> exams;
	private Major major;
	private int schoolScore;

}

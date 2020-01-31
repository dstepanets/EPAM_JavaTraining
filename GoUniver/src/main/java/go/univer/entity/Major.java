package go.univer.entity;

import go.univer.entity.users.User;

import java.util.List;

public class Major {
	private final int id;
	private final String title;
	private final List<Exam> exams;
	private final int capacity;
//	private List<User> applicants;

	public Major(int id, String title, List<Exam> exams, int capacity) {
		this.id = id;
		this.title = title;
		this.exams = exams;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public int getCapacity() {
		return capacity;
	}
}

package go.univer.domain;

import go.univer.domain.users.User;

import java.util.List;

public class Major {
	private String title;
	private List<Exam> exams;
	private int capacity;
	private List<User> applicants;
}
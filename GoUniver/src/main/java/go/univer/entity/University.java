package go.univer.entity;

import go.univer.entity.users.User;

import java.util.List;

public class University {
	private final List<User> applicants;
	private final List<User> admins;
	private final List<Major> majors;
	private final List<Exam> exams;

	public University(List<User> applicants, List<User> admins, List<Major> majors, List<Exam> exams) {
		this.applicants = applicants;
		this.admins = admins;
		this.majors = majors;
		this.exams = exams;
	}

	public List<User> getApplicants() {
		return applicants;
	}

	public List<User> getAdmins() {
		return admins;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public List<Exam> getExams() {
		return exams;
	}
}

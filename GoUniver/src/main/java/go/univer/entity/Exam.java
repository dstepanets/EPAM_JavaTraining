package go.univer.entity;

public class Exam {
	private final int id;
	private final String subject;
	private final int mark;

	public Exam(int id, String subject, int mark) {
		this.id = id;
		this.subject = subject;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public int getMark() {
		return mark;
	}

	@Override
	public String toString() {
		return "Exam{" +
				"id=" + id +
				", subject='" + subject + '\'' +
				", mark=" + mark +
				'}';
	}
}

package go.univer.entity.users;

import go.univer.entity.Major;
import go.univer.entity.Exam;

import java.util.List;

public class Student extends User {
	private final List<Exam> examsPassed;
	private final List<Major> majorsApplied;
	private final int schoolScore;

	protected Student(StudentBuilder builder) {
		super(builder);
		this.examsPassed = builder.examsPassed;
		this.majorsApplied = builder.majorsApplied;
		this.schoolScore = builder.schoolScore;
	}



/*	-	-	-	-	-	-	-	BUILDER -	-	-	-	-	-	-	-	-	*/

	public static class StudentBuilder extends UserBuilder<StudentBuilder> {
		private List<Exam> examsPassed;
		private List<Major> majorsApplied;
		private int schoolScore;

		public StudentBuilder() { }

		@Override
		public User build() {
			return new Student(this);
		}

		@Override
		protected StudentBuilder self() {
			return this;
		}

		public StudentBuilder withExamsPassed(List<Exam> examsPassed) {
			this.examsPassed = examsPassed;
			return this;
		}

		public StudentBuilder withMajorsApplied(List<Major> majorsApplied) {
			this.majorsApplied = majorsApplied;
			return this;
		}

		public StudentBuilder withSchoolScore(int schoolScore) {
			this.schoolScore = schoolScore;
			return this;
		}
	}

/*	-	-	-	-	-	-	-	BUILDER -	-	-	-	-	-	-	-	-	*/

	@Override
	public String toString() {
		return "Student{" +
				"examsPassed=" + examsPassed +
				", majorsApplied=" + majorsApplied +
				", schoolScore=" + schoolScore +
				"} " + super.toString();
	}





}

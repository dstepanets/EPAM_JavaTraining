package go.univer.entity.users;

import go.univer.entity.Exam;
import go.univer.entity.Major;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
@Table(name = "users")
public class StudentEntity extends UserEntity {
	@ManyToMany
	@JoinTable(name = "marks", joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "id"))
	private List<Exam> examsPassed;
	@OneToMany
	@JoinTable(name = "majors", joinColumns = @JoinColumn(name = "id"))
	private List<Major> majorsApplied;
	private int schoolScore;	//	TODO add to DB or remove completely
}

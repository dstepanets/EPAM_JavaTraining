package go.univer.domain.users;

public abstract class User {
	private Long id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Role role;
}

enum Role {
	ADMIN,
	STUDENT
}

package go.univer.entity.users;

import java.util.Objects;

public class UserEntity {
	private final Integer id;
	private final String email;
	private final String password;
	private final String salt;
	private final String firstName;
	private final String lastName;
	private final Role role;

	public enum Role {STUDENT, ADMIN}

	protected UserEntity(UserBuilder userBuilder) {
		this.id = userBuilder.id;
		this.email = userBuilder.email;
		this.password = userBuilder.password;
		this.salt = userBuilder.salt;
		this.firstName = userBuilder.firstName;
		this.lastName = userBuilder.lastName;
		this.role = userBuilder.role;
	}

	public static UserBuilder builder() {
		return new UserBuilder();
	}

	/*	-	-	-	-	-	-	-	BUILDER -	-	-	-	-	-	-	-	-	*/

	public static class UserBuilder<SELF extends UserBuilder<SELF>> {
		private Integer id;
		private String email;
		private String password;
		private String salt;
		private String firstName;
		private String lastName;
		private Role role;

		public UserBuilder() {
		}

		public UserEntity build() {
			return new UserEntity(this);
		}

		protected SELF self() {
			return (SELF) this;
		}

		public UserBuilder withId(Integer id) {
			this.id = id;
			return this;
		}

		public UserBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder withPassword(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder withSalt(String salt) {
			this.salt = salt;
			return this;
		}

		public UserBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder withRole(Role role) {
			this.role = role;
			return this;
		}
	}

	/*	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	*/

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getSalt() {
		return salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", role=" + role +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserEntity userEntity = (UserEntity) o;
		return id.equals(userEntity.id) &&
				email.equals(userEntity.email) &&
				password.equals(userEntity.password) &&
				firstName.equals(userEntity.firstName) &&
				lastName.equals(userEntity.lastName) &&
				role == userEntity.role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, password, firstName, lastName, role);
	}
}



package go.univer.domain.users;

public class User {
	private Integer id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Role role;

	public enum Role { STUDENT, ADMIN }

	public User(Builder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.password = builder.password;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.role = builder.role;
	}

	public static Builder builder() {
		return new Builder();
	}

	/*	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	*/

	public static class Builder {
		private Integer id;
		private String email;
		private String password;
		private String firstName;
		private String lastName;
		private Role role;

		private Builder() {}

		public User build() {
			return new User(this);
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withRole(Role role) {
			this.role = role;
			return this;
		}


	}


}



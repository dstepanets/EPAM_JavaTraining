package go.univer.domain.users;

public class User {
	private final Integer id;
	private final String email;
	private final String password;
	private final String firstName;
	private final String lastName;
	private final Role role;

	public enum Role { STUDENT, ADMIN }

	protected User(UserBuilder userBuilder) {
		this.id = userBuilder.id;
		this.email = userBuilder.email;
		this.password = userBuilder.password;
		this.firstName = userBuilder.firstName;
		this.lastName = userBuilder.lastName;
		this.role = userBuilder.role;
	}

//	public static Builder builder() {
//		return new Builder();
//	}

/*	-	-	-	-	-	-	-	BUILDER -	-	-	-	-	-	-	-	-	*/

	public static class UserBuilder<SELF extends UserBuilder<SELF>> {
		private Integer id;
		private String email;
		private String password;
		private String firstName;
		private String lastName;
		private Role role;

		public UserBuilder() {}

		public User build() {
			return new User(this);
		}

		protected SELF self(){
			return (SELF)this;
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


}



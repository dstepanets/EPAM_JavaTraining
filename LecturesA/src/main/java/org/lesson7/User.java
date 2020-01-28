package org.lesson7;


//	TODO make abstract? How?
public class User {

	private final String email;
	private final String password;

	protected User(UserBuilder userBuilder) {
		this.email = userBuilder.email;
		this.password = userBuilder.password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public static class UserBuilder<SELF extends UserBuilder<SELF>> {
		private String email;
		private String password;

		public UserBuilder() {

		}

		public User build() {
			return new User(this);
		}

		public UserBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder withPassword(String password) {
			this.password = password;
			return this;
		}

		@SuppressWarnings("")
		protected SELF self() {
			return (SELF) this;
		}

	}
}

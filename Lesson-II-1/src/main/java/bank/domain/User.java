package bank.domain;

import static bank.utility.CollectionUtility.nullSafeListInit;

import java.util.List;

public class User {
	private final Integer id;
	private final String email;
	private final String password;
	private final List<Account> accounts;


	private User(Builder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.password = builder.password;
		this.accounts = nullSafeListInit(builder.accounts);
	}

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!id.equals(user.id)) return false;
		if (!email.equals(user.email)) return false;
		if (!password.equals(user.password)) return false;
		return accounts.equals(user.accounts);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + accounts.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + "**********" + '\'' +
				", accounts=" + accounts +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	/*	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	*/

	public static class Builder {
		private Integer id;
		private String email;
		private String password;
		private List<Account> accounts;

		private Builder() {}

		public User build() {
			return new User(this);
		}

		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder setAccounts(List<Account> accounts) {
			this.accounts = accounts;
			return this;
		}
	}
}

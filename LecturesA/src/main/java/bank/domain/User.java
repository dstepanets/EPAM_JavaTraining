package bank.domain;

import static bank.utility.CollectionUtility.nullSafeListInit;

import java.util.List;
import java.util.Objects;

public class User {
	private final Long id;
	private final String email;
	private final String password;
	private final String phone;
	private final List<Account> accounts;


	private User(Builder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.password = builder.password;
		this.phone = builder.phone;
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
		return id.equals(user.id) &&
				email.equals(user.email) &&
				password.equals(user.password) &&
				Objects.equals(phone, user.phone) &&
				Objects.equals(accounts, user.accounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, password, phone, accounts);
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", accounts=" + accounts +
				'}';
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	/*	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	*/

	public static class Builder {
		private Long id;
		private String email;
		private String password;
		private String phone;
		private List<Account> accounts;

		private Builder() {}

		public User build() {
			return new User(this);
		}

		public Builder setId(Long id) {
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

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder setAccounts(List<Account> accounts) {
			this.accounts = accounts;
			return this;
		}


	}
}

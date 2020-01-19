package bank;

import bank.domain.User;

public class ConsoleApp {
	public static void main(String[] args) {
		User user = User.builder()
				.setId(1)
				.setEmail("email@email.com")
				.setPassword("pass")
				.setAccounts(null)
				.build();
	}
}

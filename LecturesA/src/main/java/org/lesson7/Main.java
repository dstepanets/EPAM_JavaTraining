package org.lesson7;

public class Main {
	public static void main(String[] args) {
//		Client.builder()
		final Client client = new Client.ClientBuilder()
				.withCode(100)
				.withEmail("user@gmail.com")
				.withPassword("pass")
				.build();
	}
}

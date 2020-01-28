package org.lesson7;

public class Client extends User {

	private final int code;

	public Client(ClientBuilder clientBuilder, int code) {
		super(clientBuilder);
		this.code = code;
	}

	public int getCode() {
		return code;
	}



	public static class ClientBuilder extends UserBuilder <ClientBuilder> {
		private int code;

		public ClientBuilder() {}

		@Override
		public Client build() {
			return new Client(this, code);
		}

		public ClientBuilder withCode(int code) {
			this.code = code;
			return this;
		}

		@Override
		protected ClientBuilder self() {
			return this;
		}
	}
}

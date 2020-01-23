package bank.console;

public class MenuOptions {

	public enum LogIn {
		LOG_IN(1),
		REGISTER(2),
		EXIT(3);

		private int num;

		LogIn(int num) {
			this.num = num;
		}

	}

}

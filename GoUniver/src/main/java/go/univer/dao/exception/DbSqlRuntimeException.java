package go.univer.dao.exception;

public class DbSqlRuntimeException extends RuntimeException {
	public DbSqlRuntimeException() {
	}

	public DbSqlRuntimeException(String message) {
		super(message);
	}

	public DbSqlRuntimeException(String message, Exception cause) {
		super(message, cause);
	}

}

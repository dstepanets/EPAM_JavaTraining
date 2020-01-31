package go.univer;

import go.univer.dao.impl.UserDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {
		UserDaoImpl userDao = new UserDaoImpl();
		System.out.println(userDao.count());
		userDao.findByEmail("sdasdas");

//		loggingTest();
	}

	private static void loggingTest() {
		LOGGER.debug("This is a debug message");
		LOGGER.info("This is an info message");
		LOGGER.warn("This is a warn message");
		LOGGER.error("This is an error message");
		LOGGER.fatal("This is a fatal message");
	}



}

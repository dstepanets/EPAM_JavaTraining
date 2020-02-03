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

		loggingTest();
	}

	private static void loggingTest() {
		LOGGER.debug("YOYOYOYO debug");
		LOGGER.info("OXOXOXOXOXOX info");
		LOGGER.warn("OLOLOLOLOLOLO warn");
		LOGGER.error("TRATRTARTAT error");
		LOGGER.fatal("IOIOIOIOIO fatal");
	}



}

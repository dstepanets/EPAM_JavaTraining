package go.univer;

import go.univer.dao.impl.UserDaoImpl;
import go.univer.entity.users.UserEntity;
import go.univer.injector.AppInjector;
import go.univer.service.PasswordEncryptor;
import go.univer.service.UserService;
import go.univer.service.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Optional;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	private static final UserDaoImpl USER_DAO = new UserDaoImpl();
	private static final UserService USER_SERVICE = AppInjector.getInstance().getUserService();
	private static final UserValidator USER_VALIDATOR = new UserValidator();
	private static final PasswordEncryptor ENCRYPTOR = new PasswordEncryptor();

	public static void main(String[] args) throws SQLException {
//		userDaoTest();
//		loggingTest();
//		validationTest();
//		setDefaultEncyptedPasswordsForInitialUsers();
		testLogin();
	}

	private static void userDaoTest() {

		System.out.println(USER_DAO.count());
		USER_DAO.findByEmail("sdasdas");
	}


	private static void loggingTest() {
		LOGGER.debug("YOYOYOYO debug");
		LOGGER.info("OXOXOXOXOXOX info");
		LOGGER.warn("OLOLOLOLOLOLO warn");
		LOGGER.error("TRATRTARTAT error");
		LOGGER.fatal("IOIOIOIOIO fatal");
	}

	private static void validationTest() {
		UserEntity userEntity = UserEntity.builder()
				.withEmail("god@godmail.god")
				.withPassword("Qwe!23")
				.build();
		USER_VALIDATOR.validate(userEntity);
	}

	private static void setDefaultEncyptedPasswordsForInitialUsers() {
		final String pass = "Qwe!23";
		final String salt = "salt";

		final String encryptedPass = ENCRYPTOR.encrypt(pass, salt);
		USER_DAO.populateDefaultPasswords(encryptedPass);
	}

	private static void testLogin() {
		Optional<UserEntity> user = USER_SERVICE.login("god@godmail.god", "Qwe!23");
		if (user.isPresent()) {
			System.out.println("\nLOGIN SUCCESS! " + user + "\n");
		} else {
			System.out.println("\nLOGIN FAILED!\n");
		}
		user = USER_SERVICE.login("god@godmail.godxx", "Qwe!23");
		System.out.println(user.isPresent());
	}

}

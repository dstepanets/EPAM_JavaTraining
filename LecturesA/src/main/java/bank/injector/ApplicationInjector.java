package bank.injector;

import bank.domain.User;
import bank.repo.UserRepository;
import bank.repo.impl.UserRepositoryImpl;
import bank.service.PasswordEncryptor;
import bank.service.UserService;
import bank.service.impl.UserServiceImpl;
import bank.service.validator.UserValidator;
import bank.service.validator.Validator;

public class ApplicationInjector {

	private static final ApplicationInjector INSTANCE = new ApplicationInjector();

	private static final Validator<User> USER_VALIDATOR = new UserValidator();
	private static final PasswordEncryptor PASSWORD_ENCRYPTOR = new PasswordEncryptor();
	private static final UserRepository USER_REPOSITORY = new UserRepositoryImpl();
	private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRYPTOR, USER_VALIDATOR);

	private ApplicationInjector() {}
	public static ApplicationInjector getInstance() {
		return INSTANCE;
	}

	public UserService getUserService(){
		return USER_SERVICE;
	}

	public UserRepository getUserRepository() {
		return USER_REPOSITORY;
	}
}

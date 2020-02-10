package go.univer.injector;

import go.univer.dao.UserDao;
import go.univer.dao.impl.UserDaoImpl;
import go.univer.entity.users.UserEntity;
import go.univer.mapper.Mapper;
import go.univer.mapper.UserMapper;
import go.univer.service.PasswordEncryptor;
import go.univer.service.UserService;
import go.univer.service.impl.UserServiceImpl;
import go.univer.service.validator.UserValidator;
import go.univer.service.validator.Validator;

public class AppInjector {
	private static final AppInjector INSTANCE = new AppInjector();

	private static final Validator<UserEntity> USER_VALIDATOR = new UserValidator();
	private static final PasswordEncryptor PASSWORD_ENCRYPTOR = new PasswordEncryptor();
	private static final UserDao USER_REPOSITORY = new UserDaoImpl();
	private static final Mapper USER_MAPPER = new UserMapper();
	private static final UserService USER_SERVICE =
							new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRYPTOR, USER_VALIDATOR, USER_MAPPER);

	private AppInjector() {
	}

	public static AppInjector getInstance() {
		return INSTANCE;
	}

	public UserService getUserService() {
		return USER_SERVICE;
	}

	public UserDao getUserRepository() {
		return USER_REPOSITORY;
	}
}

package go.univer.injector;

import go.univer.controller.command.FrontCommand;
import go.univer.controller.command.HomeCommand;
import go.univer.controller.command.LoginCommand;
import go.univer.controller.command.LogoutCommand;
import go.univer.controller.command.RegisterCommand;
import go.univer.controller.command.admin.ListUsersCommand;
import go.univer.dao.UserDao;
import go.univer.dao.impl.UserDaoImpl;
import go.univer.domain.User;
import go.univer.entity.users.UserEntity;
import go.univer.mapper.Mapper;
import go.univer.mapper.UserMapper;
import go.univer.service.PasswordEncryptor;
import go.univer.service.UserService;
import go.univer.service.impl.UserServiceImpl;
import go.univer.service.validator.UserValidator;
import go.univer.service.validator.Validator;

import java.util.HashMap;
import java.util.Map;

public class AppInjector {
	private static final AppInjector INSTANCE = new AppInjector();

	private static final Validator<User> USER_VALIDATOR = new UserValidator();
	private static final PasswordEncryptor PASSWORD_ENCRYPTOR = new PasswordEncryptor();
	private static final UserDao USER_REPOSITORY = new UserDaoImpl();
	private static final Mapper<UserEntity, User> USER_MAPPER = new UserMapper();
	private static final UserService USER_SERVICE =
			new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRYPTOR, USER_VALIDATOR, USER_MAPPER);
	private static final Map<String, FrontCommand> COMMANDS = new HashMap<>();

	static {
		COMMANDS.put("/home", new HomeCommand());
		COMMANDS.put("/login", new LoginCommand(USER_SERVICE));
		COMMANDS.put("/register", new RegisterCommand(USER_SERVICE));
		COMMANDS.put("/logout", new LogoutCommand());
		COMMANDS.put("/admin/users", new ListUsersCommand(USER_SERVICE));
	}

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

	public Map<String, FrontCommand> getCommands() {
		return COMMANDS;
	}
}

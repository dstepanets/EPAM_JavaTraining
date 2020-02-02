package go.univer.service.impl;

import go.univer.dao.Page;
import go.univer.dao.PaginalList;
import go.univer.dao.UserDao;
import go.univer.entity.users.User;
import go.univer.service.PasswordEncryptor;
import go.univer.service.UserService;
import go.univer.service.validator.Validator;

import java.util.List;

public class UserServiceImpl implements UserService {
	private static final int USERS_PER_PAGE = 5;

	private final UserDao userRepository;
	private final PasswordEncryptor passwordEncryptor;
	private final Validator<User> userValidator;

	public UserServiceImpl(UserDao userRepository, PasswordEncryptor passwordEncryptor,
						   Validator<User> userValidator) {
		this.userRepository = userRepository;
		this.passwordEncryptor = passwordEncryptor;
		this.userValidator = userValidator;
	}

	@Override
	public boolean login(String email, String password) {
//		TODO validate email / pass before enctypting
		String encryptedPassword = passwordEncryptor.encrypt(password);

		return userRepository.findByEmail(email)
				.map(User::getPassword)
//				.filter(pass -> pass.equals(password))
				.filter(pass -> pass.equals(encryptedPassword))
				.isPresent();
	}

	@Override
	public User register(User user) {
		userValidator.validate(user);
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("User with this email was registered already");
		}
		user.encryptPassword(passwordEncryptor);
		userRepository.save(user);
//		id треба дістати/ повертати?
		return user;
	}

	@Override
//	return value tmp - think what to use
	public PaginalList<User> findAll(int page) {
//		TODO validate int page OR if page !valid, use default (e.g. -5 -> 1; (x > maxPage) -> maxPage)
		PaginalList<User> allUsers = userRepository.findAll(new Page(page, USERS_PER_PAGE));
		return allUsers;
	}
}

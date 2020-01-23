package bank.service.impl;

import bank.domain.User;
import bank.repo.Page;
import bank.repo.UserRepository;
import bank.repo.impl.Pageable;
import bank.service.PasswordEncryptor;
import bank.service.UserService;
import bank.service.validator.UserValidator;
import bank.service.validator.Validator;

import java.util.List;

public class UserServiceImpl implements UserService {
	private static final int USERS_PER_PAGE = 5;

	private final UserRepository userRepository;
	private final PasswordEncryptor passwordEncryptor;
	private final Validator<User> userValidator;

	public UserServiceImpl(UserRepository userRepository, PasswordEncryptor passwordEncryptor,
						   Validator<User> userValidator) {
		this.userRepository = userRepository;
		this.passwordEncryptor = passwordEncryptor;
		this.userValidator = userValidator;
	}

	@Override
	public boolean login(String email, String password) {
		String encryptedPassword = passwordEncryptor.encrypt(password);
//		TODO encryptor

		return userRepository.findByEmail(email)
				.map(User::getPassword)
				.filter(pass -> pass.equals(encryptedPassword))
				.isPresent();
	}

	@Override
	public User register(User user) {
		userValidator.validate(user);
		userRepository.save(user);
//		id треба дістати/ повертати?
		return user;
	}

	@Override
//	return value tmp - think what to use
	public List<User> findAll(int page) {
//		TODO validate int page OR if page !valid, use default (e.g. -5 -> 1; (x > maxPage) - > maxPage)
		Pageable<User> all = userRepository.findAll(new Page(page, USERS_PER_PAGE));
		return null;
	}
}

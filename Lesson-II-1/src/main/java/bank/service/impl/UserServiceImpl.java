package bank.service.impl;

import bank.domain.User;
import bank.repo.UserRepository;
import bank.service.PasswordEncryptor;
import bank.service.UserService;
import bank.service.validator.UserValidator;
import bank.service.validator.Validator;

public class UserServiceImpl implements UserService {
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
				.map(user -> user.getPassword())
				.filter(pass -> pass.equals(encryptedPassword))
				.isPresent();
	}

	@Override
	public User register(User user) {
		userValidator.validate(user);
		userRepository.save(user);
//		id треба дістати повертати?
		return user;
	}
}

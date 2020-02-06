package go.univer.service.impl;

import go.univer.dao.Page;
import go.univer.dao.PaginalList;
import go.univer.dao.UserDao;
import go.univer.entity.users.User;
import go.univer.service.PasswordEncryptor;
import go.univer.service.UserService;
import go.univer.service.validator.ValidationException;
import go.univer.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class UserServiceImpl implements UserService {
	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
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
	public Optional<User> login(String email, String password) {
		try {
			User tmpUser = User.builder().withEmail(email).withPassword(password).build();
			userValidator.validate(tmpUser);
		} catch (ValidationException e) {
			LOG.info(e);
			return Optional.empty();
		}
		final Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent()) {
			String encryptedPassword = passwordEncryptor.encrypt(password, user.get().getSalt());
			if (encryptedPassword.equals(user.get().getPassword()))
				return user;
		}
		return Optional.empty();
	}

	@Override
	public User register(User user) {
//		TODO Deal with ValidationException
		userValidator.validate(user);
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("User with this email was registered already");
		}
		final String salt = passwordEncryptor.generateStringSalt();
		final String encryptedPass = passwordEncryptor.encrypt(user.getPassword(), salt);
		User newUser = User.builder()
				.withEmail(user.getEmail())
				.withPassword(encryptedPass)
				.withSalt(salt)
				.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withRole(user.getRole())
				.build();
		userRepository.save(newUser);
//		як варіант, id повертати?
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

package go.univer.service.impl;

import go.univer.dao.Page;
import go.univer.dao.PaginalList;
import go.univer.dao.UserDao;
import go.univer.entity.users.UserEntity;
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
	private final Validator<UserEntity> userValidator;

	public UserServiceImpl(UserDao userRepository, PasswordEncryptor passwordEncryptor,
						   Validator<UserEntity> userValidator) {
		this.userRepository = userRepository;
		this.passwordEncryptor = passwordEncryptor;
		this.userValidator = userValidator;
	}

	@Override
	public Optional<UserEntity> login(String email, String password) {
		try {
			UserEntity tmpUserEntity = UserEntity.builder().withEmail(email).withPassword(password).build();
			userValidator.validate(tmpUserEntity);
		} catch (ValidationException e) {
			LOG.debug(e);
			return Optional.empty();
		}
		final Optional<UserEntity> user = userRepository.findByEmail(email);
		if (user.isPresent()) {
			String encryptedPassword = passwordEncryptor.encrypt(password, user.get().getSalt());
			if (encryptedPassword.equals(user.get().getPassword()))
				return user;
		}
		return Optional.empty();
	}

	@Override
	public UserEntity register(UserEntity userEntity) {
//		TODO Deal with ValidationException
		userValidator.validate(userEntity);
		if (userRepository.findByEmail(userEntity.getEmail()).isPresent()) {
			throw new RuntimeException("User with this email was registered already");
		}
		final String salt = passwordEncryptor.generateStringSalt();
		final String encryptedPass = passwordEncryptor.encrypt(userEntity.getPassword(), salt);
		UserEntity newUserEntity = UserEntity.builder()
				.withEmail(userEntity.getEmail())
				.withPassword(encryptedPass)
				.withSalt(salt)
				.withFirstName(userEntity.getFirstName())
				.withLastName(userEntity.getLastName())
				.withRole(userEntity.getRole())
				.build();
		userRepository.save(newUserEntity);
//		як варіант, id повертати?
		return userEntity;
	}

	@Override
//	return value tmp - think what to use
	public PaginalList<UserEntity> findAll(int page) {
//		TODO validate int page OR if page !valid, use default (e.g. -5 -> 1; (x > maxPage) -> maxPage)
		PaginalList<UserEntity> allUsers = userRepository.findAll(new Page(page, USERS_PER_PAGE));
		return allUsers;
	}
}

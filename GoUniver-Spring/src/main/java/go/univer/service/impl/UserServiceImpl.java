package go.univer.service.impl;

import go.univer.repository.Page;
import go.univer.repository.PaginalList;
import go.univer.repository.UserDao;
import go.univer.domain.User;
import go.univer.entity.users.UserEntity;
import go.univer.mapper.Mapper;
import go.univer.service.PasswordEncryptor;
import go.univer.service.UserService;
import go.univer.service.validator.ValidationException;
import go.univer.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
	private static final int USERS_PER_PAGE = 5;

	private final UserDao userDao;
	private final PasswordEncryptor passwordEncryptor;
	private final Validator<UserEntity> userValidator;
	private final Mapper<UserEntity, User> userMapper;

	public UserServiceImpl(UserDao userDao, PasswordEncryptor passwordEncryptor,
						   Validator<UserEntity> userValidator, Mapper<UserEntity, User> userMapper) {
		this.userDao = userDao;
		this.passwordEncryptor = passwordEncryptor;
		this.userValidator = userValidator;
		this.userMapper = userMapper;
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
		final Optional<UserEntity> user = userDao.findByEmail(email);
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
		if (userDao.findByEmail(userEntity.getEmail()).isPresent()) {
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
		userDao.save(newUserEntity);
//		як варіант, id повертати?
		return userEntity;
	}

	@Override
	public List<User> findAll(String strPageNum) {
		int pageNum = parsePageNumber(strPageNum);

		PaginalList<UserEntity> userEntityPaginalList = userDao.findAll(new Page(pageNum, USERS_PER_PAGE));

		return userEntityPaginalList.getItems().stream()
				.map(userMapper::mapEntityToDomain)
				.collect(Collectors.toList());
	}

	@Override
	public int getUsersCount() {
		return userDao.count();
	}

	private int parsePageNumber(String strPageNum) {
		final int firstPage = 1;
		if (strPageNum == null) {
			return firstPage;
		}
		int usersCount = userDao.count();
		int maxPage = usersCount / USERS_PER_PAGE + ((usersCount % USERS_PER_PAGE == 0) ? 0 : 1);

		try {
			final int p = Integer.parseInt(strPageNum);
			if (p > maxPage) {
				return maxPage;
			} else if (p < 1) {
				return firstPage;
			}
			return p;
		} catch (NumberFormatException e) {
			LOG.warn("Wrong page number format.");
			return firstPage;
		}
	}
}

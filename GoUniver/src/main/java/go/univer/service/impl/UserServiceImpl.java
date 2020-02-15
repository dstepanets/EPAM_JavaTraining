package go.univer.service.impl;

import go.univer.dao.Page;
import go.univer.dao.PaginalList;
import go.univer.dao.UserDao;
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
	private final Validator<User> userValidator;
	private final Mapper<UserEntity, User> userMapper;

	public UserServiceImpl(UserDao userDao, PasswordEncryptor passwordEncryptor,
						   Validator<User> userValidator, Mapper<UserEntity, User> userMapper) {
		this.userDao = userDao;
		this.passwordEncryptor = passwordEncryptor;
		this.userValidator = userValidator;
		this.userMapper = userMapper;
	}

	@Override
	public Optional<User> login(String email, String password) {
		try {
			User tmpUser = User.builder().withEmail(email).withPassword(password).build();
			userValidator.validate(tmpUser);
		} catch (ValidationException e) {
			LOG.debug(e);
			return Optional.empty();
		}
		final Optional<UserEntity> userEntity = userDao.findByEmail(email);
		if (userEntity.isPresent()) {
			String encryptedPassword = passwordEncryptor.encrypt(password, userEntity.get().getSalt());
			if (encryptedPassword.equals(userEntity.get().getPassword()))
				return Optional.of(userMapper.mapEntityToDomain(userEntity.get()));
		}
		return Optional.empty();
	}

	@Override
	public User register(User user) throws ValidationException {
		userValidator.validate(user);
		if (userDao.findByEmail(user.getEmail()).isPresent()) {
			throw new ValidationException("User with this email was registered already");
		}
		final String salt = passwordEncryptor.generateStringSalt();
		final String encryptedPass = passwordEncryptor.encrypt(user.getPassword(), salt);
		UserEntity newUserEntity = UserEntity.builder()
				.withEmail(user.getEmail())
				.withPassword(encryptedPass)
				.withSalt(salt)
				.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withRole(UserEntity.Role.valueOf(user.getRole().name()))
				.build();
		userDao.save(newUserEntity);
//		як варіант, id повертати?
		return user;
	}

	@Override
	public PaginalList<User> findAll(String strPageNum) {
		int pageNum = parsePageNumber(strPageNum);

		PaginalList<UserEntity> userEntityPaginalList = userDao.findAll(new Page(pageNum, USERS_PER_PAGE));
		List<User> userList = userEntityPaginalList.getItems().stream()
				.map(userMapper::mapEntityToDomain)
				.collect(Collectors.toList());
		return new PaginalList<User>(userList, userEntityPaginalList.getPage(), userEntityPaginalList.getMaxPageNumber());
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

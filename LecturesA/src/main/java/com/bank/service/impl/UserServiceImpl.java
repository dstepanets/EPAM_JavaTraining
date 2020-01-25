package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.dao.Page;
import com.bank.dao.UserDao;
import com.bank.dao.impl.Pageable;
import com.bank.service.PasswordEncryptor;
import com.bank.service.UserService;
import com.bank.service.validator.Validator;

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
//		TODO validate email / pass before enctypting ?
		String encryptedPassword = passwordEncryptor.encrypt(password);
//		TODO encryptor

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
			throw new RuntimeException("The user with this email was registered already");
		}
		user.encryptPassword(passwordEncryptor);
		userRepository.save(user);
//		id треба дістати/ повертати?
		System.out.println("||>>> " + user);
		return user;
	}

	@Override
//	return value tmp - think what to use
	public List<User> findAll(int page) {
//		TODO validate int page OR if page !valid, use default (e.g. -5 -> 1; (x > maxPage) -> maxPage)
		Pageable<User> all = userRepository.findAll(new Page(page, USERS_PER_PAGE));
		return null;
	}
}

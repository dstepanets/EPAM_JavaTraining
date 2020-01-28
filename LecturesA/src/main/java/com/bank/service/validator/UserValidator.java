package com.bank.service.validator;

import com.bank.entity.User;

import java.util.function.Function;
import java.util.regex.Pattern;

//		TODO validate. Throw exception if fails. Для імейла - регулярку, і пароля - теж.

public class UserValidator implements Validator<User> {
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&*+/=?`{}~^.-]+@[a-zA-Z0-9.-]+$");
	private static final Pattern PASSWORD_PATTERN = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
	private static final Pattern TELEPHONE_PATTERN = Pattern.compile("([+]*38[(]?[0-9]{1,4}[)]?[-\\s./0-9]*)");

	@Override
	public void validate(User user) {
		if (user == null) {
			throw new ValidateException("User not found");
		}
		validateEmail(user);
		validatePassword(user);
		validatePassword(user);
	}

	private static void validateEmail(User user) {
		validateString(EMAIL_PATTERN, user, User::getEmail, "Email doesn't match the pattern");
	}

	private static void validatePassword(User user){
		validateString(PASSWORD_PATTERN, user, User::getPassword, "Password doesn't match the pattern");
	}

	private static void validatePhone(User user) {
		validateString(TELEPHONE_PATTERN, user, User::getPhone, "Phone number doesn't match the pattern");
	}

	private static void validateString(Pattern pattern, User user, Function<User, String> function,
									   String exceptionMessage) {
		if (!pattern.matcher(function.apply(user)).matches()) {
			throw new ValidateException(exceptionMessage);
		}
	}


}



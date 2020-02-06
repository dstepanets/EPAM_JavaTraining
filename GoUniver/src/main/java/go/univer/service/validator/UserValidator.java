package go.univer.service.validator;

import go.univer.entity.users.UserEntity;

import java.util.function.Function;
import java.util.regex.Pattern;

public class UserValidator implements Validator<UserEntity> {
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&*+/=?`{}~^.-]+@[a-zA-Z0-9.-]+$");
	private static final Pattern PASSWORD_PATTERN = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=]).{6,})");

	@Override
	public void validate(UserEntity userEntity) {
		if (userEntity == null) {
			throw new ValidationException("Empty user on validation");
		}
		validateEmail(userEntity);
		validatePassword(userEntity);
	}

	private static void validateEmail(UserEntity userEntity) {
		validateString(EMAIL_PATTERN, userEntity, UserEntity::getEmail, "Email doesn't match the pattern");
	}

	private static void validatePassword(UserEntity userEntity) {
		validateString(PASSWORD_PATTERN, userEntity, UserEntity::getPassword, "Password doesn't match the pattern");
	}

	private static void validateString(Pattern pattern, UserEntity userEntity, Function<UserEntity, String> function,
									   String exceptionMessage) {
		if (!pattern.matcher(function.apply(userEntity)).matches()) {
			throw new ValidationException(exceptionMessage);
		}
	}


}



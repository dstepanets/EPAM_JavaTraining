package go.univer.service.impl;

import go.univer.dao.impl.UserDaoImpl;
import go.univer.entity.users.User;
import go.univer.service.PasswordEncryptor;
import go.univer.service.validator.UserValidator;
import go.univer.service.validator.ValidationException;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	private static final String EMAIL = "user@mail.com";
	private static final String PASSWORD = "Pa55w@rd";
	private static final String ENCODED_PASSWORD = "AbraKadabra64654164";
	private static final String BAD_EMAIL = "i";
	private static final String BAD_PASSWORD = "pass";
	private static final String INCORRECT_PASSWORD = "Pa555w@rd";
	private static final String ENCODED_INCORRECT_PASSWORD = "AbraKadabraShwabra64654164";
	public static final String SALT = "salt";

	private static final User USER = User.builder()
			.withId(144)
			.withEmail(EMAIL)
			.withPassword(ENCODED_PASSWORD)
			.withSalt(SALT)
			.withFirstName("Petro")
			.withLastName("Opudalo")
			.withRole(User.Role.STUDENT)
			.build();

	@Mock
	private UserDaoImpl userDao;

	@Mock
	private UserValidator userValidator;

	@Mock
	private PasswordEncryptor passwordEncryptor;

	@InjectMocks
	private UserServiceImpl userService;

	@After
	public void resetMocks() {
		reset(userDao, passwordEncryptor, userValidator);
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void registrationSuccess() {
		doNothing().when(userValidator).validate(any(User.class));
		when(userDao.findByEmail(anyString())).thenReturn(Optional.empty());
		doNothing().when(userDao).save(any(User.class));

		final User actual = userService.register(USER);
		assertEquals(USER, actual);

		verify(userValidator).validate(any(User.class));
		verify(userDao).findByEmail(anyString());
		verify(userDao).save(any(User.class));
	}

	@Test
	public void registrationFailsBadEmail() {
		expectedEx.expect(ValidationException.class);
		final User user = User.builder()
				.withEmail(BAD_EMAIL)
				.withPassword(PASSWORD)
				.build();
		doCallRealMethod().when(userValidator).validate(user);
//		doThrow(ValidateException.class).when(userValidator).validate(any(User.class));
		userService.register(user);
	}

	@Test
	public void registrationFailsBadPassword() {
		expectedEx.expect(ValidationException.class);
		final User user = User.builder()
				.withEmail(EMAIL)
				.withPassword(BAD_PASSWORD)
				.build();
		doCallRealMethod().when(userValidator).validate(user);
		userService.register(user);
	}

	@Test
	public void registrationFailsUserExists() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("User with this email was registered already");
		when(userDao.findByEmail(anyString())).thenReturn(Optional.of(USER));
		userService.register(USER);
	}

	@Test
	public void logInSucceeds() {
		when(passwordEncryptor.encrypt(eq(PASSWORD), eq(SALT))).thenReturn(ENCODED_PASSWORD);
		when(userDao.findByEmail(anyString())).thenReturn(Optional.of(USER));

		final Optional<User> user = userService.login(EMAIL, PASSWORD);
		assertTrue(user.isPresent());

		verify(passwordEncryptor).encrypt(eq(PASSWORD), eq(SALT));
		verify(userDao).findByEmail(eq(EMAIL));
	}

	@Test
	public void logInFailsUserWithThisEmailNotFound() {
		when(passwordEncryptor.encrypt(eq(PASSWORD), eq(SALT))).thenReturn(ENCODED_PASSWORD);
		when(userDao.findByEmail(anyString())).thenReturn(Optional.empty());

		final Optional<User> user = userService.login(EMAIL, PASSWORD);
		assertFalse(user.isPresent());

		verify(userDao).findByEmail(eq(EMAIL));
	}

	@Test
	public void logInFailsPasswordIncorrect() {
		when(passwordEncryptor.encrypt(eq(INCORRECT_PASSWORD), eq(SALT))).thenReturn(ENCODED_INCORRECT_PASSWORD);
		when(userDao.findByEmail(anyString())).thenReturn(Optional.of(USER));

		final Optional<User> user = userService.login(EMAIL, INCORRECT_PASSWORD);
		assertFalse(user.isPresent());

		verify(passwordEncryptor).encrypt(eq(INCORRECT_PASSWORD), eq(SALT));
		verify(userDao).findByEmail(eq(EMAIL));
	}
}
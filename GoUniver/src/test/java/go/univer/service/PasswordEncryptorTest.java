package go.univer.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordEncryptorTest {

	private final PasswordEncryptor encryptor = new PasswordEncryptor();
	private final String password = "Pa55w@rd";

	@Test
	public void encryptionGivesSameResultWithSameInputGeneratedSalt() {
		final String salt = encryptor.generateStringSalt();
		final String encodedPass1 = encryptor.encrypt(password, salt);
		final String encodedPass2 = encryptor.encrypt(password, salt);
		assertEquals(encodedPass1, encodedPass2);
	}

	@Test
	public void encryptionGivesSameResultWithSameInputHardcodedSalt() {
		final String salt = "salt";
		final String encodedPass1 = encryptor.encrypt(password, salt);
		final String encodedPass2 = encryptor.encrypt(password, salt);
		assertEquals(encodedPass1, encodedPass2);
	}

	@Test
	public void encryptionGivesDifferentResultWithDifferentSalt() {
		final String salt1 = encryptor.generateStringSalt();
		final String salt2 = encryptor.generateStringSalt();
		final String encodedPass1 = encryptor.encrypt(password, salt1);
		final String encodedPass2 = encryptor.encrypt(password, salt2);
		assertNotEquals(encodedPass1, encodedPass2);
	}

	@Test
	public void encryptionGivesDifferentResultWithDifferentPassword() {
		final String salt = encryptor.generateStringSalt();
		final String password2 = password + "z";
		final String encodedPass1 = encryptor.encrypt(password, salt);
		final String encodedPass2 = encryptor.encrypt(password2, salt);
		assertNotEquals(encodedPass1, encodedPass2);
	}


}
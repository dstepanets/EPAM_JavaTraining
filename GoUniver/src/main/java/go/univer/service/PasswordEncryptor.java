package go.univer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordEncryptor {
	private static final Logger LOGGER = LogManager.getLogger(PasswordEncryptor.class);

	private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
	private static final int ITERATION_COUNT = 50_000;
	private static final int KEY_LENGTH = 128;
	//	salt - a random sequence that is generated for each new hash.
	private static final SecureRandom RANDOM = new SecureRandom();


	public String generateStringSalt() {
		byte[] bytes = new byte[16];
		RANDOM.nextBytes(bytes);
		return new String(bytes);
	}

	public String encrypt(String password, String salt) {
		try {
			final KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENGTH);
			final SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
			final byte[] hash = factory.generateSecret(spec).getEncoded();
			final String encodedPass = Base64.getEncoder().encodeToString(hash);
//			return new String(hash);
			return encodedPass;
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			LOGGER.error(e.getStackTrace());
		}
		return password;
	}

}

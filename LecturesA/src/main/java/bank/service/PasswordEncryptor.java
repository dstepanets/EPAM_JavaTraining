package bank.service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PasswordEncryptor {

	private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
	private static final int ITERATION_COUNT = 50_000;
	private static final int KEY_LENGTH = 128;
//		salt - a random sequence that is generated for each new hash.
	private static final SecureRandom RANDOM = new SecureRandom();
	private static final byte[] SALT = new byte[16];
	static {
		RANDOM.nextBytes(SALT);
	}

	public String encrypt(String password) {
//		create a PBEKeySpec and a SecretKeyFactory which we'll instantiate
//		using the PBKDF2WithHmacSHA1 algorithm. The third parameter (65536) is
//		effectively the strength parameter. It indicates how many iterations
//		that this algorithm run for, increasing the time it takes to produce the hash.
		try {
			KeySpec spec = new PBEKeySpec(password.toCharArray(), SALT, ITERATION_COUNT, KEY_LENGTH);
			SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);

			byte[] hash = factory.generateSecret(spec).getEncoded();
			return new String(hash);
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password;
	}

}

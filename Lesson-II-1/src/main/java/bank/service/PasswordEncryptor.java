package bank.service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PasswordEncryptor {

	public String encrypt(String password) {
//		salt - a random sequence that is generated for each new hash.
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
//		create a PBEKeySpec and a SecretKeyFactory which we'll instantiate
//		using the PBKDF2WithHmacSHA1 algorithm. The third parameter (65536) is
//		effectively the strength parameter. It indicates how many iterations
//		that this algorithm run for, increasing the time it takes to produce the hash.
		try {
			KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

			byte[] hash = factory.generateSecret(spec).getEncoded();
			return new String(hash);
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password;
	}

}

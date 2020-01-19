package factorial;

import java.math.BigInteger;

public class Factorial {

	public static BigInteger calcBigFactorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

}

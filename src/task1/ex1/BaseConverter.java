package task1.ex1;

class BaseConverter {

	private static int calcArrLength(int n, int base) {
		int len = (n == 0) ? 1 : 0;
		while (n > 0) {
			n /= base;
			len++;
		}
		return len;
	}

	private static char[] itoaBase(int num, int base) {

		if (num < 0 || base < 2 || base > 16) {
			return null;
		}

		int len = calcArrLength(num, base);

		char[] res = new char[len];
		final char[] digits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

		int n = num;
		while (--len >= 0) {
			res[len] = digits[n % base];
			n /= base;
		}

		return res;
	}

	public static void main(String[] args) {

		int num = 1000;

		try {
			System.out.print("Bin: ");
			System.out.println(itoaBase(num, 2));
			System.out.print("Oct: ");
			System.out.println(itoaBase(num, 8));
			System.out.print("Dec: ");
			System.out.println(itoaBase(num, 10));
			System.out.print("Hex: ");
			System.out.println(itoaBase(num, 16));

			System.out.print("Hex 0: ");
			System.out.println(itoaBase(0, 16));
			System.out.print("base 13: ");
			System.out.println(itoaBase(num, 13));

			System.out.println("Base 0: " + itoaBase(num, 0));
			System.out.println("neg num: " + itoaBase(-num, 16));
		} catch (NullPointerException e) {
			System.err.println("Number must be positive integer. And base in range 2-16.");
		}

	}

}


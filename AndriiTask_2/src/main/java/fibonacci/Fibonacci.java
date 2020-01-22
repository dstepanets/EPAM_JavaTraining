package fibonacci;

public class Fibonacci {

	private Fibonacci() {}

	public static int findNthFibonacciIterative(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n can't be negative");
		}
		int a = -1;
		int b = 1;
		int fib = 0;
		for (int i = 0; i < n; i++) {
			fib = a + b;
			a = b;
			b = fib;
		}
		return fib;
	}

	public static int findNthFibonacciRecursive(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n can't be negative");
		}
		if (n <= 1) {
			return 0;
		} else if (n <= 3) {
			return 1;
		}
		return findNthFibonacciRecursive(n - 1) + findNthFibonacciRecursive(n - 2);
	}

}

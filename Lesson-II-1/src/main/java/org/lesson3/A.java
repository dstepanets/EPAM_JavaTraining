package org.lesson3;

public class A {
	public static void main(String[] args) {
		method(100);
	}

	private static void method(int n) {
		try {
			validator(n);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}
		System.out.println(n);
	}

	private static int validator(int n) throws Exception {
		if (n > 10) {
			throw new Exception();
		}
	return n;
	}
}

package org.lesson3;

public class B {

	public static void main(String[] args) {
		validate();
	}

	private static void validate() {
		try {
			throw new RuntimeException("try");
		} finally {
			throw new RuntimeException("finally");
		}
	}
}

package org.lesson3.example2;

@FunctionalInterface
public interface MyInterface {
	int A = 10;
	void method();
	default void method2() {}
	static int counter(int n) {
		return ++n;
	}
}

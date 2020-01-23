package org.lesson4;

import java.util.function.Function;

public class Func {
	public static void main(String[] args) {
		String name = "Alex";
		Function<String, String> function = x -> {
			System.out.println(x);
			return "Hello " + name;
		};
	}
}

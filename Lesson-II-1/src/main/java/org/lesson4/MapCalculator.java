package org.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class MapCalculator {
	private static final Map<Character, ToIntBiFunction<Integer, Integer>> OPERATION_MAP = new HashMap<>();
	static {
		OPERATION_MAP.put('+', Integer::sum);
		OPERATION_MAP.put('-', (a, b) -> a-b);
		OPERATION_MAP.put('*', (a, b) -> a*b);
		OPERATION_MAP.put('/', (a, b) -> a/b);
		OPERATION_MAP.put('%', (a, b) -> a%b);
	}

	public int calculate(int a, Character op, int b) {
		return OPERATION_MAP.get(op).applyAsInt(a, b);
	}

	public static void main(String[] args) {
		MapCalculator calculator = new MapCalculator();
		System.out.println(calculator.calculate(5, '+', 2));
		System.out.println(calculator.calculate(5, '*', 2));
	}


}

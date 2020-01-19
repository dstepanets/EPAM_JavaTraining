package task2.ex1.view;

import java.util.Scanner;

public class InputData {

	private static Scanner scanner = new Scanner(System.in);

	public static String input() {
		return scanner.next();			// up to whitespace
	}
}

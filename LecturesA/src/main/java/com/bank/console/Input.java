package com.bank.console;

import java.util.Scanner;

public class Input {

	private final static Scanner scan = new Scanner(System.in);

	public static String getLine(String msg) {
		String ln;
		System.out.print(msg);
		do {
			System.out.print(":> ");
			ln = scan.nextLine();
			ln = ln.trim();
		} while (ln.length() < 1);
		return ln;
	}

	public static int getInt(String msg) {
		System.out.print(msg + ":> ");
		while (!scan.hasNextInt()){
			System.out.print(":> ");
			scan.nextLine();
		}
		return scan.nextInt();
	}

}

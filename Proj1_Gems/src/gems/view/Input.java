package gems.view;

import java.util.Scanner;

// TODO loops on chars instead of nums and 0.1
public class Input {

	private static Scanner scan = new Scanner(System.in);

	private static  String getLine(String msg) {
		String ln;
		do {
			System.out.print(msg + ":> ");
			ln = scan.nextLine();
			ln = ln.trim();
		} while (ln == null || ln.length() < 1);
		return ln;
	}

	public static int getInt(String msg) {
		do {
			System.out.print(msg + ":> ");
		} while (!scan.hasNextInt());
		return scan.nextInt();
	}

	public static double getDouble(String msg) {
		do {
			System.out.print(msg + ":> ");
		} while (!scan.hasNextDouble());
		return scan.nextDouble();
	}


}

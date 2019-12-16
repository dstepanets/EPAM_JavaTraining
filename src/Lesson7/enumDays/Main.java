package enumDays;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("We have EPAM classes on:");
		for (DaysOfWeek day: DaysOfWeek.values()) {
			if (day.isEpamClass()) {
				System.out.println(day);
			}
		}

		System.out.println("----------------------------");
		System.out.print("Enter day of week -> ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Next day: " +
				DaysOfWeek.valueOf(scanner.next().toUpperCase()).nextDay());

	}
}

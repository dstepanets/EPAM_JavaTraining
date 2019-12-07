package task1.ex2;

import java.util.LinkedList;
import java.util.List;

class PerfectNumbers {

	private static List<Integer> getPerfectNumbersList(int max) {

		if (max < 1) {
			return null;
		}

		List<Integer> list = new LinkedList<>();

		for (int num = 1; num <= max; num++) {
			int sum = 0;
			for (int i = 1; i < num; i++) {
				if (num % i == 0) {
					sum += i;
				}
			}
			if (sum == num) {
				list.add(num);
			}
		}

		return list;
	}

	public static void main(String[]args) {
		System.out.println(getPerfectNumbersList(10_000));
		System.out.println(getPerfectNumbersList(-1));
	}

}



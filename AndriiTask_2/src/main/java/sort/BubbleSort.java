package sort;

/**
 * Implements the Bubble Sort algorithm for a generic array.
 */
public class BubbleSort implements Sorting {
	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		T temp;
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSorted = false;
				}
			}
		}
	}
}

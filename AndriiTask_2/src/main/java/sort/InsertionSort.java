package sort;
/**
 * Implements the Insertion Sort algorithm for a generic array.
 */
public class InsertionSort implements Sorting {
	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			T current = arr[i];
			int j = i - 1;
			while(j >= 0 && current.compareTo(arr[j]) < 0) {
				arr[j+1] = arr[j];
				j--;
			}
			// at this point we've exited, so j is either -1
			// or it's at the first element where current >= a[j]
			arr[j+1] = current;
		}
	}
}

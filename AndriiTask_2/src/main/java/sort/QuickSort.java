package sort;

/**
 * Implements the Quick Sort algorithm for a generic array.
 */
public class QuickSort implements Sorting {
	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}


	/**
	 * @param arr Array to sort.
	 * @param low Index of the beginning element in current span of the array.
	 * @param high Index of the ending element in current span of the array.
	 */
	private  <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
//			pivot is partitioning index, arr[pivot] is now at right place
// 			Recursively sort elements before partition and after partition
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	/**
	 * 	This method takes the last element as a <b>pivot</b>, places the pivot element at its correct
	 *  position in a sorted array, and places all the smaller elements (smaller than pivot) to the left of
	 *  the pivot and all greater elements - to the right of the pivot
	 *  @return Index of the <b>pivot</b> element.
	 */
	private <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
		T pivot = arr[high];
		int l = low;	// index of a smaller element
		for (int j = low; j < high; j++) {
			// If the current element is smaller than the pivot..
			if (arr[j].compareTo(pivot) < 0) {
				// ...swap arr[l] and arr[j]
				T temp = arr[l];
				arr[l] = arr[j];
				arr[j] = temp;
				l++;
			}
		}

		// swap arr[l] and arr[high] (or pivot)
		T temp = arr[l];
		arr[l] = arr[high];
		arr[high] = temp;

		return (l);
	}

}

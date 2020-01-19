package sort;

/**
 * Provides a generic method for sorting an array of objects
 * in ascending order.
 */
public interface Sorting {
	/**
	 * Sorting is done in place, no additional memory is allocated.
	 * @param arr Generic array
	 * @param <T> Objects of the array must implement the Comparable interface
	 */
	<T extends Comparable<T>> void sort(T[] arr);
}

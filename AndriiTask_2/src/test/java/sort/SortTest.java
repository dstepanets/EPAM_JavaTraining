package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortTest {

	private BubbleSort bubble = new BubbleSort();
	private QuickSort quick = new QuickSort();
	private InsertionSort insertion = new InsertionSort();

	private Integer[] intArr;
	private Integer[] intSorted;
	private Double[] doubleArr;
	private Double[] doubleSorted;
	private String[] strArr;
	private String[] strSorted;

	@Before
	public void setUp() {
		intArr = new Integer[] {100500, -5, 101, 42, 0, -22222, 1, -1, 777};
		intSorted = intArr.clone();
		Arrays.sort(intSorted);

		doubleArr = new Double[] {100500.0, -5.0, -5.21, 42.5, 0.0, -22222.2, 1.1, -1.0, 777.7};
		doubleSorted = doubleArr.clone();
		Arrays.sort(doubleSorted);

		strArr = new String[] {"zxc" ,"abc","Ooo", "ooo", "Big", "Test", "Cthulhu", "foo", "123", "-123"};
		strSorted = strArr.clone();
		Arrays.sort(strSorted);
	}

	@Test
	public void bubbleSortTest() {
		bubble.sort(intArr);
		assertArrayEquals(intSorted, intArr);
		bubble.sort(doubleArr);
		assertArrayEquals(doubleSorted, doubleArr);
		bubble.sort(strArr);
		assertArrayEquals(strSorted, strArr);
	}

	@Test
	public void quickSortTest() {
		quick.sort(intArr);
		assertArrayEquals(intSorted, intArr);
		quick.sort(doubleArr);
		assertArrayEquals(doubleSorted, doubleArr);
		quick.sort(strArr);
		assertArrayEquals(strSorted, strArr);
	}

	@Test
	public void insertionSortTest() {
		insertion.sort(intArr);
		assertArrayEquals(intSorted, intArr);
		insertion.sort(doubleArr);
		assertArrayEquals(doubleSorted, doubleArr);
		insertion.sort(strArr);
		assertArrayEquals(strSorted, strArr);
	}

}
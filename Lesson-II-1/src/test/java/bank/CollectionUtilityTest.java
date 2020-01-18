package bank;

import bank.utility.CollectionUtility;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectionUtilityTest {

	@Test
	public void nullSafeListInitShouldReturnEmptyListIfInputNull() {
		final List<Object> actual = CollectionUtility.nullSafeListInit(null);
		assertTrue(actual.isEmpty());
	}

	@Test
	public void nullSafeListInitShouldReturnListIfInputNotNull() {
		List<Integer> items = Arrays.asList(1, 2, 3);
		final List<Integer> actual = CollectionUtility.nullSafeListInit(items);
		assertFalse(actual.isEmpty());
	}

}

package com.bank.utility;

import java.util.List;

import static java.util.Collections.*;

public class CollectionUtility {

	private CollectionUtility() {}

	public static <T> List<T> nullSafeListInit(List<T> items) {
		return items == null ? emptyList() : unmodifiableList(items);
	}
}

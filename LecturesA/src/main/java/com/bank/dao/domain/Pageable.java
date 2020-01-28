package com.bank.dao.domain;

import java.util.List;

public class Pageable<T> {
	private final List<T> items;
	private final int pageNumber;
	private final int itemsPerPage;
	private final int maxPageNumber;

	public Pageable(List<T> items, int pageNumber, int itemsPerPage, int maxPageNumber) {
		this.items = items;
		this.pageNumber = pageNumber;
		this.itemsPerPage = itemsPerPage;
		this.maxPageNumber = maxPageNumber;
	}

	public List<T> getItems() {
		return items;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public int getMaxPageNumber() {
		return maxPageNumber;
	}
}

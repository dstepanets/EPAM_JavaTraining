package go.univer.repository;

import java.util.List;

public class PaginalList<T> {
	private final List<T> items;
	private final Page page;
	private final int maxPageNumber;

	public PaginalList(List<T> items, Page page, int maxPageNumber) {
		this.items = items;
		this.page = page;
		this.maxPageNumber = maxPageNumber;
	}

	public List<T> getItems() {
		return items;
	}

	public Page getPage() {
		return page;
	}

	public int getMaxPageNumber() {
		return maxPageNumber;
	}
}

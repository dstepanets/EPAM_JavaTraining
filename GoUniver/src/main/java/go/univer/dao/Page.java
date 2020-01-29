package go.univer.dao;

public class Page {
	private int page;
	private int itemsPerPage;

	public Page(int page, int itemsPerPage) {
		this.page = page;
		this.itemsPerPage = itemsPerPage;
	}

	public int getPage() {
		return page;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}
}


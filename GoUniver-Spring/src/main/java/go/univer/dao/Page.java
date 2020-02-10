package go.univer.dao;

public class Page {
	private int pageNum;
	private int itemsPerPage;

	public Page(int pageNum, int itemsPerPage) {
		this.pageNum = pageNum;
		this.itemsPerPage = itemsPerPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}
}


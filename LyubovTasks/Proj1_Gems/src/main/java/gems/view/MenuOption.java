package gems.view;

public enum MenuOption {
	ADD("Add a gem to the necklace"),
	REMOVE("Remove a gem from a necklace"),
	RESET("Start new necklace"),
	SHOW("Show details about gems in the necklace"),
	SORT("Sort gems in the necklace by price"),
	GET("Select gems by clarity in range"),
	EXIT("Exit the program");

	MenuOption(String description) {
		this.description = description;
	}

	private String description;

	public String getDescription() {
		return description;
	}
}

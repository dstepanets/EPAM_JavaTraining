package gems.model;

public enum Color {
	RED("red"),
	BLUE("blue"),
	GREEN("green"),
	CLEAR("clear");

	private String colorName;

	Color(String description) {
		this.colorName = description;
	}

	public String getColorName() {
		return colorName;
	}
}

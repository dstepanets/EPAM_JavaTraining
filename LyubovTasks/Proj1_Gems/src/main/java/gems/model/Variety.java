package gems.model;

public enum Variety {
	DIAMOND("Diamond", Color.CLEAR, 1000),
	EMERALD("Emerald", Color.GREEN, 250),
	RUBY("Ruby", Color.RED, 400),
	SAPPHIRE("Sapphire", Color.BLUE, 100);

	private String name;
	private Color color;
	private int basePrice;

	Variety(String name, Color color, int basePrice) {
		this.name = name;
		this.color = color;
		this.basePrice = basePrice;
	}

	public static Variety valueOf(int index) {
		return Variety.values()[index];
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public int getBasePrice() {
		return basePrice;
	}
}

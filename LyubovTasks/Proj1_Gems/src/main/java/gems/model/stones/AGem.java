package gems.model.stones;

import gems.model.Color;
import gems.model.Variety;

public abstract class AGem {

	private Variety variety;
	private Color color;
	private double weight;	// carat
	private int clarity;	// 1-100%
	private int price;


	@Override
	public String toString() {
		return variety.getName() +
				" {color=" + color.getColorName() +
				", weight=" + weight +
				", clarity=" + clarity +
				", price=" + price +
				'}';
	}

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getClarity() {
		return clarity;
	}

	public void setClarity(int clarity) {
		this.clarity = clarity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

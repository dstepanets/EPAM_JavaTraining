package gems.model;

import gems.model.stones.*;


/*
*	Builder creates a Gem of a corresponding class and assigns to
*	fields values received from Menu class. It then calculates gem price
* 	from those parameters.
*/

public class GemBuilder {

	private AGem gem;

	private Variety variety;
	private double weight;	// carat
	private int clarity;	// 1-100%

	public void setVariety(Variety v) {
		this.variety = v;
	}

	public void setWeight(double weight) {
		if (weight <= 0.0) {
			throw new IllegalArgumentException();
		}
		this.weight = weight;
	}

	public void setClarity(int clarity) {
		if (clarity < 1 || clarity > 100) {
			throw new IllegalArgumentException();
		}
		this.clarity = clarity;
	}

	public AGem getGem() {
		produceGem();
		return gem;
	}

	private void produceGem() {
		switch (variety) {
			case RUBY:
				gem = new Ruby();
				break;
			case DIAMOND:
				gem = new Diamond();
				break;
			case EMERALD:
				gem = new Emerald();
				break;
			case SAPPHIRE:
				gem = new Sapphire();
				break;
		}
		gem.setVariety(variety);
		gem.setColor(variety.getColor());
		gem.setWeight(this.weight);
		gem.setClarity(this.clarity);
		gem.setPrice(calcPrice());
	}

	private int calcPrice() {
		double multiplier = ((double)clarity / 4) * weight;
		int price = (int) (variety.getBasePrice() * multiplier);
		return price;
	}
}

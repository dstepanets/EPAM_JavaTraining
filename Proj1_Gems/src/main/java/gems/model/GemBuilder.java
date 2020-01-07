package gems.model;

import gems.model.stones.*;

public class GemBuilder {

	private AGem gem;

	private Variety variety;
	private double weight;	// carat
	private int clarity;	// 1-100%
	private int price;

	public void setVariety(Variety v) {
		this.variety = v;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setClarity(int clarity) {
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
		price = (int) (variety.getBasePrice() * multiplier);
		return price;
	}
}

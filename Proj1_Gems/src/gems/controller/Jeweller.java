package gems.controller;

import gems.model.GemBuilder;
import gems.model.stones.AGem;
import gems.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class Jeweller {

	private Menu menu = new Menu();
	private GemBuilder builder = new GemBuilder();
	private List<AGem> neclace = new ArrayList<>();

	public void shop() {
		menu.welcome();
	}

	public void addGem() {
		builder.setVariety(menu.chooseGem());
		builder.setWeight(menu.chooseWeight());
		builder.setClarity(menu.chooseClarity());
		neclace.add(builder.getGem());
		menu.showNecklace(neclace, calcWeight(), calcPrice());
	}

	private double calcWeight() {
		double weight = 0.0;
		for (AGem gem : neclace) {
			weight += gem.getWeight();
		}
		return weight;
	}

	private int calcPrice() {
		int price = 0;
		for (AGem gem : neclace) {
			price += gem.getPrice();
		}
		return price;
	}

}

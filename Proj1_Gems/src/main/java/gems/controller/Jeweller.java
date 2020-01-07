package gems.controller;

import gems.model.GemBuilder;
import gems.model.stones.AGem;
import gems.view.Menu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Jeweller {

	private Menu menu = new Menu(this);
	private GemBuilder builder = new GemBuilder();
	private List<AGem> neclace = new ArrayList<>();

	public void shop() {
		menu.welcome();
		while (true) {
			if (neclace.size() > 0) {
				menu.showNecklace(neclace, calcWeight(), calcPrice());
			}
			menu.menu();
		}
	}

	public void addGem() {
		builder.setVariety(menu.chooseGem());
		builder.setWeight(menu.chooseWeight());
		builder.setClarity(menu.chooseClarity());
		neclace.add(builder.getGem());
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

	public void removeGem(int num) {
		neclace.remove(num - 1);
	}

	public void resetNecklace() {
		neclace = new ArrayList<>();
	}

	public void sortNecklace() {
		neclace.sort(new Comparator<AGem>() {
			@Override
			public int compare(AGem o1, AGem o2) {
				return o1.getPrice() - o2.getPrice();
			}
		});
	}

	public List<AGem> getGemsByClarity(int min, int max) {
		List<AGem> selection = new ArrayList<>();
		for (AGem g : neclace) {
			if (g.getClarity() >= min && g.getClarity() <= max) {
				selection.add(g);
			}
		}
		return selection;
	}

	public List<AGem> getNeclace() {
		return neclace;
	}
}

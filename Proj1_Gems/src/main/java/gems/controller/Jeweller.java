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
//		print main menu until EXIT command typed
		while (true) {
			if (neclace.size() > 0) {
				menu.showNecklace(neclace, calcWeight(), calcPrice());
			}
			menu.menu();
		}
	}

//	build a gem from user input
	public void addGem() {
		builder.setVariety(menu.chooseGem());
		builder.setWeight(menu.chooseWeight());
		builder.setClarity(menu.chooseClarity());
		neclace.add(builder.getGem());
	}

	public double calcWeight() {
		double weight = 0.0;
		for (AGem gem : neclace) {
			weight += gem.getWeight();
		}
		return weight;
	}

	public int calcPrice() {
		int price = 0;
		for (AGem gem : neclace) {
			price += gem.getPrice();
		}
		return price;
	}

//	num is a natural order (starts from 1)
	public void removeGem(int num) {
		neclace.remove(num - 1);
	}

	public void resetNecklace() {
		neclace = new ArrayList<>();
	}

//	sorts gems by price, ascending
	public void sortNecklace() {
		neclace.sort(new Comparator<AGem>() {
			@Override
			public int compare(AGem o1, AGem o2) {
				return o1.getPrice() - o2.getPrice();
			}
		});
	}

//	returns new list of gems with clarity in range (or empty list if none found)
	public List<AGem> getGemsByClarity(int min, int max) {
		List<AGem> selection = new ArrayList<>();
		for (AGem g : neclace) {
			if (g.getClarity() >= min && g.getClarity() <= max) {
				selection.add(g);
			}
		}
		return selection;
	}


	/*	-	-	-	-	GETTERS / SETTERS	-	-	-	-	-	-	-	*/

	public List<AGem> getNeclace() {
		return neclace;
	}

	public void setNeclace(List<AGem> neclace) {
		this.neclace = neclace;
	}

	public GemBuilder getBuilder() {
		return builder;
	}
}

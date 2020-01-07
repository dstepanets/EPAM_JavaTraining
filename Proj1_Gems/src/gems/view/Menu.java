package gems.view;

import gems.model.Variety;
import gems.model.stones.AGem;

import java.util.List;

public class Menu {

	public void welcome() {
		System.out.println("Welcome to the best jewelry shop in... in here!");
		System.out.println("Master Silvio Contrabando is at your service.");
	}

	public Variety chooseGem() {
		System.out.println("Choose a beautiful gem for your necklace.");
		Variety[] varieties = Variety.values();
		int i = 0;
		for (Variety v : varieties) {
			System.out.println(++i + " - " + v.getName());
		}

		int n;
		do {
			n = Input.getInt("[Enter the number]\n");
		} while (n < 1 || n > varieties.length);

		return varieties[n - 1];
	}

	public double chooseWeight() {
		System.out.println("What size of this gem do you prefer?");
		double size;
		do {
			size = Input.getDouble("We have all sizes from 0.1 ct to 100 ct!\n");
		} while (size < 0.1 || size > 100.0);
		return size;
	}

	public int chooseClarity() {
		System.out.println("Choose the percent of clarity for this gem.");
		int clarity;
		do {
			clarity = Input.getInt("[from 1 to 100%]\n");
		} while (clarity < 1 || clarity > 100);
		return clarity;
	}

	public void showNecklace(List<AGem> neclace, double weight, int price) {
		System.out.println("Such a wonderful necklace you made!");
		System.out.print("{");
		int i = 0;
		for (; i < neclace.size() - 1; i++) {
			System.out.print(neclace.get(i).getVariety().getName() + "-");
		}
		System.out.println(neclace.get(i).getVariety().getName()  + "}");
		System.out.println("Total gems weight: " + weight);
		System.out.println("Only today for the SUPER-SALE price: " + price + ".99!");
	}



}

package gems.view;

import gems.controller.Jeweller;
import gems.model.Variety;
import gems.model.stones.AGem;

import java.util.List;

public class Menu {

	private Jeweller jeweller;
	private final String SEPARATOR = "----------------------------------------------------";

	public Menu(Jeweller jeweller) {
		this.jeweller = jeweller;
	}

	public void welcome() {
		System.out.println("Welcome to the best jewelry shop in... in here!");
		System.out.println("Master Silvio Contrabando is at your service.");
	}

	public void menu() {
		boolean validCommand;
		do {
			validCommand = true;
			for (MenuOption o : MenuOption.values()) {
				System.out.println("\t" + o.toString() + " - " + o.getDescription());
			}
			String input = Input.getLine("[Type a command]\n");
			try {
				MenuOption o = MenuOption.valueOf(input.toUpperCase());
				switch (o) {
					case ADD:
						jeweller.addGem();
						break;
					case REMOVE:
						removeGem();
						break;
					case RESET:
						jeweller.resetNecklace();
						break;
					case SHOW:
						showGems(jeweller.getNeclace());
						break;
					case SORT:
						jeweller.sortNecklace();
						break;
					case GET:
						selectGemsByClarity();
						break;
					case EXIT:
						goodbye();
						break;
					default:
						validCommand = false;
				}
			} catch (IllegalArgumentException e) {
				validCommand = false;
				System.out.println("Wrong command :(");
			}
		} while (!validCommand);
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
			n = Input.getInt("[Enter the number in range]\n");
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
		System.out.println(SEPARATOR);
		System.out.println("Such a wonderful necklace you made!");
		int i = 0;
		for (; i < neclace.size() - 1; i++) {
			System.out.print("{" + (i + 1) + "|" + neclace.get(i).getVariety().getName() + "}-");
		}
		System.out.println("{" + (i + 1) + "|" + neclace.get(i).getVariety().getName()  + "}");
		System.out.println("Total gems weight: " + weight);
		System.out.println("Only today for the SUPER-SALE price: $" + price + ".99!");
		System.out.println(SEPARATOR);
	}

	public void removeGem() {
		int len = jeweller.getNeclace().size();
		if (len < 1) {
			System.out.println("Your necklace is so empty!");
			return;
		}

		System.out.println("Which gem do you want to remove?");
		int num;
		do {
			num = Input.getInt("[Enter a corresponding number]\n");
		} while (num < 1 || num > len);
		jeweller.removeGem(num);
	}

	public void showGems(List<AGem> neclace) {
		if (neclace.size() < 1) {
			System.out.println("Nothing to display!");
			return;
		}

		System.out.println(SEPARATOR);
		for (AGem gem : neclace) {
			System.out.println(gem);
		}
	}

	private void selectGemsByClarity() {
		int len = jeweller.getNeclace().size();
		if (len < 1) {
			System.out.println("Your necklace is so empty!");
			return;
		}
//		get range from input
		System.out.println("Enter range of clarity (1 - 100%)");
		int min = 1, max = 100;
		do {
			min = Input.getInt("[Enter min]\n");
			max = Input.getInt("[Enter max (can't be lower than min)]\n");
		} while (min < 1 || max < 1 || max > 100 || min > max);
		System.out.println("min = " + min + "; max = " + max);
//		print selected gems
		showGems(jeweller.getGemsByClarity(min, max));
	}

	public void goodbye() {
		System.out.println("Pleasure to do business with you. Take care!");
		System.exit(0);
	}


}

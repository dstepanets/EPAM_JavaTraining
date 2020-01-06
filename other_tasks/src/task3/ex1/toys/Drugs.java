package task3.ex1.toys;

import task3.ex1.Main;

public class Drugs extends Toy {

	private String[] names = {
			"Cocaine",
			"Heroine",
			"Marijuana",
			"Ecstasy",
			"Methamphetamine",
			"Vodka",
			"Salo"
	};

	public Drugs() {
		this.name = names[Main.rand.nextInt(names.length)];
		this.price = Main.rand.nextDouble() * 100.0 + 20.0;
		this.minAge = Main.rand.nextInt(12) + 10;
	}
}

package task3.ex1.toys;

import task3.ex1.Main;

public class Weapon extends Toy {

	private String[] names = {
			"AK47",
			"Lightsaber",
			"Hand Grenade",
			"Desert Eagle",
			"Nuclear Bomb",
			"Aircraft Carrier",
			"Tank",
			"Shawarma"
	};

	public Weapon() {
		this.name = names[Main.rand.nextInt(names.length)];
		this.price = Main.rand.nextDouble() * 20.0 + 10.0;
		this.minAge = Main.rand.nextInt(8) + 4;
	}
}

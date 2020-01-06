package task3.ex1.toys;

import task3.ex1.Main;

public class Doll extends Toy {

	private String[] names = {
			"VoodooDoll",
			"Sex-Barbie",
			"Brachiosaurus",
			"Lyalka-Motanka",
			"Matryoshka",
			"Teddy Bear",
	};

	public Doll() {
		this.name = names[Main.rand.nextInt(names.length)];
		this.price = Main.rand.nextDouble() * 30.0 + 3.0;
		this.minAge = Main.rand.nextInt(8) + 1;
	}
}

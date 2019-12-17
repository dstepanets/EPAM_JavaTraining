package task3.ex1.toys;

import task3.ex1.Main;

public class ColoringBook extends Toy {

	private String[] names = {
			"Red-Black Binary Trees for Toddles",
			"Killer Butterflies",
			"Winnie-the-Pooh and LGBT",
			"Harry Potter and Java Virtual Machine",
			"Penetrator III",
			"Canned Mermaids in Their Own Juice"
	};

	public ColoringBook() {
		this.name = names[Main.rand.nextInt(names.length)];
		this.price = Main.rand.nextDouble() * 10.0 + 1.0;
		this.minAge = Main.rand.nextInt(6) + 2;
	}
}

package task2.ex1.controller;

import task2.ex1.model.Circle;
import task2.ex1.model.Rectangle;
import task2.ex1.model.Shape;
import task2.ex1.model.Triangle;

import java.util.Random;

public class ShapeProcessor {

	private Shape[] array;

	public Shape[] getArray() {
		return array;
	}

	void generateShapesArray(int numElements) {
		array = new Shape[numElements];
		Random rand = new Random();
		String[] colors = {"RED", "GREEN", "BLUE", "YELLOW", "BLACK", "WHITE"};

		for (int i = 0; i < numElements; i++) {
			int type = rand.nextInt(3);
			Shape s = null;
			switch (type) {
				case 0:
					do {
						s = new Rectangle(colors[rand.nextInt(colors.length)],
								rand.nextInt(100),
								rand.nextInt(100));
					} while (!s.validateShape());

					break;
				case 1:
					do {
						s = new Triangle(colors[rand.nextInt(colors.length)],
											rand.nextInt(100),
											rand.nextInt(100),
											rand.nextInt(100));
					} while (!s.validateShape());
					break;
				case 2:
					do {
						s = new Circle(colors[rand.nextInt(colors.length)],
											rand.nextInt(100));
					} while (!s.validateShape());
					break;
			}
			array[i] =  s;
		}
	}

	public double calcTotalArea() {
		double area = 0.0;
		for (Shape s : array) {
			area += s.calcArea();
		}
		return area;
	}

	public double calcTotalAreaSpecific(Class c) {
		double area = 0.0;
		for (Shape s : array) {
			if (s.getClass() == c) {
				area += s.calcArea();
			}
		}
		return area;
	}

}

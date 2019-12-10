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
					double w, h;
					do {
						w = rand.nextInt(100);
						h = rand.nextInt(100);
					} while (!Rectangle.validateShape(w, h));
					s = new Rectangle(colors[rand.nextInt(colors.length)], w, h);
					break;
				case 1:
					double a, b, c;
					do {
						a = rand.nextInt(100);
						b = rand.nextInt(100);
						c = rand.nextInt(100);
					} while (!Triangle.validateShape(a, b, c));
					s = new Triangle(colors[rand.nextInt(colors.length)], a, b, c);
					break;
				case 2:
					double radius;
					do {
						radius = rand.nextInt(100);
					} while (!Circle.validateShape(radius));
					s = new Circle(colors[rand.nextInt(colors.length)], radius);
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

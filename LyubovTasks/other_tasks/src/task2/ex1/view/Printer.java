package task2.ex1.view;

import task2.ex1.controller.ShapeProcessor;
import task2.ex1.model.entity.Shape;

public class Printer {

	public void printShape(Shape shape) {
		System.out.println(shape.draw());
	}

	public void printShapesArray(Shape[] array) {
		for (Shape s : array) {
			printShape(s);
		}
	}

	public void printTotalArea(ShapeProcessor processor) {
		String areaTrimmed = String.format("%.2f", processor.calcTotalArea());
		System.out.println("Total area of " + processor.getArray().length +
				" " + "shapes: " + areaTrimmed);
	}

	public void printTotalAreaSpecific(ShapeProcessor processor, Class shapeType) {
		String areaTrimmed = String.format("%.2f", processor.calcTotalAreaSpecific(shapeType));
		System.out.println("Total area of " + shapeType.getSimpleName() + "s: " + areaTrimmed);
	}

	public void printString(String s) {
		System.out.println(s);
	}

}

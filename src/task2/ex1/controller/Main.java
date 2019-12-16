package task2.ex1.controller;

import task2.ex1.model.entity.Shape;
import task2.ex1.view.InputData;
import task2.ex1.view.Printer;

import java.util.Comparator;
public class Main {

	public static void main(String[] args) {

		ShapeProcessor processor = new ShapeProcessor();
		Printer printer = new Printer();

//		generateShapes(processor, printer);
//		totalArea(processor, printer);
//		sortShapes(processor, printer);
		chooseShapeFromInput();

	}

	private static void generateShapes(ShapeProcessor processor, Printer printer) {
		processor.generateShapesArray(10);
		printer.printShapesArray(processor.getArray());

		printer.printString("\tTotal Area:");
		printer.printTotalArea(processor);
	}

	private static void totalArea(ShapeProcessor processor, Printer printer) {
		printer.printString("-----------------------------------------");
		printer.printString("Enter a shape type (rectangle / triangle / circle) :> ");
		String type = InputData.input();
		printer.printTotalAreaSpecific(processor, processor.getClassFromString(type));
	}

	private static void sortShapes(ShapeProcessor processor, Printer printer) {
		printer.printString("-----------------------------------------");
		printer.printString("Enter a sorting criteria (area / color) :> ");
		String criteria = InputData.input();
		Comparator comparator = null;
		switch (criteria.toLowerCase()) {
			case "area":
				comparator = new Comparator<Shape>() {
					@Override
					public int compare(Shape s1, Shape s2) {
						return (int) (s1.calcArea() - s2.calcArea());
					}
				};
				break;
			case "color":
				comparator = new Comparator<Shape>() {
					@Override
					public int compare(Shape s1, Shape s2) {
						return s1.getShapeColor().compareTo(s2.getShapeColor());
					}
				};
				break;
		}
		if (comparator != null) {
			printer.printString("\tSort by " + criteria + ":");
			Shape[] sorted = processor.sortShapes(comparator);
			printer.printShapesArray(sorted);
		} else {
			printer.printString("Invalid criteria!");
		}
	}

	private static void chooseShapeFromInput() {

	}

}

package task2.ex1.controller;

import task2.ex1.model.*;
import task2.ex1.model.entity.Shape;
import task2.ex1.view.InputData;
import task2.ex1.view.Printer;

import java.util.Comparator;
public class Main {

	public static void main(String[] args) {

		ShapeProcessor processor = new ShapeProcessor();
		Printer printer = new Printer();

		processor.generateShapesArray(10);
		printer.printShapesArray(processor.getArray());

		printer.printString("\tTotal Area:");
		printer.printTotalArea(processor);

		printer.printString("-----------------------------------------");
		printer.printString("Enter a shape type (rectangle / triangle / circle) :> ");
		String type = InputData.input();
		printer.printTotalAreaSpecific(processor, processor.getClassFromString(type));

		printer.printString("-----------------------------------------");
		printer.printString("Enter a sorting criteria (area / color) :> ");
		String criteria = InputData.input();
		Comparator comparator = null;
		switch (criteria.toLowerCase()) {
			case "area":
				comparator = new ShapeAreaComparator();
				break;
			case "color":
				comparator = new ShapeColorComparator();
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

}

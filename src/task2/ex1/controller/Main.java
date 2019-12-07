package task2.ex1.controller;

import task2.ex1.model.*;
import task2.ex1.view.Printer;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		ShapeProcessor processor = new ShapeProcessor();
		Printer printer = new Printer();

		processor.generateShapesArray(10);
		printer.printShapesArray(processor.getArray());

		System.out.println("\tTotal Area:");
		printer.printTotalArea(processor);
		printer.printTotalAreaSpecific(processor, Rectangle.class);
		printer.printTotalAreaSpecific(processor, Triangle.class);
		printer.printTotalAreaSpecific(processor, Circle.class);

		System.out.println("\tSort By Area:");
		Arrays.sort(processor.getArray(), new ShapeAreaComparator());
		printer.printShapesArray(processor.getArray());
		System.out.println("\tSort By Color:");
		Arrays.sort(processor.getArray(), new ShapeColorComparator());
		printer.printShapesArray(processor.getArray());

	}
}

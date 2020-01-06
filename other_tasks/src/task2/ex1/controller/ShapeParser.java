package task2.ex1.controller;

import task2.ex1.model.entity.*;

public class ShapeParser {
	public static Shape parse(String shape) {
		String type = shape.substring(0, shape.indexOf(":")).toUpperCase();
		switch (ShapeType.valueOf(type)) {
			case RECTANGLE:
				return Rectangle.parseShape(shape);
			case TRIANGLE:
				return Triangle.parseShape(shape);
			case CIRCLE:
				return Circle.parseShape(shape);
			default:
				return null;
		}
	}
}

package task2.ex1.model;

import task2.ex1.model.entity.Shape;

import java.util.Comparator;

public class ShapeColorComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Shape s1 = (Shape) o1;
		Shape s2 = (Shape) o2;
		return s1.getShapeColor().compareTo(s2.getShapeColor());
	}
}

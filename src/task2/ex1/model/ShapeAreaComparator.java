package task2.ex1.model;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Shape s1 = (Shape) o1;
		Shape s2 = (Shape) o2;
		Double a = s1.calcArea();
		return a.compareTo(s2.calcArea());
	}
}

package task2.ex1.model.entity;

public class Circle extends Shape {

	private double radius;

	public Circle(String shapeColor, double radius) throws IllegalArgumentException {
		super(shapeColor);
		this.radius = radius;
	}

	public static boolean validateShape(double radius) {
		if (radius <= 0.0)
			return false;
		return true;
	}

	@Override
	public double calcArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return super.toString() + ", radius=" + radius;
	}

}

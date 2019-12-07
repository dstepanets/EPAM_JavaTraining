package task2.ex1.model;

public class Circle extends Shape {

	private double radius;

	public Circle(String shapeColor, double radius) throws IllegalArgumentException {
		super(shapeColor);
		this.radius = radius;
	}

	@Override
	public boolean validateShape() {
		if (!super.validateShape())
			return false;
		if (radius <= 0.0)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", radius=" + radius;
	}

	@Override
	public double calcArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String draw() {
		return String.format("%s; area=%.2f", this, this.calcArea());
	}

}

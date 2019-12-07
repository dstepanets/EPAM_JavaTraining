package task2.ex1.model;

public class Rectangle extends Shape {
	private double w;
	private double h;

	public Rectangle(String shapeColor, double w, double h) throws IllegalArgumentException {
		super(shapeColor);
		this.w = w;
		this.h = h;
	}

	@Override
	public boolean validateShape() {
		if (!super.validateShape())
			return false;
		if (w <= 0.0 || h <= 0.0)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", w=" + w + ", h=" + h;
	}

	@Override
	public double calcArea() {
		return w * h;
	}

	@Override
	public String draw() {
		return String.format("%s; area=%.2f", this, this.calcArea());
	}
}

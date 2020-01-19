package task2.ex1.model.entity;

public class Rectangle extends Shape {
	private double w;
	private double h;

	public Rectangle(String shapeColor, double w, double h) throws IllegalArgumentException {
		super(shapeColor);
		this.w = w;
		this.h = h;
	}

	public static boolean validateShape(double w, double h) {
		if (w <= 0.0 || h <= 0.0)
			return false;
		return true;
	}

	@Override
	public double calcArea() {
		return w * h;
	}

	@Override
	public String toString() {
		return super.toString() + ", w=" + w + ", h=" + h;
	}

	public static Rectangle parseShape(String data) {
		String[] tokens = data.split("[:,]");
		return new Rectangle(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
	}

}

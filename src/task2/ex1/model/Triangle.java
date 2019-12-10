package task2.ex1.model;

public class Triangle extends Shape {
	private double a;
	private double b;
	private double c;

	public Triangle(String shapeColor, double a, double b, double c) throws IllegalArgumentException {
		super(shapeColor);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public static boolean validateShape(double a, double b, double c) {
		if ( (a+b)<c || (b+c)<a || (c+a)<b )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", a=" + a + ", b=" + b + ", c=" + c;
	}

//	Heron's formula gives the area of a triangle when the length of all three sides are known
	@Override
	public double calcArea() {
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return area;
	}

	@Override
	public String draw() {
		return String.format("%s; area=%.2f", this, this.calcArea());
	}

}

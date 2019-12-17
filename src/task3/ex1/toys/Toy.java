package task3.ex1.toys;

import java.util.Comparator;

public abstract class Toy {
	protected String name;
	protected double price;
	protected int minAge;

	public String getName() { return name;	}
	public double getPrice() { return price; }
	public int getMinAge() { return minAge; }

	@Override
	public String toString() {
		return 	this.getClass().getSimpleName() + "{" +
				"name='" + name + '\'' +
				", price=" + String.format("%.2f", price) +
				", minAge=" + minAge + "}";
	}


	public static class ToyNameComparator<T extends Toy> implements Comparator<T> {
		@Override
		public int compare(T o1, T o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

	public static class ToyPriceComparator<T extends Toy> implements Comparator<T> {
		@Override
		public int compare(T o1, T o2) {
			return Double.compare(o1.getPrice(), o2.getPrice());
		}
	}

	public static class ToyAgeComparator<T extends Toy> implements Comparator<T> {
		@Override
		public int compare(T o1, T o2) {
			return Integer.compare(o1.getMinAge(), o2.getMinAge());
		}
	}
}

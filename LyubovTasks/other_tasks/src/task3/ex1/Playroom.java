package task3.ex1;

import task3.ex1.toys.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Playroom<T extends Toy> {

	private T[] toys;

	public Playroom(T[] toys) {
		this.toys = toys;
	}

	public void sortToys(Comparator<T> comparator) {
		Arrays.sort(toys, comparator);
	}

	public void printToys() {
		for (T t : toys) {
			System.out.println(t);
		}
	}

	public double calcTotalPrice() {
		double total = 0.0;
		for (T t: toys) {
			total += t.getPrice();
		}
		return total;
	}

	public <N extends Number> ArrayList<T> getToysInRange(N min, N max, boolean ageCriteria) {
//		ageCriteria=true -> search by age; ageCriteria=false -> by price
		ArrayList<T> toys2 = new ArrayList<>();
		for (T t : toys) {
			if (ageCriteria) {
				Integer age = t.getMinAge();
				if (age >= min.intValue() && age < max.intValue()) {
					toys2.add(t);
				}
			} else {
				Double price = t.getPrice();
				if (price >= min.intValue() && price < max.intValue()) {
					toys2.add(t);
				}
			}
		}
		return toys2;
	}

}

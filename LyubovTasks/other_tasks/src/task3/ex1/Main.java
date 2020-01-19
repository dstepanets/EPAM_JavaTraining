package task3.ex1;

import task3.ex1.toys.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static Random rand = new Random();

	public static void main(String[] args) {
		int num = 7;

		System.out.println("=============Coloring Books=================");
		ColoringBook[] coloringBooks = new ColoringBook[num];
		for (int i = 0; i < num; i++) {
			coloringBooks[i] = new ColoringBook();
		}
		Playroom<ColoringBook> bookRoom = new Playroom<>(coloringBooks);
		bookRoom.printToys();
		System.out.println("--------------sort by price----------------");
		bookRoom.sortToys(new Toy.ToyPriceComparator<>());
		bookRoom.printToys();

		System.out.println("==============Dolls================");
		Doll[] dolls = new Doll[num];
		for (int i = 0; i < num; i++) {
			dolls[i] = new Doll();
		}
		Playroom<Doll> dollRoom = new Playroom<>(dolls);
		dollRoom.printToys();
		System.out.println("-------------sort by name-----------------");
		dollRoom.sortToys(new Toy.ToyNameComparator<>());
		dollRoom.printToys();


		System.out.println("=============Weapons=================");
		Weapon[] weapons = new Weapon[num];
		for (int i = 0; i < num; i++) {
			weapons[i] = new Weapon();
		}
		Playroom<Weapon> warRoom = new Playroom<>(weapons);
		warRoom.printToys();
		System.out.println("-------------Total Price-----------------");
		System.out.printf("%.2f\n", warRoom.calcTotalPrice());


		System.out.println("================Drugs==============");
		Drugs[] drugs = new Drugs[num];
		for (int i = 0; i < num; i++) {
			drugs[i] = new Drugs();
		}
		Playroom<Drugs> drugRoom = new Playroom<>(drugs);
		drugRoom.printToys();
		System.out.println("-------------In range of age-----------------");
		ArrayList<Drugs> drugsByAge = drugRoom.getToysInRange(12, 19, true);
		for (Drugs d : drugsByAge) {
			System.out.println(d);
		}
		System.out.println("-------------In range of price-----------------");
		ArrayList<Drugs> drugsByPrice = drugRoom.getToysInRange(20, 70, false);
		for (Drugs d : drugsByPrice) {
			System.out.println(d);
		}


	}

}

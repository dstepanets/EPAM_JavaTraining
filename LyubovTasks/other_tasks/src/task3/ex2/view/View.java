package task3.ex2.view;

import task3.ex2.controller.StoreManager;
import task3.ex2.model.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	StoreManager manager;
	Scanner scan = new Scanner(System.in);

	public View(StoreManager manager) {
		this.manager = manager;
	}

	private String getLine(String msg) {
		String ln;
		do {
			System.out.print(msg + ":> ");
			ln = scan.nextLine();
			ln = ln.trim();
		} while (ln == null || ln.length() < 1);
		return ln;
	}

	public int getNum(String msg) {
		do {
			System.out.print(msg + ":> ");
		} while (!scan.hasNextInt());
		return scan.nextInt();
	}

	public String createStore() {
		return getLine("Enter the name of your store:\n");
	}

	public void mainMenu() {
		Store store = manager.getStore();
		System.out.println("Store: " + store.getName());
		ArrayList<Store.Department> departments = store.getDepartments();
		int size = 0;
		if (departments != null) {
			size = departments.size();
			System.out.println("Departments: " + size);
			for (int i = 0; i < size; i++) {
				System.out.println((i + 1) + ". " + store.getDepartments().get(i).getName());
			}
		}

		System.out.println("Operations on departments:");
		System.out.println("\tadd");
		System.out.println("\tdel");
		System.out.println("\tview");
		System.out.println("\tsort");
		System.out.println("\texit");

		boolean correctCommand;
		String command;
		do {
			correctCommand = true;
			command = getLine("");
			switch (command.toLowerCase()) {
				case "add":
					addDepartment();
					break;
				case "del":
					delDepartment();
					break;
				case "view":
					viewDepartment();
					break;
				case "sort":
					sortDepartments();
					break;
				case "exit":
					manager.exitProgram();
					break;
				default:
					correctCommand = false;
			}
		} while (!correctCommand);

	}

	private void addDepartment() {
		String name;
		String merchandise;
		String service;
		String location;

		name = getLine("Enter name of the department:\n");
		merchandise = getLine("What it will sell?\n");
		service = getLine("What service it will provide?\n");
		location = getLine("Where it will be located?\n");

		manager.getStore().addDepartment(name, merchandise, service, location);
	}

	private void delDepartment() {
		System.out.print("Which department to liquidate? ");
		int n;
		do {
			n = getNum("Enter its number.\n");
		} while (n < 1 || n > manager.getStore().getDepartments().size());
		manager.getStore().removeDepartment(n);
	}

	private void viewDepartment() {
		System.out.print("Which department to view? ");
		int n;
		do {
			n = getNum("Enter its number.\n");
		} while (n < 1 || n > manager.getStore().getDepartments().size());

		n--;
		Store.Department department = manager.getStore().getDepartments().get(n);
		System.out.println("---------------");
		System.out.println("Department: " + department.getName());
		System.out.println("Merchandise: " + department.getMerchandise());
		System.out.println("Service: " + department.getService());
		System.out.println("Location: " + department.getLocation());
		System.out.println("---------------");
	}

	private void sortDepartments() {
		System.out.println("Reorganize departments by:");
		System.out.println("1. Name");
		System.out.println("2. Merchandise");
		System.out.println("3. Service");
		System.out.println("4. Location");

		int n;
		do {
			n = getNum("Enter a number.\n");
		} while (n < 1 || n > 4);

		switch (n) {
			case 1:
				manager.sortDepartmentsByName();
				break;
			case 2:
				manager.sortDepartmentsByMerchandise();
				break;
			case 3:
				manager.sortDepartmentsByService();
				break;
			case 4:
				manager.sortDepartmentsByLocation();
				break;
		}

	}

}


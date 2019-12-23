package task3.ex2.model;

import java.util.*;

public class Store {

	private String name;
	private ArrayList<Department> departments = new ArrayList<>();

	public Store(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public class Department {

		public Department(String name, String merchandise, String service, String location) {
			this.name = name;
			this.merchandise = merchandise;
			this.service = service;
			this.location = location;
		}

		private String name;
		private String merchandise;
		private String service;
		private String location;

		public String getName() {
			return name;
		}

		public String getMerchandise() {
			return merchandise;
		}

		public String getService() {
			return service;
		}

		public String getLocation() {
			return location;
		}
	}

	public void addDepartment(String name, String merchandise, String service, String location) {
		departments.add(new Department(name, merchandise, service, location));
	}

	public void removeDepartment(int n) {
		departments.remove(n - 1);
	}

}

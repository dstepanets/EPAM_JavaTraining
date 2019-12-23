package task3.ex2.controller;

import task3.ex2.model.Store;
import task3.ex2.view.View;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StoreManager {

	private Store store;
	private View view = new View(this);

	public Store getStore() {
		return store;
	}

	public void startStoreManager() {
		store = new Store(view.createStore());
		while (true) {
			view.mainMenu();
		}
	}

	public void exitProgram() {
		System.exit(0);
	}

	public void sortDepartmentsByName() {
		Collections.sort(store.getDepartments(), new Comparator<Store.Department>() {
			@Override
			public int compare(Store.Department d1, Store.Department d2) {
				return d1.getName().compareTo(d2.getName());
			}
		});
	}

	public void sortDepartmentsByMerchandise() {
		Collections.sort(store.getDepartments(), new Comparator<Store.Department>() {
			@Override
			public int compare(Store.Department d1, Store.Department d2) {
				return d1.getMerchandise().compareTo(d2.getMerchandise());
			}
		});
	}

	public void sortDepartmentsByService() {
		Collections.sort(store.getDepartments(), new Comparator<Store.Department>() {
			@Override
			public int compare(Store.Department d1, Store.Department d2) {
				return d1.getService().compareTo(d2.getService());
			}
		});
	}

	public void sortDepartmentsByLocation() {
		Collections.sort(store.getDepartments(), new Comparator<Store.Department>() {
			@Override
			public int compare(Store.Department d1, Store.Department d2) {
				return d1.getLocation().compareTo(d2.getLocation());
			}
		});
	}


}

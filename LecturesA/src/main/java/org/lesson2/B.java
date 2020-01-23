package org.lesson2;

import static java.util.Objects.isNull;

public final class B {

	private final String description;
	private final A a;

	public B(String description, A a) {
		this.description = description;
		this.a = copyA();
	}

	public String getDescription() {
		return description;
	}

	public A getA() {
		return copyA();
	}

	private A copyA() {
		return isNull(a) ? null : new A(a.getCode());
	}

	@Override
	public String toString() {
		return "B{" +
				"description='" + description + '\'' +
				", a=" + a +
				'}';
	}
}

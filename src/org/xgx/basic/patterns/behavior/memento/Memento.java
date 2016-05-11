package org.xgx.basic.patterns.behavior.memento;

public class Memento {
	private String value;

	public Memento(final String val) {
		value = val;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}
}

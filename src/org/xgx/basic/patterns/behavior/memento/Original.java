package org.xgx.basic.patterns.behavior.memento;

public class Original {

	private String value;

	public Original(final String val) {
		value = val;
	}

	public Memento backup() {
		return new Memento(value);
	}

	public String getValue() {
		return value;
	}

	public void restore(final Memento memento) {
		value = memento.getValue();
	}

	public void setValue(final String value) {
		this.value = value;
	}
}

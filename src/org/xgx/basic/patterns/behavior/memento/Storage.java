package org.xgx.basic.patterns.behavior.memento;

public class Storage {
	private Memento memento;

	public Storage(final Memento memento) {
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(final Memento memento) {
		this.memento = memento;
	}

}

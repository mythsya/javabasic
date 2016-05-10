package org.xgx.basic.patterns.structural.bridge;

public abstract class Bridge {
	private Sourceable source = null;

	public Sourceable getSource() {
		return source;
	}

	public void method() {
		source.method();
	}

	public void setSource(final Sourceable source) {
		this.source = source;
	}
}

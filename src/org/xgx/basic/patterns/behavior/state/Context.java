package org.xgx.basic.patterns.behavior.state;

public class Context {
	private State state;

	public Context(final State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void method() {
		if (state.getValue().equals("1")) {
			state.method1();
		} else if (state.getValue().equals("2")) {
			state.method2();
		}
	}

	public void setState(final State state) {
		this.state = state;
	}
}

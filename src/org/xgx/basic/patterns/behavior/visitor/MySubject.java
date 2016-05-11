package org.xgx.basic.patterns.behavior.visitor;

public class MySubject implements Subject {

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		return "hello";
	}

}

package org.xgx.basic.patterns.behavior.visitor;

public interface Subject {
	void accept(Visitor visitor);

	String getSubject();
}

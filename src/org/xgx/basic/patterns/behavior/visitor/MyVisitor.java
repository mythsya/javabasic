package org.xgx.basic.patterns.behavior.visitor;

public class MyVisitor implements Visitor {

	@Override
	public void visit(final Subject subject) {
		// TODO Auto-generated method stub
		System.out.println("visit the subject: " + subject.getSubject());
	}

}

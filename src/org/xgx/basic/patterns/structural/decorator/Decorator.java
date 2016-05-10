package org.xgx.basic.patterns.structural.decorator;

public class Decorator implements Sourceable {

	private Sourceable source;

	public Decorator(final Sourceable src) {
		source = src;
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("before decorator!");
		source.method();
		System.out.println("after decorator!");
	}

}

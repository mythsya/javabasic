package org.xgx.basic.patterns.structural.proxy;

public class Proxy implements Sourceable {
	private Sourceable source = null;

	public Proxy(final Sourceable src) {
		source = src;
	}

	private void atfer() {
		System.out.println("after proxy!");
	}

	private void before() {
		System.out.println("before proxy!");
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		before();
		source.method();
		atfer();
	}
}

package org.xgx.basic.patterns.constructing.singleton;

public final class Singleton {

	private static final class SingletonFactory {
		private final static Singleton instance = new Singleton();
	}

	public final static Singleton getInstance() {
		return SingletonFactory.instance;
	}

	private Singleton() {

	}
}

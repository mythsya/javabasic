package org.xgx.basic.patterns.constructing.prototype;

public class Prototype implements Cloneable {

	@Override
	public Object clone() throws CloneNotSupportedException {
		Object c = super.clone();
		return c;
	}
}

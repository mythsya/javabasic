package org.xgx.basic.patterns.structural.bridge;

public class MyBridge extends Bridge {

	@Override
	public void method() {
		getSource().method();
	}
}

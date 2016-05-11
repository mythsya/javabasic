package org.xgx.basic.patterns.behavior.chainofresp;

public class MyHandler extends AbstractHandler implements Handler{

	private final String name;
	
	public MyHandler(String name) {
		this.name = name;
	}
	
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		System.out.println(name+" dealed.");
		if (getHandler() != null) {
			getHandler().operate();
		}
	}

}

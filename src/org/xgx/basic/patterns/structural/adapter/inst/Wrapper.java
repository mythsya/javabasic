package org.xgx.basic.patterns.structural.adapter.inst;

import org.xgx.basic.patterns.structural.adapter.clazz.Source;
import org.xgx.basic.patterns.structural.adapter.clazz.Targetable;

public class Wrapper implements Targetable {

	private Source source = new Source();

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		source.method1();
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method!");
	}

}

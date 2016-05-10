package org.xgx.basic.patterns.constructing.abstractfactory;

import org.xgx.basic.patterns.constructing.factorymethod.Sender;
import org.xgx.basic.patterns.constructing.factorymethod.SmsSender;

public class SmsSenderFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}

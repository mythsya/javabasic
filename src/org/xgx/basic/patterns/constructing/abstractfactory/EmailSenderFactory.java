package org.xgx.basic.patterns.constructing.abstractfactory;

import org.xgx.basic.patterns.constructing.factorymethod.EmailSender;
import org.xgx.basic.patterns.constructing.factorymethod.Sender;

public class EmailSenderFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new EmailSender();
	}

}

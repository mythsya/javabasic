package org.xgx.basic.patterns.constructing.factorymethod;

public class SenderFactory {

	public final static Sender emailSender() {
		return new EmailSender();
	}

	public final static Sender smsSender() {
		return new SmsSender();
	}
}

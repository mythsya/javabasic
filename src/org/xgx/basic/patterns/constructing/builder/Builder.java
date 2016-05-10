package org.xgx.basic.patterns.constructing.builder;

import java.util.ArrayList;
import java.util.List;

import org.xgx.basic.patterns.constructing.factorymethod.EmailSender;
import org.xgx.basic.patterns.constructing.factorymethod.Sender;
import org.xgx.basic.patterns.constructing.factorymethod.SmsSender;

public class Builder {

	private List<Sender> senders = new ArrayList<>();

	public void produceEmailSender(final int count) {
		for (int i = 0; i < count; i++) {
			senders.add(new EmailSender());
		}
	}

	public void produceSmsSender(final int count) {
		for (int i = 0; i < count; i++) {
			senders.add(new SmsSender());
		}
	}
}

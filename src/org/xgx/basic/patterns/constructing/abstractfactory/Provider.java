package org.xgx.basic.patterns.constructing.abstractfactory;

import org.xgx.basic.patterns.constructing.factorymethod.Sender;

public interface Provider {
	Sender produce();
}

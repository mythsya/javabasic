package org.xgx.basic.patterns.behavior.mediator;

public abstract class AbstractUser implements User {

	private final Mediator mediator;

	public AbstractUser(final Mediator mediator) {
		this.mediator = mediator;
	}

	public Mediator getMediator() {
		return mediator;
	}

}

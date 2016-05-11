package org.xgx.basic.patterns.behavior.mediator;

public class User2 extends AbstractUser {

	public User2(final Mediator mediator) {
		super(mediator);
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("user2 exec!");
	}
}

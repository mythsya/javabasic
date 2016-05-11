package org.xgx.basic.patterns.behavior.mediator;

public class User1 extends AbstractUser {

	public User1(final Mediator mediator) {
		super(mediator);
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("user1 exec!");
	}

}

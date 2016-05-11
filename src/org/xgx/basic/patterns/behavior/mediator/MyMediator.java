package org.xgx.basic.patterns.behavior.mediator;

public class MyMediator implements Mediator {

	private User user1, user2;

	@Override
	public void createMediator() {
		// TODO Auto-generated method stub
		user1 = new User1(this);
		user2 = new User2(this);
	}

	@Override
	public void workAll() {
		// TODO Auto-generated method stub
		user1.work();
		user2.work();
	}

}

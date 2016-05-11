package org.xgx.basic.patterns.behavior.command;

public class MyCommand implements Command {

	private Receiver receiver;
	
	public MyCommand(Receiver recv) {
		receiver = recv;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		receiver.action();
	}
	
	
}

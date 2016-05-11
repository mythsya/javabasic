package org.xgx.basic.patterns.behavior.command;

public class Invoker {
	private Command cmd;
	
	public Invoker(Command cmd) {
		this.cmd = cmd;
	}
	
	public void action() {
		cmd.exec();
	}
}

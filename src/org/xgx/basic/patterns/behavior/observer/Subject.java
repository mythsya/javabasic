package org.xgx.basic.patterns.behavior.observer;

public interface Subject {

	void addObserver(Observer observer);
	
	void delObserver(Observer observer);
	
	void notifyObservers();
	
	void operation();
}

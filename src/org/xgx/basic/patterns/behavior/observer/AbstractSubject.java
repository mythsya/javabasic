package org.xgx.basic.patterns.behavior.observer;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractSubject implements Subject{

	private CopyOnWriteArrayList<Observer> observers = new CopyOnWriteArrayList<>();
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);		
	}

	@Override
	public void delObserver(Observer observer) {
		observers.remove(observers);		
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update();
		}		
	}

}

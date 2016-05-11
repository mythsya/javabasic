package org.xgx.basic.patterns.behavior.iterator;

public interface Collection<E> {
	Iterator<E> iterator();
	E get(int i);
	int size();
}

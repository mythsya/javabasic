package org.xgx.basic.patterns.behavior.iterator;

public interface Iterator<E> {
	E prev();
	E next();
	boolean hasNext();
	E first();
}

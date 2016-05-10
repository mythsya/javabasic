package org.xgx.basic.concurrent.c5;

public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}

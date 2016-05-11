package org.xgx.basic.patterns.behavior.iterator;

public class MyIterator implements Iterator<Integer>{
	private final Collection<Integer> c;
	private int pos = -1;
	
	public MyIterator(Collection<Integer> c) {
		this.c = c;
	}
	
	@Override
	public Integer prev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer first() {
		// TODO Auto-generated method stub
		return null;
	}

}

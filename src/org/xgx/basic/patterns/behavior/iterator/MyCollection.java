package org.xgx.basic.patterns.behavior.iterator;

public class MyCollection implements Collection<Integer> {
	private Integer[] array = {1, 2, 3,4,5,6,7,8};

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer get(int i) {
		// TODO Auto-generated method stub
		return array[i];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return array.length;
	}
	
	
}

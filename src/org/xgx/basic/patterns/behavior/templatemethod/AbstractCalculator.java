package org.xgx.basic.patterns.behavior.templatemethod;

public abstract class AbstractCalculator {

	public final int calculate(String exp, String opt) {
		int[] arrInt = split(exp, opt);
		return calculate(arrInt[0], arrInt[1]);
	}
	
	public abstract int calculate(int num1, int num2);
	
	public int[] split(String exp, String opt) {
		String[] arr = exp.split(opt);
		int[] arrInt = new int[2];
		return arrInt;
	}
}

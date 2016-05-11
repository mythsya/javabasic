package org.xgx.basic.patterns.behavior.strategy;

public class Minus extends AbstractCalculator implements Calculatorable{

	@Override
	public int calculate(String exp) {
		int[] arrInt = split(exp, "-");
		return arrInt[0] - arrInt[1];
	}

}

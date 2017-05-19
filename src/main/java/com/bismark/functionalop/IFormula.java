package com.bismark.functionalop;

public interface IFormula {

	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}

}

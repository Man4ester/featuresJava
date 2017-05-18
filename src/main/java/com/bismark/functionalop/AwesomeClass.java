package com.bismark.functionalop;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
 */
public class AwesomeClass {

	public static Integer compute(Function<Integer, Integer> function, Integer value) {
		return function.apply(value);
	}

	private static Integer invert(Integer value) {
		return -value;
	}

	public static Integer invertTheNumber() {
		Integer toInvert = 5;
		Function<Integer, Integer> invertFunction = AwesomeClass::invert;
		return compute(invertFunction, toInvert);
	}
	
	public static Integer invertTheNumberMode() {
		Integer toInvert = 5;
		return compute(a->-a,toInvert);
	}
	
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println(add.apply(2, 4));
		System.out.println(AwesomeClass.invertTheNumber());
	}
}

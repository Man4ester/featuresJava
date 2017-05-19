package com.bismark.functionalop;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/*
 * https://habrahabr.ru/post/216431/
 */
public class InterfaceExamples {

	@FunctionalInterface
	interface ConverterB<F, T> {
		T convert(F from);
	}

	public static void main(String[] args) {
		IFormula formula = new FormulaImpl();
		System.out.println(formula.sqrt(12));

		ConverterB<String, Integer> c = (from) -> Integer.valueOf(from) + 1;

		ConverterB<String, Integer> c2 = (from) -> Integer.valueOf(from) - 2;

		System.out.println(c.convert("12"));
		System.out.println(c2.convert("12"));

		final int num = 1;
		ConverterB<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
		System.out.println(stringConverter.convert(2)); // 3

		String[] arr = { "a", "b" };
		test(arr);
		
		List<ConverterB<String, Integer>> lSource = new ArrayList<>();
		lSource.add(c);
		lSource.add(c2);
		lSource.add((form)->Integer.valueOf(form)*3);
		
		System.out.println();
		System.out.println("=======Test ====");
		testF(lSource, "12");
		System.out.println("==============");
		Integer t = getMyFunction().apply("43");
		System.out.println(t);

	}

	public static void test(String... a) {
		for (String s : a) {
			System.out.print(s+" ");
		}
	}
	
	public static void testF(List<ConverterB<String, Integer>> f, String val) {
		int u=Integer.valueOf(val);
		for (ConverterB<String, Integer> fSource : f) {
			u = fSource.convert(String.valueOf(u));
		}
		// second example
		f.forEach(v->{
			System.out.println(v.convert(String.valueOf(val)));
		});
		System.out.println("Final: "+u);
	}
	
	public static Function<String, Integer> getMyFunction(){
		return from->Integer.valueOf(from)+12;
	}

}

package com.bismark.functionalop;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world");
		List<Integer> l1 =	ExampleStreams.addOne(Arrays.asList(1,4,6));
		for (Integer v : l1) {
			System.out.println(v);
		}
	}

	public int test() {
		int count=0;
		++count;
		return count;
	}
}

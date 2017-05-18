package com.bismark.functionalop;

import java.util.List;
import java.util.stream.Collectors;

public class ExampleStreams {
	
	private ExampleStreams() {
		
	}

	public static List<Integer> addOne(List<Integer> numbers) {
		return numbers
				.stream()
				.map(number -> number + 1)
				.collect(Collectors.toList());
	}

}

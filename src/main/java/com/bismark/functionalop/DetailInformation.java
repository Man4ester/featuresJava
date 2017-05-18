package com.bismark.functionalop;

/*
 * 
 * 1. Make “super private” functions
 * 2. Upgrade Design Patterns
 * 3. Create “higher-order” functions
 */
public class DetailInformation {

	private DetailInformation() {

	}

	public static String getHigherOrderDetail() {
		return "Methods which take a function as a parameter " 
				+ "or return one, are called higher-order functions.";
	}
}

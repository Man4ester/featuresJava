package com.bismark.predicates;

import java.util.function.Predicate;

public class PersonsPredicates {
	
	private PersonsPredicates() {
		
	}

	public static Predicate<Person> isAdult() {
		return p -> p.getAge() > 21;
	}

	public static Predicate<Person> isFromUkraine() {
		return p -> "Ukraine".equals(p.getCountry());
	}

}

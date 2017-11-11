package com.bismark.predicates;

import static com.bismark.predicates.PersonsPredicates.isAdult;
import static com.bismark.predicates.PersonsPredicates.isFromUkraine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setAge(30);
		p1.setCountry("USA");

		Person p2 = new Person();
		p2.setAge(18);
		p2.setCountry("USA");

		System.out.println(isAdult().test(p1));
		System.out.println(isFromUkraine().test(p1));

		List<Person> l = new ArrayList<>();
		l.add(p1);
		l.add(p2);
		List<Person> lAdult = l.stream().filter(isAdult()).collect(Collectors.<Person>toList());
		lAdult.forEach(p->{
			System.out.println(p.getAge());
		});
			
		
	}

}

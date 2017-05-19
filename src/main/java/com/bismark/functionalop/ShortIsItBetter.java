package com.bismark.functionalop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bismark.functionalop.base.Person;

/*
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html 
 */
public class ShortIsItBetter {

	public static void main(String[] args) {
		example5();
	}

	public static void example1() {
		// Anonymous Runnable
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");

		// Run em!
		r1.run();
		r2.run();

	}

	public static void example2() {
		List<Person> personList = new ArrayList<>();
		Person per1 = new Person();
		per1.setSurName("w");

		Person per2 = new Person();
		per2.setSurName("a");

		personList.add(per1);
		personList.add(per2);

		// Sort with Inner Class
		Collections.sort(personList, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getSurName().compareTo(p2.getSurName());
			}
		});

		System.out.println("=== Sorted Asc SurName ===");
		for (Person p : personList) {
			System.out.println(p.getSurName());
		}

		// Use Lambda instead

		// Print Asc
		System.out.println("=== Sorted Asc SurName ===");
		Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));

		for (Person p : personList) {
			System.out.println(p.getSurName());
		}

		// Print Desc
		System.out.println("=== Sorted Desc SurName ===");
		Collections.sort(personList, (p1, p2) -> p2.getSurName().compareTo(p1.getSurName()));

		for (Person p : personList) {
			System.out.println(p.getSurName());
		}
	}

	public static void example3() {
		List<String> names = Arrays.asList("Sasha", "Petya", "Kolya");

		for (String val : names) {
			System.out.println(val);
		}

		names.forEach(v -> System.out.println(v));
	}

	public static void example4() {
		List<String> lines = Arrays.asList("spring", "node", "mkyong");

		List<String> result = lines.stream() // convert list to stream
				.filter(line -> !"mkyong".equals(line)) // we dont like mkyong
				.collect(Collectors.toList()); // collect the output and convert
												// streams to a List

		result.forEach(System.out::println); // output : spring, node
	}

	public static void example5() {
		Optional<String> gender = Optional.of("MALE");
		String answer1 = "Yes";
		String answer2 = null;

		System.out.println("Non-Empty Optional:" + gender);
		System.out.println("Non-Empty Optional: Gender value : " + gender.get());
		System.out.println("Empty Optional: " + Optional.empty());

		System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
		System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

		// java.lang.NullPointerException
		System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));

	}

}
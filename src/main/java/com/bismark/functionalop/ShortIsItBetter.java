package com.bismark.functionalop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bismark.functionalop.base.Person;

public class ShortIsItBetter {

	public static void main(String[] args) {
		example2();
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

}
package com.bismark.asynchronous;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableTest {

	public static void main(String[] args) throws Exception {
		Callable task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Test");
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result = future.get();

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);
	}

}

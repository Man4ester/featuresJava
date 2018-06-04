package com.bismark.asynchronous;

import java.util.concurrent.TimeUnit;

public class FirstTest {

	public static void main(String[] args) {
		System.out.println("Start");
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			try {
				System.out.println("Foo " + threadName);
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");
	}

}

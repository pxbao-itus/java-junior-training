package com.tma.pxbao.java_thread.semaphore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

// Throttle task submission
public class SemaphoreDemo {

    private final ExecutorService executor;
    private final Semaphore semaphore;

    public SemaphoreDemo(ExecutorService executor, int limit) {
        this.executor = executor;
        this.semaphore = new Semaphore(limit);
    }

    public <T> Future<T> submit(final Callable<T> task) throws InterruptedException {

        return executor.submit(() -> {

            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " semaphore.acquire()...");
            try {
                return task.call();
            } finally {
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " semaphore.release()...");
            }
        });

    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        // Only 2 tasks are able to run concurrently
        SemaphoreDemo obj = new SemaphoreDemo(executor, 2);

        obj.submit(() -> {
            System.out.println("task1 is running!");
            Thread.sleep(2000);
            System.out.println("task1 is done!");
            return 1;
        });

        obj.submit(() -> {
            System.out.println("task2 is running!");
            Thread.sleep(2000);
            System.out.println("task2 is done!");
            return 2;
        });

        obj.submit(() -> {
            System.out.println("task3 is running!");
            Thread.sleep(2000);
            System.out.println("task3 is done!");
            return 3;
        });

        obj.submit(() -> {
            System.out.println("task4 is running!");
            Thread.sleep(2000);
            System.out.println("task4 is done!");
            return 4;
        });

        obj.submit(() -> {
            System.out.println("task5 is running!");
            Thread.sleep(2000);
            System.out.println("task5 is done!");
            return 5;
        });

        executor.shutdown();
    }


}
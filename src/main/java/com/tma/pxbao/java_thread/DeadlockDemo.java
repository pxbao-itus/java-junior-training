package com.tma.pxbao.java_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

class Class1 {
    private int counterClass1 = 0;

    public Class1() {
        this.counterClass1 = 0;
    }

    public void increaseCounter() {
        synchronized (this) {
            for (int i = 0; i < 500; i++) {
                counterClass1++;
            }
        }

    }
}
public class DeadlockDemo {
    public static void main(String[] args) {
        Class1 object1 = new Class1();
        Class1 object2 = new Class1();
        Runnable r2 = new Runnable() {
            @Override
            public synchronized void run() {
                // Thread 1 get permission to hold object1 by synchronized block
                synchronized (object1) {
                    System.out.println("Thread 1 is holding object1");
                    object1.increaseCounter();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread 1 is waiting object2");
                    object2.increaseCounter();

                    System.out.println("Thread 1 is done");
                }
            }
        };
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 is holding object2");
                // Thread 2 get permission to hold object2 by synchronized block
                synchronized (object2) {
                    object2.increaseCounter();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread 2 is waiting object1");
                    object1.increaseCounter();
                    System.out.println("Thread 2 is done");
                }
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // submit task to thread pool
        executorService.submit(r1);
        executorService.submit(r2);
        executorService.shutdown();
    }
}

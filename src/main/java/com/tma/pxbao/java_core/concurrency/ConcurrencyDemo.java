package com.tma.pxbao.java_core.concurrency;

public class ConcurrencyDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 1 - "+ i);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2 - "+ i);
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

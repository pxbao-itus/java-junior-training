package com.tma.pxbao.java_thread;


public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 1 - "+ i);
                }
                System.out.println("Thread 1 done");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2 -- "+ i);
                }
                System.out.println("Thread 2 done");
            }
        });

        thread1.setPriority(1);
        thread2.setPriority(3);

        thread1.start();
        thread2.start();
    }
}

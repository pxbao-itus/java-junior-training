package com.tma.pxbao.java_thread;

public class ThreadLocalDemo {
   /* ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public void setValueThreadLocal(String threadLocalValue) {
        threadLocal.set(threadLocalValue);
    }

    public void printThreadLocal() {
        System.out.println(threadLocal.get());
    }*/

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread 1 set value of thread local
                threadLocal.set("Thread local of thread 1");
                System.out.println("t1 setup done");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // Thread 2 get value of thread local
                System.out.println(threadLocal.get());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread 2 set value of thread local
                threadLocal.set("Thread local of thread 2");
                System.out.println("t2 setup done");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // Thread 2 get value of thread local
                System.out.println(threadLocal.get());
            }
        });

        thread1.start();
        thread2.start();
    }
}

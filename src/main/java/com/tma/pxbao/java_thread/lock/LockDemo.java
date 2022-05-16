package com.tma.pxbao.java_thread.lock;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
//import java.util.concurrent.locks.Lock;

class Lock {
    private boolean isLocked;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " is holding lock");
        isLocked = true;
    }

    public synchronized void unlock() {
        if (isLocked) {
            isLocked = false;
            notify();
        }
    }
}

@Getter
class Counter {
    private int counter;
    private Lock lock;

    public Counter() {
        counter = 0;
        lock = new Lock();
    }

    public void inc() throws InterruptedException {
        try {
            lock.lock();
            counter++;
            System.out.println(Thread.currentThread().getName() + " Increasing counter.........." + counter);
        } finally {
            lock.unlock();
        }
    }

    public void dec() throws InterruptedException {
        try {
            lock.lock();
            counter--;
            System.out.println(Thread.currentThread().getName() + " Decreasing counter.........." + counter);
        } finally {
            lock.unlock();
        }
    }

    public void execution(int[] calculations) throws InterruptedException {
        try {
            lock.lock();
            for (int calculation : calculations) {
                Thread.sleep(1000);
                switch (calculation) {
                    case 1:
                        this.inc();
                        break;
                    case 2:
                        this.dec();
                        break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

}

public class LockDemo {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            try {
                counter.execution(new int[]{1, 2, 1});
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                counter.execution(new int[]{1, 2, 1, 2});
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter = " + counter.getCounter());
    }
}

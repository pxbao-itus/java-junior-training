package com.tma.pxbao.java_thread.reentrant_lock;

import com.tma.pxbao.java_thread.read_write_lock.ReadWriteLockDemo;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

@NoArgsConstructor
class ExtendReentrantLock extends ReentrantLock {

    private boolean isLocked = false;
    private Thread lockedBy = null;
    private int lockCount = 0;

    public ExtendReentrantLock(boolean fair) {
        super(fair);
    }

    @Override
    public synchronized boolean tryLock() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        while (isLocked && Thread.currentThread() != lockedBy) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting lock");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isLocked = true;
        lockedBy = Thread.currentThread();
        lockCount++;
        return true;
    }
//    public  void lock2() {
//        System.out.println("Lock 2");
//    }
    @Override
    public synchronized void lock() {

        while (isLocked && Thread.currentThread() != lockedBy) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isLocked = true;
        lockedBy = Thread.currentThread();
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        if (!isLocked || lockedBy != Thread.currentThread()) {
            return;
        }
        lockCount--;
        if (lockCount == 0) {
            isLocked = false;
            this.notifyAll();
        }
    }
}

public class ReentrantLockDemo implements Runnable {
    private final ExtendReentrantLock re = new ExtendReentrantLock();

    private List<String> list = new ArrayList<>();

    public ReentrantLockDemo() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
    }

//    public void runLock2(){
//        re.lock2();
//    }
    @Override
    public void run() {
        if (re.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " is holding outer lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                for (int i = 0; i < 2; i++) {
                    try {
                        // Call method to get inner lock
                        getElement(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } finally {
                re.unlock();
                System.out.println(Thread.currentThread().getName() + " is releasing outer lock\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void getElement(int index) throws InterruptedException {
        re.lock();
        System.out.println(Thread.currentThread().getName() + " is holding inner lock");
        try {
            Thread.sleep(500);
        } finally {
            re.unlock();
            System.out.println(Thread.currentThread().getName() + " is releasing inner lock");
        }
    }
}

class Main {
    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(reentrantLockDemo);
        executorService.execute(reentrantLockDemo);
        executorService.execute(reentrantLockDemo);

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reentrantLockDemo.runLock2();
//            }
//        });
//        t1.start();
    }
}

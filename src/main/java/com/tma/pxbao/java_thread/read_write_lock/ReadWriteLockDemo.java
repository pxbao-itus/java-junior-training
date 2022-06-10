package com.tma.pxbao.java_thread.read_write_lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo<T> {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    private final List<T> list;

    public ReadWriteLockDemo() {
        this.list = new ArrayList<>();
    }

    public T getElement(int i) throws InterruptedException {
        readLock.lock();
        System.out.println("Hold read lock");
        try {
            System.out.println(Thread.currentThread().getName() + " is getting element " + i);
            Thread.sleep(1000);
            return (T) list.get(i);
        }
        catch (IndexOutOfBoundsException e) {
            return (T) "Index out of boundary";
        }finally {
            System.out.println("Release read lock");
            readLock.unlock();
        }
    }

    public void setElement(T element) throws InterruptedException {
        writeLock.lock();
        System.out.println("Hold write lock");
        try {
            System.out.println(Thread.currentThread().getName() + " is adding element ---" + list);
            Thread.sleep(1000);
            list.add(element);
        } finally {
            System.out.println("Release write lock");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo<String> readWriteLockDemo = new ReadWriteLockDemo();
        List<String> dataList = new ArrayList<>();
        dataList.add("One");
        dataList.add("Two");
        dataList.add("Three");
        dataList.add("Four");
        dataList.add("Five");
        Runnable readRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Element " + i + "th is " + readWriteLockDemo.getElement(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable writeRunnable = () -> {
            for(String data: dataList) {
                try {
                    readWriteLockDemo.setElement(data);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(readRunnable).start();
        new Thread(writeRunnable).start();
        new Thread(writeRunnable).start();
        new Thread(readRunnable).start();

    }
}

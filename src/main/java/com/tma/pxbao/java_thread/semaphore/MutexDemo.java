package com.tma.pxbao.java_thread.semaphore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MutexDemo {

    private final Semaphore mutex;

    // only 1 user is allow
    public MutexDemo() {
        this.mutex = new Semaphore(1);
    }

    private void ssh(String user) throws InterruptedException {

        mutex.acquire();
        System.out.println( user + " mutex.acquire()");

        Thread.sleep(2000);

        mutex.release();
        System.out.println( user + " mutex.release()");

    }


    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        MutexDemo task = new MutexDemo();

        // submit 3 tasks
        executor.submit(() -> {
            try {
                task.ssh("pxbao");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                task.ssh("tma");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                task.ssh("abc");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();

    }
}
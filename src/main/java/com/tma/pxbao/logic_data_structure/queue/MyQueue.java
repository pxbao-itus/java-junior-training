package com.tma.pxbao.logic_data_structure.queue;

import java.util.Arrays;

public class MyQueue<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object array[];

    public MyQueue() {
        this.size = 0;
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void enqueue(E item) {
        if (this.isFull()) {
            resizeQueue();
        }
        array[size++] = item;
    }

    public void resizeQueue() {
        int newSize = size * 2;
        array = Arrays.copyOf(array, newSize);
    }

    public E dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        E e = (E) array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        array[--size] = null;
        return e;
    }

    public E front() {
        if(this.isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    public E rear() {
        if(this.isEmpty()) {
            return null;
        }
        return (E) array[size-1];
    }

    public void print() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]+ (i != size - 1 ? "," : ""));
        }
    }
}

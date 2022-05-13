package com.tma.pxbao.logic_data_structure.stack;

import java.util.Arrays;

public class MyStack<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Pushing element to the top of Stack
    public void push(E e) {
        if (size == elements.length) {
            resizeStack();
        }
        elements[size++] = e;
    }

    private void resizeStack() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    // Popping element on the top of Stack
    @SuppressWarnings("unchecked")
    public E pop() {
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }

    // Display element on the top of Stack
    public E peek() {
        return (E) elements[0];
    }

    public void print() {
        System.out.print("Stack: ");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + elements[i]+ (i != size - 1 ? "," : ""));
        }
    }
}

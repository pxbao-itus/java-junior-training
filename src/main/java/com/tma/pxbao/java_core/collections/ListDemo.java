package com.tma.pxbao.java_core.collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // add element to list
        list.add("First");
        list.add("Second");
        list.add("Third");

        // get element of list
        System.out.println("Element at 2nd position: " + list.get(2));

        // remove element from list
        list.remove("Second");
        System.out.println("List after removed element \"Second\": " + list);
    }
}

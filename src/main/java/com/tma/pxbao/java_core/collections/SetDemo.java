package com.tma.pxbao.java_core.collections;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("First");
        hashSet.add("Second");
        hashSet.add("Third");
        hashSet.add("Fourth");
        System.out.println("HashSet: " + hashSet);

        hashSet.add("First");
        System.out.println("HashSet after add duplicate element: " + hashSet);

        hashSet.remove("Second");
        System.out.println("HashSet after remove element 'Second' : " + hashSet);


        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(4);

        System.out.println("LinkedHashSet: " + linkedHashSet);
        linkedHashSet.add(3);

        linkedHashSet.remove(2);
        System.out.println("LinkedHashSet after remove element '2': " + linkedHashSet);
    }
}

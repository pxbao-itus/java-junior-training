package com.tma.pxbao.java_core.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        hashMap.put(4, "four");
        System.out.println("HashMap: " + hashMap);

        hashMap.remove(2);
        System.out.println("HashMap after remove element that has key equals 2: " + hashMap);

        hashMap.put(0, "zero");
        hashMap.put(2, "two");
        hashMap.put(10, "ten");
        System.out.println("Set key of HashMap: " + hashMap.keySet());
        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "one");
        linkedHashMap.put(2, "tow");

        linkedHashMap.put(4, "four");
        System.out.println("LinkedHashMap: " + linkedHashMap);

        linkedHashMap.put(3, "three");
        System.out.println("LinkedHashMap: " + linkedHashMap);


    }
}

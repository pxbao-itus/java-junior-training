package com.tma.pxbao.java_core.immutable;

import java.util.HashMap;
import java.util.Map;

// Class 2
// Main class
public class Immutable {

    // Main driver method
    public static void main(String[] args) {
            // Creating Map object with reference to HashMap
            Map<String, String> map = new HashMap<>();
            // Adding elements to Map object
            // using put() method
            map.put("1", "first");
            map.put("2", "second");
            Student s = new Student("ABC", 101, map);
            s.getMetadata().put("3", "third");
            // Remains unchanged due to deep copy in getter
            System.out.println("\n\nElement is added after constructor method run:" + s.getMetadata().get("3"));
    }
}


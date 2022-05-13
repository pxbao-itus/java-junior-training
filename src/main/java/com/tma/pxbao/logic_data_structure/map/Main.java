package com.tma.pxbao.logic_data_structure.map;

public class Main {
    public static void main(String[] args) {
        MyMap<Integer, String> myMap = new MyMap<>();

        // Add element to myMap
        myMap.put(new MapElement(1,"Math"));
        myMap.put(new MapElement(2,"Physical"));
        myMap.put(new MapElement(4,"Science"));
        myMap.put(new MapElement(5,"Chemistry"));
        myMap.put(new MapElement(6,"Music"));
        myMap.put(new MapElement(7,"Art"));

        myMap.print();

        // Get element by key, by value
        System.out.println("\nGet key by value = Chemistry: key = " + myMap.getByValue("Chemistry"));
        System.out.println("Get key by key = 4: key = " + myMap.getByKey(4));

        // Remove element by key or value
        myMap.remove(2);
        myMap.remove(null, "Art");

        System.out.println("\n\nMap after remove element by key or value");
        myMap.print();

        // Get key set of Map
        System.out.println("\n\nKey set of Map: " + myMap.keySet());
    }
}

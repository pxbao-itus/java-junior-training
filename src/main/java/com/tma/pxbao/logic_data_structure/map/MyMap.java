package com.tma.pxbao.logic_data_structure.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {
    private int size = 0;
    private int DEFAULT_SIZE = 10;

    @SuppressWarnings("unchecked")
    private MapElement<K, V>[] values = new MapElement[DEFAULT_SIZE];

    // Get value by input key
    public V getByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                return (V) values[i].getValue();
            }
        }
        return null;
    }

    public K getByValue(V value) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(value)) {
                return (K) values[i].getKey();
            }
        }
        return null;
    }

    // put element to end of Map if this element doesn't exist in Map
    public void put(MapElement value) {
        // variable to specify that does element exist in Map
        boolean insertAbility = true;
        for ( int i = 0; i < size; i++) {
            if (values[i].getKey().equals(value.getKey())) {
                // Update value for element
                values[i].setValue((V) value.getValue());
                insertAbility = false;
                break;
            }
        }

        if (insertAbility) {

            // resize Map to x2 size
            resizeMap();
            values[size++] = value;
        }

    }

    // resize Map to x2 size
    public void resizeMap() {
        if (size == values.length) {
            values = Arrays.copyOf(values, values.length * 2);
        }
    }

    // Get size of Map
    public int size() {
        return this.size;
    }

    // Remove element in Map
    public void remove(Object... args) {
        K key;
        if (args.length == 1) {
            key = (K) args[0];
            for (int i = 0; i < size; i++) {
                if (values[i].getKey().equals(key)) {
                    size--;
                    reArrangeArray(i);
                    return;
                }
            }
        }
        V value;
        if (args.length == 2) {
            value = (V) args[1];
            for (int i = 0; i < size; i++) {
                if (values[i].getValue().equals(value)) {
                    size--;
                    reArrangeArray(i);
                    return;
                }
            }
        }
        return;

    }

    // Rearrange array values when an element is removed with specify position
    public void reArrangeArray(int position) {
        for (int i = position; i < values.length - 1; i++) {
            values[i] = values[i++];
        }
    }

    // get set of key in Map
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(values[i].getKey());
        }
        return set;
    }

    // print Map
    public void print() {
        System.out.println("MyMap: ");
        for(int i = 0; i < size; i++) {
            System.out.println(values[i].toString());
        }
    }
}

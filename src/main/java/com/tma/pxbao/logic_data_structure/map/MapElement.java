package com.tma.pxbao.logic_data_structure.map;

public class MapElement<K, V> {
    private final K key;
    private V value;

    public MapElement(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MapElement{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

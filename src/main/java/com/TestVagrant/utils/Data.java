package com.TestVagrant.utils;

import java.util.HashMap;

public class Data {
    private static HashMap<String, Object> data = new HashMap<>();

    public static <V> V get(String key) {
        return (V) data.get(key);
    }

    public static <V> void put(String key, V value) {
        data.put(key, value);
    }

    public static HashMap<String, Object> getData() {
        return data;
    }
}

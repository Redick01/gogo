package org.gogo.week13;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Redick
 * @date 2021/9/12 9:36 下午
 */
public class LRUCache {

    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedCoppedHashMap<>(capacity);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    private static class LinkedCoppedHashMap<K, V> extends LinkedHashMap<K, V> {

        int maximumCapacity;

        LinkedCoppedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > maximumCapacity;
        }
    }
}

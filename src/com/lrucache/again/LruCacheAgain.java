package com.lrucache.again;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCacheAgain {
    
    public static void main(String[] args) {
        int initialCapacity =4;
        boolean accessOrder = true;
        Map<Integer, Integer> lru = new LinkedHashMap<>(initialCapacity,0.75f,accessOrder);
        //this will directly work as a lru cache
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.get(1);
        lru.put(6, 6);
        lru.put(7, 7);
        System.out.println(lru);
        
        
    }
}
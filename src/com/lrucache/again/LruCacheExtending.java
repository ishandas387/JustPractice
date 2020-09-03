package com.lrucache.again;

import java.util.LinkedHashMap;

public class LruCacheExtending extends LinkedHashMap<Integer, Integer> {

    /**
     *
     */
    private static final long serialVersionUID = -3989223103188112870L;
    private int size;
    public LruCacheExtending(int size){
        super(size,0.75f,true);
        this.size = size;
    }
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > size;
    }
    
    public static void main(String[] args) {
        LruCacheExtending lru = new LruCacheExtending(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        System.out.println(lru);    

    }
}
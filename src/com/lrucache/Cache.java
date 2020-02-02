package com.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache extends LinkedHashMap<Integer,Integer>{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int capacity;

    public Cache(int c){
        super(c,0.75f,true);
        this.capacity =c;
    }

    public int get(int i){
        return super.getOrDefault(i, -1);
    }

    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size() > capacity;
    }

    
}
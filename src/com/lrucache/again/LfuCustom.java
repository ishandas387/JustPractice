package com.lrucache.again;

import java.util.HashMap;
import java.util.Map;

public class LfuCustom {
    
    // create entry with frequency
    // same ds as lru
    public class Entry {
	
        long key;
        long value;
        int frequency;
        Entry prev;
        Entry next;
     
        public Entry(long key, long value, int frequency){
            this.key   = key;
            this.value = value;
            this.frequency = frequency;
        }
    }

    Map<Integer, Entry> cache = new HashMap<>();
    public void add(int key, int val){

        //if it is not there in the map
        //add it with frequency 1
        // else remove node
        // add the node with updated frequency based on which ever is highest
        
    }

}

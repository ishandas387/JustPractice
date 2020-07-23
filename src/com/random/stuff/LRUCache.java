package com.random.stuff;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    Map<Integer,Entry> map = new HashMap<>();
    Entry head, tail;
    final int capacity = 5;
    //add
    public void add(int key, int value){
        //the key is present, so update the value and move it to the top / head

        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.value = value;
            removeNode(entry);
            addToTop(entry);
        }
        // key is not present, add the value to the top
        else {
            //add the key 
            // but check the capacity
            Entry node = new Entry();
            node.value = value;
            node.key = key;
            node.next = null;
            node.previous = null;

            if(map.size() >= capacity){
                map.remove(tail.key);
                removeNode(tail);
                addToTop(node);
            } else {
                addToTop(node);
            }
            map.put(key, node);

        }

        
    }

    private void removeNode(Entry entry) {
        if(entry.previous != null){
            entry.previous.next = entry.next;
        } else {
            head = entry.next;
        }
        if(entry.next != null){
            entry.next.previous = entry.previous;
        } else {
            tail = entry.previous;
        }
    }

    private void addToTop(Entry entry){
        entry.next = head;
        entry.previous = null;
        if(head != null){

            head.previous = entry;
        }
        if(tail == null){
            tail = head;
        }

    }

    //get
    public int get(int key){
        if(map.containsKey(key)){
            Entry node = map.get(key);
            removeNode(node);
            addToTop(node);
            return node.value;
        }
        return -1;
    }

    //remove

    //addtohead

}

class Entry{
    int key;
    int value;
    Entry next;
    Entry previous;
}
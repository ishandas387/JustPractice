package com.rvs2026.cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LruCacheAgain {
    
    class Entry {
        int key;
        int value;
        Entry next;
        Entry prev;
        
        @Override
        public String toString() {
            return key +"-"+ value;
        }
    }

    Entry head, tail;
    final int CAPACITY = 4;

    Map<Integer, Entry> theCache = new HashMap<>();
    

    //1. method to add a key value to the cache
    // if the key already exists- update the value and move the key to the top of the cache.
    // if the key does not exists - create a new Entry with prev and next as null
    // check cache capacity and remove the tail if needed.
    // add to the cache and move the new node tot the top. 

    public void put(int key, int value) {
        if(theCache.containsKey(key)) {
            Entry node = theCache.get(key);
            node.value = value;
            theCache.put(key, node);
            removeNode(node);
            moveToTop(node);
        } else {
            Entry node = new Entry();
            node.key = key;
            node.value = value;
            node.next = null;
            node.prev = null;
            if(theCache.size() >= CAPACITY) {
                theCache.remove(tail.key);
                removeNode(tail);
            }
            moveToTop(node);
            theCache.put(key, node);
        }
    }
    //2. Mehtod to get a value from the cahce based on the key and also move the key value to the top of the cache as it got used.

    public int get(int key) {
        if(theCache.containsKey(key)) {
            Entry node = theCache.get(key);
            removeNode(node);
            moveToTop(node);
            return node.value;
        }
        return -1;
    }
    // 3. Method to move a node to the top of the cache

    public void moveToTop(Entry node) {
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        if(tail == null) {
            tail = head;
        }
    }
    // 4. mehtod to remove a node from the cache.

    public void removeNode(Entry node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        if(node == head) {
            head = node.next;
        }
        if(node == tail) {
            tail = node.prev;
        }
    }
    // 5. Method to print the cache current state.

    public void printCache() {
        Entry currEntry = head;
        while(currEntry != null) {
            System.out.print(currEntry.key + " -> ");
            currEntry = currEntry.next; 
        }
        System.out.println("");
    }

    // 6. main method to test the cache implementation.
    public static void main(String[] args) {
        
        LruCacheAgain cache = new LruCacheAgain();
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.printCache(); // should print 4 -> 3 -> 2 -> 1
        System.out.println();

        cache.get(2); // should move 2 to the top
        cache.printCache(); // should print 2 -> 4 -> 3 -> 1
        System.out.println();

        cache.put(5, 5); // should evict key 1
        cache.printCache(); // should print 5 -> 2 -> 4 -> 3
        System.out.println();

        System.out.println(cache.get(1)); // should return -1 (not found)
        System.out.println(cache.get(3)); // should return 3 and move it to the top
        cache.printCache(); // should print 3 -> 5 -> 2 -> 4
    }

}

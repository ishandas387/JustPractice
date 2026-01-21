package com.rvs2026.cache.lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class LruCache {

    public class Entry {
        int key;
        int value;
        Entry next;
        Entry prev;
        @Override
        public String toString() {
            return key +"-"+ value;
        }

    }

    Map<Integer, Entry> map = new HashMap<>();
    Entry head, tail;
    final int CAPACITY = 4;

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            Entry node = map.get(key);
            node.value = value;
            map.put(key, node);
            removeNode(node);
            moveToTop(node);
      
        } else {
            Entry node = new Entry();
            node.key = key;
            node.value = value;
            node.next = null;
            node.prev = null;
            
            if(map.size() >= CAPACITY) {
                map.remove(tail.key);
                removeNode(tail);
            }
                moveToTop(node);
                map.put(key, node);
        }
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Entry node = map.get(key);
            removeNode(node);
            moveToTop(node);
            return node.value;
        }

        return -1;
    }

    public void moveToTop(Entry e) {

        e.prev = null;
        e.next = head;
        
        if(head != null) {
            head.prev = e;
        }
        head = e;
        if(tail == null) {
            tail = head;
        }


    }

    public void removeNode(Entry e) {

        if(e.prev != null) {
            e.prev.next = e.next;
        } else {
            // this is the head.
            head = e.next;
        }

        if(e.next != null) {
            e.next.prev = e.prev;
        } else {
            // this was the tail
            tail = e.prev;
        }

    }

    public void printLinkedList() {
        Entry current = head;
        while(current != null) {
            System.out.print(current.key +"->");
            current = current.next;

        }
                    System.out.println("");
    }
    
    @Override
    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {

        LruCache lrucache = new LruCache();
		lrucache.put(1, 10);
		lrucache.put(10, 100);
		lrucache.put(15, 150);
		lrucache.put(10, 160);
		lrucache.put(12, 120);

        lrucache.printLinkedList();
		lrucache.put(18, 180);
		//lrucache.put(13, 16);
        lrucache.printLinkedList();
		System.out.println(lrucache.get(1));
		System.out.println(lrucache.get(10));
        lrucache.printLinkedList();
		System.out.println(lrucache.get(15));
        lrucache.printLinkedList();
    }
}

package com.rvs2026.cache.lfu;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    // Least Frequently Used Cache
    // 1. get a value from the cache based on the key and also update the frequency
    // of the key as it got used.
    // 2. method to add a key value to the cache
    // if the key already exists- update the value and move the key to the top of
    // the cache.
    // if the key does not exists - create a new Entry with prev and next as null
    // check cache capacity and remove the least frequently used key if needed.
    // add to the cache and move the new node to the top.

    /**
     * The key insight is that we need a two-level organization:
     * 
     * First level: Group nodes by their frequency
     * Second level: Within each frequency group, maintain the order of access (for
     * LRU tie-breaking)
     * Why track min_freq?
     * 
     * When the cache is full and we need to evict, we must quickly identify which
     * frequency group has the lowest count.
     * Instead of searching through all frequencies, we maintain a min_freq variable
     * that always points to the current minimum frequency level.
     */


    class Entry {
        int key;
        int value;
        int frequency;
        Entry next;
        Entry prev;

        public Entry(int key, int value) {
            this.key = key;
            this.value= value;
            this.frequency = 1;
        }
        
        @Override
        public String toString() {
            return key + "-" + value + "-" + frequency;
        }
    }

    class DoublyLinkedList{
        Entry head;
        Entry tail;

        public DoublyLinkedList() {
            head = new Entry(-1, -1); // dummy head
            tail = new Entry(-1, -1); // dummy tail
            head.next = tail;
            tail.prev = head;
        }

        // Add first node

        public void addFirstNode(Entry node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        // remove node

        public Entry removeNode(Entry node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            return node;
        }
        // remove last node
        public Entry removeLastNode() {
            if(tail.prev == head) {
                return null;
            }

            return removeNode(tail.prev);
        }

        // check if the list is empty
        public boolean isEmpty() {
            return head.next == tail;
        }


    }

    final int CAPACITY = 3;
    Map<Integer, Entry> theCache = new HashMap<>();
    Map<Integer, DoublyLinkedList> frequencyMap = new HashMap<>();
    int minFreq = 0;

    public int get(int key) {
        if(theCache.containsKey(key)) {
            Entry node = theCache.get(key);
            updateFrequency(node);
            return node.value;
        }
        return -1;
    }

    private void updateFrequency(Entry node) {
        int currentFrew = node.frequency;
        DoublyLinkedList currentList = frequencyMap.get(currentFrew);
        currentList.removeNode(node);

        if(currentList.isEmpty()) {
            frequencyMap.remove(currentFrew);
            if(minFreq == currentFrew) {
                minFreq++;
            }
        } 
        node.frequency++;
        addNodeToNewFrequencyList(node);
    }

    private void addNodeToNewFrequencyList(Entry node) {
        int freq = node.frequency;
        frequencyMap.computeIfAbsent(freq, k -> new DoublyLinkedList()).addFirstNode(node);
    }

    public void put(int key, int value) {
        if(CAPACITY <= 0) {
            return;
        }

        if(theCache.containsKey(key)) {
            Entry node = theCache.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if(theCache.size() >= CAPACITY) {
                DoublyLinkedList doublyLinkedList = frequencyMap.get(minFreq);
                Entry removeLastNode = doublyLinkedList.removeLastNode();
                theCache.remove(removeLastNode.key);
            }
            Entry newNode = new Entry(key, value);
            theCache.put(key, newNode);
            frequencyMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirstNode(newNode);
            minFreq = 1;
        }

    }

    public void printCache() {
        for(Map.Entry<Integer, DoublyLinkedList> entry : frequencyMap.entrySet()) {
            int freq = entry.getKey();
            DoublyLinkedList list = entry.getValue();
            System.out.print("Frequency " + freq + ": ");
            Entry current = list.head.next;
            while(current != list.tail) {
                System.out.print(current + " ");
                current = current.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // Test cases
        LFUCache cache = new LFUCache();
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); 
        System.out.println(cache.get(2)); 
        cache.put(4, 4); 
        System.out.println(cache.get(3)); 
        System.out.println(cache.get(4));
        cache.put(5, 5); 
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(5)); // returns 5
          System.out.println(cache.get(5));
            System.out.println(cache.get(5));
              System.out.println(cache.get(5));
        cache.printCache();
    }
}

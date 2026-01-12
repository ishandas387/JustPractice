package com.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LruCacheTest {

    // Map to store the key and Entry
    Map<Integer, Entry> map = new HashMap<>();
    Entry head, tail;
    final int CAPACITY = 4;

    public int get(int key) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            // remove the node from where ever it is
            removeNode(entry);
            // add the node to top or start or head
            addToTop(entry);
            // and return the value
            return entry.value;

        }

        return -1;
    }

    public void put(int key, int value) {
        // if the key exists
        // update the value and move the value to the top in the linked list
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.value = value;
            removeNode(entry);
            addToTop(entry);
        }

        // if the key does not exists
        else{
            Entry node = new Entry();
            node.value= value;
            node.prev=null;
            node.next=null;
            node.key=key;

            if(map.size() > CAPACITY){
                map.remove(tail.key);
                removeNode(tail);
                addToTop(node);
            }
            else{
                addToTop(node);
            }
            map.put(key, node);
        }
        // add the key. value. create entry , see if the list is exceeding the limit
        // if it exceed the size then delete older data from the last of list
        // add new data
    }

    public void addToTop(Entry node) {
        //given a node add it to top

        node.next = head;
        node.prev = null;

        if(head != null){
            head.prev= node;
        }
        if(tail == null){
            tail = head;
        }

    }

    public void removeNode(Entry node){
       if(node.prev != null){
           node.prev.next = node.next;
       }
       else{
           head = node.next;
       }
       if(node.next != null){
           node.next.prev = node.prev;
       }else{
           tail = node.prev;
       }
    }

    public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		LruCacheTest lrucache = new LruCacheTest();
		lrucache.put(1, 1);
		lrucache.put(10, 15);
		lrucache.put(15, 10);
		lrucache.put(10, 16);
		lrucache.put(12, 15);
		lrucache.put(18, 10);
		//lrucache.put(13, 16);

		System.out.println(lrucache.get(1));
		System.out.println(lrucache.get(10));
		System.out.println(lrucache.get(15));
        System.out.println(lrucache.toString());

	}
}

// Design a doubly linked list first
class Entry {
    int key;
    int value;
    Entry next;
    Entry prev;
}
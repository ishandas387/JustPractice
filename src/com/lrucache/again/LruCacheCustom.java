package com.lrucache.again;

import java.util.HashMap;
import java.util.Map;

public class LruCacheCustom {
    
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer,Node> lruMap = new HashMap<>();
    int capacity = 4;
    Node head, tail;


    //add
    public void add(int key, int val){
        //key can be present
        // if key is present 
        //remove node 
        // add to top
        if(lruMap.containsKey(key)){
            Node n = lruMap.get(key);
            removeNode(n);
            moveToTop(n);
        } else {
            Node n = new Node(key, val);
            //check capacity
            if(lruMap.size() == capacity){
                removeNode(tail);
                lruMap.remove(tail.key);
                moveToTop(n);
            } else {
                moveToTop(n);
            }

            lruMap.put(key, n);

        }
    }

    //get

    public int getElement(int key){
        //the map has the key
        // move the node to top
        //remove node
        if(lruMap.containsKey(key)){
            Node n = lruMap.get(key);
            removeNode(n);
            moveToTop(n);
            return n.val;
        }
        return -1;
    }

    //moveToTop

    public void moveToTop(Node node){
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        if(tail == null){
            tail = head;
        }
    }
    //remove
    public void removeNode(Node node){
        //check if it has prev pointer
        if(node.prev != null){
            //then move the prev node's pointer to the next.
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        //check if it has next node
        if(node.next != null){
            node.next.prev = node.prev;
        } else {
            //this is the new tail
            tail = node. prev;
        }
    }
    
}
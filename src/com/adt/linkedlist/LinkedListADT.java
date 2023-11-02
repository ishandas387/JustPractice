package com.adt.linkedlist;

public class LinkedListADT {
    Node head;

    public void add(int number) {
        Node node = new Node(number, null);

        if(this.head == null) {
            head = node;
        } else {
            Node n = head;
            while(n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAtStart(int number) {
        Node n = new Node(number, null);
        n.next = head;
        head = n;
    }

    public void insertAt(int number, int pos){
        if(pos == 0){
            insertAtStart(number);
            return;
        }
        Node n = new Node(number, null);
        Node node = head;
        for(int i =0 ; i<pos ; i++){
            node = node.next;
        }
        n.next = node.next;
        node.next = n;
    }
}

package com.linkdlist.stuff;

public class Intersect {
    public static void main(String[] args) {
        MyLinkedList A = new MyLinkedList();
        MyLinkedList B = new MyLinkedList();

        A.insert(1);
        A.insert(7);
        A.insert(8);
        A.insert(6);
        A.insert(4);
        A.insert(16);


        B.insert(3);
        B.insert(9);
        B.insert(10);
       // B.insert(4);
        B.insert(16);

        findIntersection(A, B);
    }

    private static void findIntersection(MyLinkedList a, MyLinkedList b) {

        Node current1 = a.head;
        Node current2 = b.head;
        boolean isAEnd = false;
        boolean isBEnd = false;

        if(current1 == null || current2 == null){
            return;
        } else if(current1 == current2){
            System.out.println(current1.data);
            return;
        }

        while(current1.next != null || current2.next != null){
            if(current1.data == current2.data){
                System.out.println(current1.data);
                return;
            }

            if(current1.next == null){
                isAEnd = true;
            }

            if(current2.next == null){
                isBEnd = true;
            }

            if(isAEnd){
                current1 = b.head;
                isAEnd = false;
            } else {
                current1 = current1.next;
            }

            if(isBEnd){
                current2 = a.head;
                isBEnd = false;
            } else {
                current2 = current2.next;
            }

        }
        if(current1 == current2){
            System.out.println(current1.data);
            return;
        }
        System.out.println("no intersection");
    
    }
}

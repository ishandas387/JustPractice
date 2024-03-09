package com.onefifty.linkedlist;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
public class DeleteNthNodeFromLast {
    public static void main(String[] args){
        //set up list
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head = n1;

        // 1 -> 2 -> 3 -> 4 -> 5
        deleteNode(head, 2);
    }

    private static ListNode deleteNode(ListNode head, int k) {
        if(k == 0){
            return head;
        }
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        //set second pointer at k distance

        for(int i = 0; i<k; i++) {
            secondPointer = secondPointer.next;
        }

        if(secondPointer == null) {
            return head.next;
        }

        while(secondPointer.next != null){
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }

        ListNode temp = firstPointer.next;
        firstPointer.next = temp.next;


        return head;
    }
}

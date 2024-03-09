package com.onefifty.linkedlist;

public class RotateLinkedList {
  /**
   * Given the head of a linked list, rotate the list to the right by k places.
   * Input: head = [1,2,3,4,5], k = 2
   * Output: [4,5,1,2,3]
   * @param args
   */
  public static void main(String[] args) {
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
      rotateList(head, 2);

  }

    private static ListNode rotateList(ListNode head, int k) {

      // get the total length of list
        ListNode temp = head;
        int l =0;
        while(temp != null) {
            l++;
            temp = temp.next;
        }

        if(l == 1 || l == k) {
            return head;
        }

        // rotate mod the length will give the exact extra point at which the head should move
        // if its 9 % 9 then the head remain as is because 9 rotations for 9 length is same start
        // 3 % 9 -> will be 3
        // 4 % 3 -> 1 , 3 rotations will bring back the original state of the list and then 1 more.
        int loop = k%l;
        loop = l - loop;

        int j = 0;
        temp = head;
        ListNode firstAddress = head;
        while(temp != null) {
            j++;
            if(j == loop) {
                firstAddress = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }

        temp = firstAddress;
        while(temp.next != null ) {
            temp = temp.next;

        }
        temp.next = head;
        return firstAddress;


    }
}

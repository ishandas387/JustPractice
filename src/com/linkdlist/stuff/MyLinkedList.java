package com.linkdlist.stuff;

public class MyLinkedList {

	Node head;
	
	public void insert(int data){
		Node node = new Node();
		node.data= data;
		node.next=null;
		if(head == null){
			head = node;
		}
		else{
			Node n = head;
			while(n.next!=null){
				n= n.next;
			}
			n.next=node;
			
		}
	}
	
	public void print(){ 
		Node node = head;
		while(node.next!= null){
			System.out.print(node.data+"->");
			node = node.next;
		}
		System.out.print(node.data+"->");
	}
	
	public void insertAtStart(int data){
		Node n = new Node();
		n.data= data;
		n.next= head;
		head = n;
	}
	
	public void insertAt(int data, int position){
		Node node = new Node();
		node.data=data;
		node.next= null;
		Node n = head;
		if(position ==0){
			insertAtStart(data);
		}
		
		for(int i=0; i<position-1;i++){
			n = n.next;
		}
		node.next= n.next;
		n.next= node;
		
	}

	public void reverse() {
		// TODO Auto-generated method stub

		Node current = this.head;
		Node next = null;
		Node previous=null;
		
		//int kThNode = i;
		
		while(current !=null ){
			next = current.next;
			current.next = previous;
			previous = current;
			current =  next;
		}
		this.head=previous;
		System.out.println("");
		print();
		
	}
	public void reverseKth(int k) {
		// TODO Auto-generated method stub

		Node current = this.head;
		Node next = null;
		Node previous=null;
		
		int kThNode = 1;
		
		while(kThNode < k && current !=null ){
			next = current.next;
			current.next = previous;
			previous = current;
			current =  next;
			kThNode++;
		}
		this.head=previous;
		System.out.println("");
		print();
		
	}
	
	public int findMiddle(){
		Node current = this.head;
		Node slow = this.head;
		while(current != null && current.next != null){
			current = current.next.next;
			slow = slow.next;
		}
		return slow.data;
	}
}

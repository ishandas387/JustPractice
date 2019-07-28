package com.linkdlist.stuff;

public class MiddleElementOfLl {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
	//	list.insert(5);
		list.print();
		System.out.println("**********");
		System.out.println(list.findMiddle());
	}

}

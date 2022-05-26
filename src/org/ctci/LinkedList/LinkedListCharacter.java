package org.ctci.LinkedList;

public class LinkedListCharacter {
	Node head = null;
	
	public class Node{
		char data;
		Node next;
		
		Node(char data){
			this.data = data;
			next = null;
		}
	}
	
	/**
	 * 1. Create a newHead node with provided data 
	 * 2. Point next pointer of newHead to head
	 * 3. Assign head to newHead
	 */
	void addFirst(char data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	void addLast(char data) {
		if (head==null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	void addMiddle(char previousNode, char data) {
		Node current = head;
		Node newNode = new Node(data);
		while(current.data != previousNode) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = current.next.next;
	}
	
	void removeFirst() {
		head = head.next;
	}
	
	void removeLast() {
		Node current = head;
		while(current.next.next != null) {
			current = current.next;
		}
		current.next = null;
	}
	
	void addAll(char[] data) {
		for (int i = 0; i < data.length; i++) {
			addLast(data[i]);
		}
	}
	
	void printSinglyLinkedList() {
		Node current = head;
		System.out.println("***** Linked list *****");
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
		}
	}
}

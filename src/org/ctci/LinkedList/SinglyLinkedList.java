package org.ctci.LinkedList;

//import java.util.LinkedList;
public class SinglyLinkedList {
	Node head = null;
	
		class Node{
			int data;
			Node next;
			
			Node(int data){
				this.data = data;
				next = null;
			}
		}
		
	/**
	 * 1. Create a newHead node with provided data 
	 * 2. Point next pointer of newHead to head
	 * 3. Assign head to newHead
	 */
	void addFirst(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	void addLast(int data) {
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
	
	void addMiddle(int previousNode, int data) {
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
	
	void printSinglyLinkedList() {
		Node current = head;
		System.out.println("***** Linked list *****");
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.addLast(1);
		sll.addLast(2);
		sll.addFirst(3);
		sll.addFirst(4);
		
		sll.printSinglyLinkedList();
		
		sll.removeFirst();
		sll.printSinglyLinkedList();
		
		sll.removeLast();
		sll.printSinglyLinkedList();
	}	
}
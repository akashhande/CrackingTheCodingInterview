package org.ctci.LinkedList;

import static org.junit.Assert.*;

import org.ctci.LinkedList.LinkedListCharacter.Node;
import org.junit.Before;
import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first 
 * and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
 * 
 * EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */
public class Example3 {
	
	char[] inputList;
	char[] outputList;
	
	@Before
	public void prepare(){
		inputList = new char[] {'a', 'b', 'c', 'd', 'e'};
		outputList = new char[] {'a', 'b', 'd', 'e'};
	}

	static LinkedListCharacter removeNode(LinkedListCharacter inputList, Node node) {
		Node current = inputList.head;
		while(current!=null) {
			if (current.next.data==node.data) {
				current.next=current.next.next;
				inputList.printSinglyLinkedList();
				return inputList;
			}
			current=current.next;
		}
		return inputList;
	}
	
	//lnput: a->b->c->d->e->f
	//Result:a->b->d->e->f
	static boolean removeNodeOptimised(Node node) {
		if(node==null || node.next==null)
			return false;
		
		Node next=node.next;
		node.data=next.data;
		node.next=next.next;
		return true;
	}
	
	@Test
	public void test() {
		LinkedListCharacter iList = new LinkedListCharacter();
		iList.addAll(inputList);
		Node node = iList.new Node('c');
		
		
		LinkedListCharacter oList = new LinkedListCharacter();
		oList.addAll(outputList);
		oList.printSinglyLinkedList();
		// ^ This should be a->b->d->e->f
		
		assertEquals(oList, removeNode(iList, node));
		assertEquals(false, removeNodeOptimised(node));
	}

}

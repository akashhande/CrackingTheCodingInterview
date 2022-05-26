package org.ctci.LinkedList;

import static org.junit.Assert.*;

import org.ctci.LinkedList.LinkedListInteger.Node;
import org.junit.Before;
import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class Example6 {
	
	int[] elements;
	
	@Before
	public void prepare(){
		elements = new int[] {1, 2, 3, 2, 1};
	}

	/**
	 * Reverse a linked list
	 * compare actual and reversed linked list 
	 */
	static boolean isPalindrome(LinkedListInteger list) {
		LinkedListInteger reversedList = reverseLinkedList(list);
		Node currentReversed = reversedList.head;
		Node currentActual = list.head;
		while(currentActual!=null) {
			if(currentActual.data!=currentReversed.data) 
				return false;
		}
		return true;
	}
	
	static LinkedListInteger reverseLinkedList(LinkedListInteger list) {
		LinkedListInteger outputList = new LinkedListInteger();
		Node current= list.head;
		while(current!=null) {
			outputList.addFirst(current.data);
			current=current.next;
		}
		return outputList;
	}

	@Test
	public void test() {
		LinkedListInteger ll = new LinkedListInteger();
		ll.addAll(elements);
		
		assertEquals(true, isPalindrome(ll));
	}

}

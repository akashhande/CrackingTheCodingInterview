package org.ctci.LinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.ctci.LinkedList.LinkedListInteger;
import org.ctci.LinkedList.LinkedListInteger.Node;

/**
 ***************************************** Problem statement ****************************************
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Example2 {
	
	int[] elements;
	
	@Before
	public void prepare(){
		elements = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	}
	
	static String linkedListSubstring(LinkedListInteger list, int position) {
		Node current = list.head;
		int count = 0;
		String outputString = "";
		
		while(current!=null) {
			count++;
			if (count>=position) {
				outputString+=current.data;
			}
			current=current.next;
		}
		return outputString;
	}
	
	@Test
	public void test() {
		LinkedListInteger ll = new LinkedListInteger();
		ll.addAll(elements);
		assertEquals("5678910", linkedListSubstring(ll, 5));
	}
}

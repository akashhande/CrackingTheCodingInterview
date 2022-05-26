package org.ctci.LinkedList;

import org.ctci.LinkedList.LinkedListInteger.Node;
import org.junit.Before;
import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * 
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * 
 * FOLLOW UP - Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 - > 1 -> 2. That is, 912.
 */
public class Example5 {
	
	int[] list1;
	int[] list2;
	
	@Before
	public void prepare(){
		list1 = new int[] {7, 1, 6, 2};
		list2 = new int[] {5, 9, 2};
	}

	static LinkedListInteger addition(LinkedListInteger list1, LinkedListInteger list2) {
		LinkedListInteger outputList = new LinkedListInteger();
		Node currentNode1 = list1.head;
		Node currentNode2 = list2.head;
		int carry=0;
		
		while(currentNode1!=null || currentNode2!=null) {
			int result=0;
			if(currentNode1!=null) {
				result+=currentNode1.data;
				currentNode1=currentNode1.next;
			}
			
			if(currentNode2!=null) {
				result+=currentNode2.data;
				currentNode2=currentNode2.next;
			}
			
			if(carry>0) {
				result+=carry;
				carry=0;
			}
			
			if(result>9)
			carry=result/10;
			result=result%10;
			outputList.add(result);
		}
		
		return outputList;
	}
	
	@Test
	public void test() {
		LinkedListInteger l1 = new LinkedListInteger();
		l1.addAll(list1);
		
		LinkedListInteger l2 = new LinkedListInteger();
		l2.addAll(list2);
		LinkedListInteger list = addition(l1, l2);
		list.printSinglyLinkedList();
	}

}

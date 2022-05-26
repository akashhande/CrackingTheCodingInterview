package org.ctci.LinkedList;

import org.ctci.LinkedList.LinkedListInteger.Node;
import org.junit.Before;
import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Example4 {

	int[] elements;
	
	@Before
	public void prepare(){
		elements = new int[] {3, 5, 8, 5, 10, 2, 1};
	}
	
	/**
	 * partition()
	 * 1. Go through given linkedlist and check weather node.data is < pivot
	 * 2. If node.data is less than pivot then add that node in beforeList
	 * 3. If node.data is greater than or equal to pivot then add that node in afterList
	 * 4. In the end merge the list 
	 */
	static LinkedListInteger partition(LinkedListInteger list, int pivot) {
		 LinkedListInteger beforeList = new LinkedListInteger();
		 LinkedListInteger afterList = new LinkedListInteger();
		 Node current = list.head;
			while (current!=null) {
				if(current.data<pivot) {
					beforeList.add(current.data);
				} else {
					afterList.add(current.data);
				}
				current=current.next;
			}
			return merge(beforeList, afterList);
	}
	
	/**
	 * merge()
	 * 1. Iterate through beforeList till null
	 * 2. Append lastNode of beforeList to first element of afterList 
	 */
	static LinkedListInteger merge(LinkedListInteger beforeList, LinkedListInteger afterList) {
		Node current=beforeList.head;
		while (current.next!=null) {
			current=current.next;
		}
		current.next=afterList.head;
		return beforeList;
	}
	
	@Test
	public void test() {
		LinkedListInteger ll = new LinkedListInteger();
		ll.addAll(elements);

		LinkedListInteger output = partition(ll, 5);
		output.printSinglyLinkedList();
	}
}

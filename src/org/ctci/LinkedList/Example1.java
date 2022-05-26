package org.ctci.LinkedList;

import java.util.HashSet;

import org.ctci.LinkedList.LinkedListCharacter.Node;
import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 */
public class Example1 {

	static void removeDuplicates(LinkedListCharacter list) {
		Node current = list.head;
		while(current.next != null) {
			Node searchPointer = current;
			while(searchPointer.next != null) {
				if (current.data == searchPointer.next.data) {
					searchPointer.next = searchPointer.next.next;
				} else {
					searchPointer = searchPointer.next;
				}
			}
			current = current.next;
		}
	}
	
	static void removeDuplicatesAdvanced(LinkedListCharacter list) {
		HashSet<Character> hashset = new HashSet<Character>();
		Node current = list.head;
		while (current != null) {
			if(!hashset.contains(current.data)) {
				hashset.add(current.data);
			}
			current = current.next;
		}
		System.out.println("Output - "+hashset.toString());
	}
	
	@Test
	public void test() {
		LinkedListCharacter ll = new LinkedListCharacter();
		ll.addLast('F');
		ll.addLast('O');
		ll.addLast('L');
		ll.addLast('L');
		ll.addLast('O');
		ll.addLast('W');
		ll.addLast(' ');
		ll.addLast('U');
		ll.addLast('P');
		ll.printSinglyLinkedList();
		
		//removeDuplicates(ll);
		removeDuplicatesAdvanced(ll);
		ll.printSinglyLinkedList();
	}

}

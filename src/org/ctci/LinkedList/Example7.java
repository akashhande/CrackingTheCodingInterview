package org.ctci.LinkedList;

import org.ctci.LinkedList.LinkedListInteger.Node;
import org.junit.Before;
import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. 
 * Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list
 * is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
public class Example7 {
	
	int[] list1;
	int[] list2;
	
	@Before
	public void prepare(){
		list1 = new int[] {3, 1, 5, 9, 7, 2, 1};
		list2 = new int[] {4, 6, 7, 2, 1};
	}
	
	static class LengthTail {
		int length;
		int lastNodeData;
		
		LengthTail(int length, int lastNodeData){
			this.length=length;
			this.lastNodeData=lastNodeData;
		}
	}
	
	static LengthTail getLengthTail(LinkedListInteger list) {
		int length=0;
		int lastNodeData;
		Node current=list.head;
		while(current.next!=null) {
			length++;
			current=current.next;
		}
		lastNodeData=current.data;
		return new LengthTail(length, lastNodeData);
	}

	/**
	 * Issue - shorter list is throwing NPE 
	 */
	static Node findIntersection(LinkedListInteger list1, LinkedListInteger list2) {
		LengthTail lt1 = getLengthTail(list1);
		LengthTail lt2 = getLengthTail(list2);
		
		if(lt1.lastNodeData!=lt2.lastNodeData)
			return null;
		
		int longer = lt1.length>lt2.length ? lt1.length : lt2.length;
		int shorter = lt1.length<lt2.length ? lt2.length : lt1.length;
		int chopOffLength=longer-shorter;
		
		Node currentList1=list1.head;
		Node currentList2=list2.head;
		
		while(longer!=0) {
			if(chopOffLength>0 && currentList1.next==currentList2.next) {
				return currentList1;
			}
			chopOffLength--;
			longer--;
			currentList1=currentList1.next;
			currentList2=currentList2.next;
		}
		return null;
	}
	
	@Test
	public void test() {
		LinkedListInteger l1 = new LinkedListInteger();
		l1.addAll(list1);
		
		LinkedListInteger l2 = new LinkedListInteger();
		l2.addAll(list2);
		
		findIntersection(l1, l2);
	}

}

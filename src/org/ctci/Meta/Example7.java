package org.ctci.Meta;

/**
 * 
 * NOT SOLVED
 * 
 * 
 * Reverse Operations
 * You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, 
 * bordered either by either end of the list or an odd element. 
 * For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
 * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
 * The goal of this question is: given a resulting list, determine the original order of the elements.
 * Implementation detail:
 * 			You must use the following definition for elements in the linked list:
 * 				class Node {
 *     				int data;
 *     				Node next;
 *     			}
 *
 */
public class Example7 {

	Node outputLinkedList;
	
	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}


	/**
	 * 1, 2, 8, 9, 12, 16 
	 *          ^
	 * pointer = 2
	 * tempArray = 2, 8
	 *                  
	 * 1. Iterate through the linked list
	 * 2. Check element is odd or even
	 * 3. If it is odd add to outputLinkedList
	 * 3. If it is even 
	 * 4. Reverse the sub array 
	 * 5. Add the reversed sub array to output Linked list
	 * @return 
	 */
	Node reverse(Node head) {
		int[] tempArray = new int[5];
		int pointer = 0;
		
		while (head!=null) {
			if(head.data%2==0){
				tempArray[pointer]=head.data;
				pointer++;
				head=head.next;
			} else if(pointer==0 && (head.data%2!=0 || head.next==null)) {
				addLast(head.data);
				head=head.next;
			} else if(pointer > 0 && (head.data%2!=0 || head.next==null)) {
				for (int i = tempArray.length-1; i >= 0; i--) {
					if (tempArray[i]!=0) {
						addLast(tempArray[i]);
					}
				}
				tempArray = new int[5];
				pointer=0;
				addLast(head.data);
				head=head.next;
			} 
		}
		return outputLinkedList;	
	}
		

	void addLast(int data) {
		if (outputLinkedList==null) {
			outputLinkedList = new Node(data);
		}
		Node current = outputLinkedList;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}

	int test_case_number = 1;

	void printLinkedList(Node head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
			if (head != null)
				System.out.print(" ");
		}
		System.out.print("]");
	}

	void check(Node expectedHead, Node outputHead) {
		boolean result = true;
		Node tempExpectedHead = expectedHead;
		Node tempOutputHead = outputHead;
		while (expectedHead != null && outputHead != null) {
			result &= (expectedHead.data == outputHead.data);
			expectedHead = expectedHead.next;
			outputHead = outputHead.next;
		}
		if (!(expectedHead == null && outputHead == null))
			result = false;

		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printLinkedList(tempExpectedHead);
			System.out.print(" Your output: ");
			printLinkedList(tempOutputHead);
			System.out.println();
		}
		test_case_number++;
	}

	Node createLinkedList(int[] arr) {
		Node head = null;
		Node tempHead = head;
		for (int v : arr) {
			if (head == null) {
				head = new Node(v);
				tempHead = head;
			} else {
				head.next = new Node(v);
				head = head.next;
			}
		}
		return tempHead;
	}

	public void run() {

		int[] arr_1 = { 1, 2, 8, 9, 12, 16 };
		int[] expected1 = { 1, 8, 2, 9, 16, 12 };
		Node head_1 = createLinkedList(arr_1);
		Node expected_1 = createLinkedList(expected1);
		Node output_1 = reverse(head_1);
		check(expected_1, output_1);

		int[] arr_2 = { 2, 18, 24, 3, 5, 7, 9, 6, 12 };
		int[] expected2 = { 24, 18, 2, 3, 5, 7, 9, 12, 6 };
		Node head_2 = createLinkedList(arr_2);
		Node expected_2 = createLinkedList(expected2);
		Node output_2 = reverse(head_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new Example7().run();
	}
}
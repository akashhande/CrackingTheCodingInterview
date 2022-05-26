package org.ctci.Queue;

/**
 * 1. Queue is a First In First Out data structure
 * 2. It maintains HEAD and TAIL pointers
 * 3. HEAD is used to ENQUEUE (adding element in Queue)
 * 4. TAIL is used to DEQUEUE (removing element in Queue)
 * 1 2 3 4 5 
 * H       T
 */
public class QueueInteger {
	int HEAD;
	int TAIL;
	int MAX=50;
	int[] element = new int[MAX];
	
	QueueInteger(){
		HEAD=TAIL=0;
	}
	
	/**
	 * 1. Check if Queue is full or not
	 * 2. If Queue is full then print overflow ERROR
	 * 3. If Queue is not full then increment TAIL and add element to TAIL
	 */
	void enqueue(int data) {
		if(TAIL>MAX-1) {
			System.out.println("ERROR : Queue overflow");
			return;
		}
		element[TAIL]=data;
		TAIL++;
	}
	
	/**
	 * 1. Check if Queue has element or not
	 * 2. If Queue is empty then print underflow ERROR and return -1
	 * 3. If Queue has element then return element from HEAD & increment HEAD pointer
	 * 4. Shift elements to left
	 * 1 2 3 4 5 
	 * H       T
	 */
	int dequeue() {
		if(isEmpty()) {
			System.out.println("ERROR : Queue underflow");
			return -1;
		}
		int output=element[HEAD];
		for(int i=0;i<TAIL;i++) {
			element[i]=element[i+1];
		}
		TAIL--;
		return output;
	}
	
	void printQueue() {
		for(int i=HEAD;i<TAIL;i++) {
			System.out.print(element[i]+" ,");
		}
	}
	
	void printPositions() {
		System.out.println("\nHEAD - "+HEAD+" TAIL - "+TAIL);
	}
	
	boolean isEmpty() {
		return HEAD>=TAIL;
	}
}

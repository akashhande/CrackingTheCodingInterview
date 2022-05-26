package org.ctci.Stack;

/**
 * Stack is Last In First Out (LIFO) data structure
 * Stack supports PUSH, POP, PEEK operations
 * This implementation is specifically for Integer data type i.e. stack of int
 */
public class StackInteger {
	static final int MAX = 50;
	int TOP;
	int[] element = new int[MAX];
	
	StackInteger() {
		TOP=-1;
	}
	
	/**
	 * 1. Check if Stack is full or not (TOP is > MAX)
	 * 2. If yes then print error for Stack overflow
	 * 3. If no increment TOP and add value to TOP position
	 * @return - NOTHING
	 */
	void push(int data){
		if(TOP>MAX-1) {
			System.out.println("ERROR : Stack is full"); //OR throw new StackOverflowError();
			return;
		}
		TOP++;
		element[TOP]=data;		
	}
	
	/**
	 * 1. Check if Stack empty or not (i.e. TOP=-1)
	 * 2. If Stack is empty then print underflow error
	 * 3. If Stack have elements then return TOP element and reduce TOP position
	 * @return element on top position
	 */
	int pop(){
		if(isEmpty()) {
			System.out.println("ERROR : Stack is empty");
			return TOP;
		}
		int output = element[TOP];
		TOP--;
		return output;
	}
	
	/**
	 * @return element pointing to TOP
	 */
	int peek() {
		System.out.println("Peek - "+element[TOP]);
		return element[TOP];
	}
	
	void printStackElement() {
		for (int i=0;i<=TOP;i++) {
			System.out.print(element[i]+" ");
		}
		System.out.println("\nTOP - "+TOP);
	}
	
	boolean isEmpty() {
		if(TOP>=0)
			return false;
		
		return true;
	}
	
	boolean isFull() {
		return TOP>MAX-1;
	}
}

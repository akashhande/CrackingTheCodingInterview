package org.ctci.Stack;

/**
 ***************************************** Problem statement ****************************************
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
 * (that is, pop () should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.
 * 
 */
public class Example3 {
	int[] array1;
	int[] array2;
	int TOP;
	int stackSize;
	
	Example3(){
		array1 = new int[5];
		array2 = new int[5];
		TOP = -1;
		stackSize = array1.length + array2.length;
	}
	
	boolean isEmpty() {
		return TOP == -1;
	}
	
	boolean isFull() {
		return TOP >= stackSize - 1;
	}
	
	void push(int data) {
		if(isFull()) {
			System.out.println("ERROR : Stack is full");
		}
		TOP++;
		getArray()[getTOPPointer()]=data;
	}
	
	int[] getArray() {
		if (TOP>array1.length-1)
			return array2;
		else
			return array1;
	}
	
	int getTOPPointer() {
		if(TOP>array1.length-1)
			return TOP-array1.length;
		else
			return TOP;
	}
	
	int pop() {
		if(isEmpty()) {
			System.out.println("ERROR : Stack underflow");
		}
		int output = getArray()[getTOPPointer()];
		TOP--;
		return output;
	}
	
	void printStackElement() {
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i]);
		}
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i]);
		}
		System.out.println("\nTOP - "+TOP);
	}
	
	public static void main(String[] args) {
		Example3 e3 = new Example3();
		e3.push(1);
		e3.push(2);
		e3.push(3);
		e3.push(4);
		e3.push(5);
		e3.push(6);
		e3.push(7);
		
		e3.printStackElement();
		
		e3.pop();
		e3.pop();
		e3.pop();
		e3.printStackElement();
	}

}

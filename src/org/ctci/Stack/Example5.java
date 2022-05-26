package org.ctci.Stack;

/**
 ***************************************** Problem statement ****************************************
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 * 
 */
public class Example5 {

	void sort(StackInteger main) {
		StackInteger support = new StackInteger();
		while(!main.isEmpty()) {
			int temp = main.pop();
			while(!support.isEmpty() && support.peek()>temp) {
				support.push(main.pop());
			}
			
		}
	}
	
	public static void main(String[] args) {
		Example5 e5 = new Example5();
		StackInteger stack = new StackInteger();
		stack.push(8);
		stack.push(12);
		stack.push(10);
		stack.push(7);
		stack.push(9);
		stack.printStackElement();
		
		e5.sort(stack);
	}
}

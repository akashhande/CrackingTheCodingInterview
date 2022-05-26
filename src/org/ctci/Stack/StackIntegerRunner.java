package org.ctci.Stack;

public class StackIntegerRunner {

	public static void main(String[] args) {
		StackInteger st = new StackInteger();
		System.out.println("Output - "+st.isEmpty());
		
		st.push(5);
		st.push(6);
		st.push(8);
		st.push(10);
		st.printStackElement();
		
		st.peek();
		
		System.out.println("Item popped - "+st.pop());
		st.peek();
	}
}

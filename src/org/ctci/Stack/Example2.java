package org.ctci.Stack;

/**
 ***************************************** Problem statement ****************************************
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * 
 */
public class Example2 {
	private static final int MAX=100;
	private static int TOP;
	int[] element;
	int[] minElement;
	int min;
	
	Example2() {
		TOP=-1;
		element = new int[MAX];
		minElement = new int[MAX];
		min=Integer.MAX_VALUE;
	}
	
	void push(int data) {
		if(isFull())
			System.out.println("ERROR : Stack is full");
		else {
			TOP++;
			element[TOP]=data;
			
			if(data<min) {
				minElement[TOP]=data;
				min=data;
			} else
				minElement[TOP]=min;
		}
	}
	
	int popMin() {
		return minElement[TOP];
	}
	
	int pop() {
		if(isEmpty()) {
			System.out.println("ERROR : Stack is empty");
			return -1;
		} else {
			int output = element[TOP];
			TOP--;
			return output;
		}
	}
	
	boolean isEmpty() {
		return TOP<0;
	}
	
	boolean isFull() {
		return TOP>MAX-1;
	}
	
	void print() {
		for (int i = 0; i <= TOP; i++) {
			System.out.print(element[i]);
		}
	}
	
	public static void main(String[] args) {
		Example2 e2 = new Example2();
		e2.push(6);
		e2.push(2);
		e2.push(1);
		e2.push(4);
		e2.push(5);
		e2.push(0);
		e2.print();
		System.out.println("\nMinimum - "+e2.popMin());
		
		e2.pop();
		e2.pop();
		e2.pop();
		e2.pop();
		e2.print();
		System.out.println("\nMinimum - "+e2.popMin());
	}

}

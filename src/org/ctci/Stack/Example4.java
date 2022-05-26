package org.ctci.Stack;

/**
 ***************************************** Problem statement ****************************************
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 * 
 */
public class Example4 {
	StackInteger s1, s2;
	int HEAD, TAIL=0;
	
	Example4(){
		s1=new StackInteger();
		s2=new StackInteger();
	}
	
	int dequeue() {
		return s1.pop();
	}
	
	void enQueue(int data) {
		if(s1.isEmpty()) 
			s1.push(data);
		else {
			shiftData(s1, s2);
			s1.push(data);
			shiftData(s2, s1);
		}
	}
	
	int deQueue() {
		if (s1.isEmpty()) {
			System.out.println("ERROR : Queue is empty");
			System.exit(0);
		}
		return s1.pop();
	}
	
	
	void shiftData(StackInteger s1, StackInteger s2) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
	}
	
	void printQueue() {
		s1.printStackElement();
	}
	
	public static void main(String[] args) {
		Example4 e4 = new Example4();
		e4.enQueue(1);
		e4.enQueue(2);
		e4.enQueue(3);
		e4.enQueue(4);
		e4.enQueue(5);
		e4.printQueue();
		
		e4.dequeue();
		e4.dequeue();
		e4.printQueue();
	}

}

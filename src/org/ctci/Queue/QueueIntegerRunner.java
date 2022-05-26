package org.ctci.Queue;

public class QueueIntegerRunner {

	public static void main(String[] args) {
		QueueInteger qi = new QueueInteger();
		System.out.println("isEmpty() - "+qi.isEmpty());
		qi.printPositions();
		
		qi.enqueue(5);
		qi.enqueue(6);
		qi.enqueue(7);
		qi.enqueue(10);
		qi.printQueue();
		qi.printPositions();
		
		System.out.println("Element DEQUEUED - "+qi.dequeue());
		System.out.println("Element DEQUEUED - "+qi.dequeue());
		qi.printPositions();
		qi.printQueue();
	}

}

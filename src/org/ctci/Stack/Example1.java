package org.ctci.Stack;

/**
 ***************************************** Problem statement ****************************************
 * Three in One: Describe how you could use a single array to implement three stacks.
 * 
 */
public class Example1 {
	private static final int CAPACITY = 100;
	private static final int NO_OF_STACKS = 3;
	private static final int TOP1=-1;
	private static final int TOP2=(CAPACITY/NO_OF_STACKS)-1;
	private static final int TOP3=(CAPACITY/NO_OF_STACKS)*2-1;
	private int[] element; 
	private int[] pointer;
	Example1() {
		element = new int[CAPACITY];
		pointer = new int[]{TOP1, TOP2, TOP3};
	}
	
	boolean isEmpty(int stackNumber) {
		if(stackNumber!=1 || stackNumber!=2 || stackNumber!=3)
			return false;
		
		return true;			
	}
	
	public static void main(String[] args) {
		Example1 ex = new Example1();
		

	}

}

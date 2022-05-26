package org.ctci.MS;

import static org.junit.Assert.*;

import org.junit.Test;

public class Example1 {

	    public int solution(int[] A) {
	       int result = 0;
	       for (int i=1; i<A.length; i++){
	            result += Math.max(0, A[i-1] - A[i]);
	       }
	            
	        return result + A[A.length-1];
	    }
	
	
	@Test
	public void test() {
		int[] obj = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
		assertEquals(9, solution(obj));
	}
}

package org.ctci.Meta;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 *
 * Reverse to Make Equal
 * Given two arrays A and B of length N, 
 * determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
 *
 */
public class Example4 {
	
	/**
	 * 1. Sort the arrays
	 * 2. compare arrays
	 */
	boolean areTheyEqual(int[] array_a, int[] array_b) {
		if(array_a.length!=array_b.length)
			return false;
		
		Arrays.sort(array_a);
		Arrays.sort(array_b);
		return Arrays.equals(array_a, array_b);
	}
	
	
	
	@Test
	public void testRotationalCipher() {
		int[] input1 = {1, 2, 3, 4};
		int[] input2 = {1, 4, 3, 2};
		assertEquals(true, areTheyEqual(input1, input2));  
	}
}

package org.ctci.Meta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * Pair Sums
 * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
 * If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered 
 * different if one pair includes at least one array index which the other doesn't, even if they include the same values.
 * 
 * Example 1
 * 		n = 5
 * 		k = 6
 * 		arr = [1, 2, 3, 4, 3]
 * 		output = 2
 * 		The valid pairs are 2+4 and 3+3.
 * 
 * Example 2
 * 		n = 5
 * 		k = 6
 * 		arr = [1, 5, 3, 3, 3]
 * 		output = 4
 * 		There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).
 */
public class Example3 {
	
	// 1. Iterate through array
	// 2. Get the current element, substract it from k i.e. total, 
	//			find the number from array skipping current index
	//			find from current index to last element
	// 3. Whenever we find number increment count
	int numberOfWays(int[] arr, int k) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int numberToFind = k - arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j]==numberToFind) 
					count++;
				
			}
		}
		return count;
	}
	
	@Test
	public void testRotationalCipher() {
		int[] input1 = {1, 2, 3, 4, 3};
		int[] input2 = {1, 5, 3, 3, 3};
		assertEquals(2, numberOfWays(input1, 6));  
		assertEquals(4, numberOfWays(input2, 6));
	}
	 
}

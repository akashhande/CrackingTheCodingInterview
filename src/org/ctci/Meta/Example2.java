package org.ctci.Meta;

import org.junit.Assert;
import org.junit.Test;

/**
 * Contiguous Subarrays
 * You are given an array arr of N integers. 
 * For each index i, you are required to determine the number of contiguous subarrays that fulfill the following conditions:
 * 	1. The value at index i must be the maximum element in the contiguous subarrays, and
 *	2. These contiguous subarrays must either start from or end on index i.
 * 
 * Example:
 * 		arr = [3, 4, 1, 6, 2]
 * 		output = [1, 3, 1, 5, 1]
 * 		
 * 		3, 4, 1, 6, 2
 * 		i
 * 		j
 * 
 * Explanation:
 * For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
 * For index 1 - [4], [3, 4], [4, 1]
 * For index 2 - [1]
 * For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 * For index 4 - [2]
 * So, the answer for the above input is [1, 3, 1, 5, 1]
 */


public class Example2 {
	
	 int[] countSubarrays(int[] arr) {
		 
		 int[] output = new int[arr.length];
		 
		 for (int i = 0; i < arr.length; i++) {
			int count = 1;
			int left = i-1;
			int right = i+1;
			// check for left side
			while (left>=0 && arr[i]>arr[left]) {
				count++;
				left--;
			}
			
			// check for right side
			while (right<arr.length && arr[i]>arr[right]) {
				count++;
				right++;
			}
			
			
			output[i] = count;
		}
		 return output;
	 }

	
	@Test
	public void testCountSubarrays() {
		int[] input = {3, 4, 1, 6, 2};
		int[] output = {1, 3, 1, 5, 1};
		Assert.assertArrayEquals(output, countSubarrays(input));  
	}
}

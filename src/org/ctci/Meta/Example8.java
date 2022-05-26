package org.ctci.Meta;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Reverse Operations
 * You are given a Array that contains N integers. A subpart of the array is a contiguous set of even elements, 
 * bordered either by either end of the array or an odd element. 
 * For example, if the array is [1, 2, 8, 9, 12, 16], the subparts of the array are [2, 8] and [12, 16].
 * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
 * The goal of this question is: given a resulting array, determine the original order of the elements.
 *
 */
public class Example8 {

	/**
	 * 1, 2, 8, 9, 12, 16 
	 *          ^
	 * pointer = 2
	 * tempArray = 2, 8
	 *                  
	 * 1. Iterate through the array
	 * 2. Check element is odd or even
	 * 3. If it is odd add to outputArray
	 * 3. If it is even 
	 * 4. Reverse the sub array 
	 * 5. Add the reversed sub array to output Linked list
	 * @return 
	 */
	int[] reverse(int[] inputArray) {
		int[] tempArray = new int[inputArray.length];
		int[] outputArray = new int[inputArray.length];
		int tempArrayPointer = 0, outputArrayPointer = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i]%2==0) {
				tempArray[tempArrayPointer]=inputArray[i];
				tempArrayPointer++;
			} else if (inputArray[i]%2!=0 || i == inputArray.length-1) {
				if (tempArrayPointer>0) {
					for (int j = tempArray.length-1; j >= 0; j--) {
						if(tempArray[j]!=0) {
							outputArray[outputArrayPointer]=tempArray[j];
							outputArrayPointer++;
						}
					}
				}
				outputArray[outputArrayPointer]=inputArray[i];
				outputArrayPointer++;
			}
		}
		
		return outputArray;	
	}
		

	@Test
	public void testGetMilestoneDaysr() {
		int[] arr_1 = { 1, 2, 8, 9, 12, 16 };
		int[] expected1 = { 1, 8, 2, 9, 16, 12 };
	    Assert.assertArrayEquals(expected1, reverse(arr_1));
	    
	    int[] arr_2 = { 2, 18, 24, 3, 5, 7, 9, 6, 12 };
		int[] expected2 = { 24, 18, 2, 3, 5, 7, 9, 12, 6 };
	    Assert.assertArrayEquals(expected2, reverse(arr_2));
	}

}
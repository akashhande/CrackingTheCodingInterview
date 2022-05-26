package org.ctci.Meta;

import org.junit.Assert;
import org.junit.Test;

/**
 * Revenue Milestones
 * We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue milestones. 
 * Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an array containing the days 
 * on which Facebook reached every milestone.
 *
 *		Example
 *			revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
 *			milestones = [100, 200, 500]
 *			output = [4, 6, 10]
 *		Explanation
 *			On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively. 
 *			Day 6 is the first time that FB has >= $200 of total revenue.
 */

public class Example6 {
	
	
	
	// 100, 200, 300, 400, 500 	revenues
	//                 i
	// 300, 800, 1000, 1400	milestones
	// 	     P
	
	// milestoneCount=1000
	// [2, 4, 4]

	int[] getMilestoneDays(int[] revenues, int[] milestones) {
		int[] output = new int[milestones.length];
		int milestoneCount=0, milestonePointer=0;
		
		for (int i = 0; i < revenues.length; i++) {
			milestoneCount+=revenues[i];
			if(milestoneCount>=milestones[milestonePointer]) {
				output[milestonePointer]=i+1;
				milestonePointer++;
			}
		}
		return output;
	}

	@Test
	public void testGetMilestoneDaysr() {
		int[] revenues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int[] milestones = {100, 200, 500};
		int[] output = {4, 6, 10};
		Assert.assertArrayEquals(output, getMilestoneDays(revenues, milestones));
		
		
		int revenues_1[] = {100, 200, 300, 400, 500};
	    int milestones_1[] = {300, 800, 1000, 1400};
	    int expected_1[] = {2, 4, 4, 5};
	    int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
	    Assert.assertArrayEquals(output_1, getMilestoneDays(revenues, milestones));
	    
	    int revenues_2[] = {700, 800, 600, 400, 600, 700};
	    int milestones_2[] = {3100, 2200, 800, 2100, 1000};
	    int expected_2[] = {5, 4, 2, 3, 2};
	    int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
	    Assert.assertArrayEquals(output_2, getMilestoneDays(revenues, milestones));
	}
}

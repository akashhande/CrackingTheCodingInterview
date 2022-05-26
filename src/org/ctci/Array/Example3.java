package org.ctci.Array;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 ***************************************** Problem statement ****************************************
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * 
 * 					EXAMPLE
 *  					Input: "Mr John Smith ", 13
 *  					Output: "Mr%20John%20Smith"
 *  
 *  					Input: "Mr John  Smith ", 14
 *  					Output: "Mr%20John%20%20Smith
 */
public class Example3 {
	
	
	char[] URLify(String str, int trueLength) {
		int spaceCount = 0, index = 0;
		for (int i = 0; i < trueLength; i++) {
			if (str.charAt(i) == ' ')
				spaceCount++;
		}
		
		char[] inputArray = str.toCharArray();
		index = (spaceCount*2) + trueLength;
		char[] outputArray = new char[index];
		
		for (int i = trueLength-1; i >= 0; i--) {
			if (inputArray[i] == ' ') {
				outputArray[index-1] = '0';
				outputArray[index-2] = '2';
				outputArray[index-3] = '%';
				index = index-3;
			} else {
				outputArray[index-1] = inputArray[i];
				index--;
			}
		}
		
		System.out.println("out -" + outputArray.toString());
		return outputArray;		
	}

	@Test
	public void test() {
		char[] obj = {'M', 'r', '%', '2', '0', 'J', 'o', 'h', 'n', '%', '2', '0', 'S', 'm', 'i', 't', 'h'};
		assertArrayEquals(obj, URLify("Mr John Smith ", 13));
	}

}

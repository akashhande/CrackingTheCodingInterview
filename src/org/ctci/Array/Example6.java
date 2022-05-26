package org.ctci.Array;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 *
 */
public class Example6 {

/**
*	aabcccccaaa 
*	^
*	1. Scan through the string using for loop
*	2. 2 temporary variables one for character and one for count/occurance
*	3. if statement to check current character is same as next one -> yes increment the counter
*	4. No -> append temporary character and count to outputString 
*	5. compare outputString with inputString 
*	6. Return longer string
*/

	static String stringCompare(String inputString){
		int temporaryCount = 0;
		String outputString = "";
		
			for(int i=0; i<inputString.length(); i++){
				temporaryCount++;
				if(i+1 >= inputString.length() || inputString.charAt(i)!=inputString.charAt(i+1)){
					outputString += "" + inputString.charAt(i) + temporaryCount;
					temporaryCount = 0;
				}
			}
			
			return inputString.length() > outputString.length() ? outputString : inputString;
	}
	
	
	@Test
	public void test() {
		assertEquals("a2b1c5a3", stringCompare("aabcccccaaa"));
	}

}

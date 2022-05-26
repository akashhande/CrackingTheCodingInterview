package org.ctci.Array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 **************************************** Problem statement ****************************************
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 * 
 */

public class Example2 {
	
	
	static boolean isPermutation(String str1, String str2){
		if(str1.length() != str2.length())
			return false;
		
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		for (int i = 0; i < charArray1.length; i++) {
			if(charArray1[i] != charArray2[i])
				return false;
		}
		return true;
	}
	
	@Test
	public void testIsPermutation(){
		assertEquals(true, isPermutation("cracking", "gccrakni"));
		assertEquals(true, isPermutation("aeiou", "uioea"));
		
		assertNotEquals(true, isPermutation("cracking", "gacrakni"));
		assertNotEquals(true, isPermutation("test", "abcd"));
	}

}

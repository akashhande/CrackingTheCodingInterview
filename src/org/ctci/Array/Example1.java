package org.ctci.Array;

/**
 **************************************** Problem statement ****************************************
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import org.junit.Test;

public class Example1 {

	/**
	 * This solution is implemented by using primary data structure
	 * Considering string contains ASCII characters 
	 * ASCII table have 128 characters 
	 */
	static boolean isUniqueCharactersArray(String str) {
		boolean[] charArray = new boolean[128];
		
		if(str.length() > 128)
			return false;
		
		for (int i = 0; i < str.length(); i++) {
			int character = str.charAt(i);
			
			if(charArray[character])
				return false;
			else
				charArray[character] = true;
		}
		return true;
	}
	
	/**
	 * This solution is implemented by HashMap data structure
	 * Considering key have character and value has count of occurrence
	 */
	static boolean isUniqueCharactersHashmap(String str) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			if(hm.get(str.charAt(i)) == null)
				hm.put(str.charAt(i), 1);
			else
				return false;
		}
		return true;
	}
	
	/**
	 * This solution is implemented by character array 
	 * Considering interviewer permitted to use Arrays class
	 */
	static boolean isUniqueCharactersSort(String str) {
		char[] inputString = str.toCharArray();
		Arrays.sort(inputString);
		for (int i = 0; i < inputString.length-1; i++) {
			if(inputString[i]==inputString[i+1])
				return false;
		}
		
		return true;
	}

	@Test
	public void testIsUniqueCharactersArray() {
		assertEquals(false, isUniqueCharactersArray("cracking"));  
		assertEquals(false, isUniqueCharactersArray("akash"));
		assertEquals(true, isUniqueCharactersArray("abcd"));
	}
	
	@Test
	public void testIsUniqueCharactersHashmap() {		
		assertEquals(false, isUniqueCharactersHashmap("cracking"));  
		assertEquals(false, isUniqueCharactersHashmap("akash"));
		assertEquals(true, isUniqueCharactersHashmap("abcd"));
	}

	@Test
	public void testIsUniqueCharactersSort() {
		assertEquals(false, isUniqueCharactersSort("cracking"));  
		assertEquals(false, isUniqueCharactersSort("akash"));
		assertEquals(true, isUniqueCharactersSort("abcd"));
	}
}

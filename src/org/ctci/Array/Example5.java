package org.ctci.Array;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * 		EXAMPLE
 *  		pale, ple -> true
 *  		pales, pale -> true
 *  		pale, bale -> true
 *  		pale, bake -> false
 */

public class Example5 {
	static int maxLength = 0;
	static int minLength = 0;
	static boolean differenceFound = false;
	
	static boolean isOneAway(String str1, String str2) {
		int str1Length = str1.length(), str2Length = str2.length();
		maxLength = Math.max(str1Length, str2Length);
		minLength = Math.min(str1Length, str2Length);
		
		if (maxLength == minLength) {
			return isChanged(str1, str2);
		} else if(maxLength != minLength && maxLength-minLength == 1) {
			return isChanged(str1, str2);
		} else 
			return false;
	}
	
	private static boolean isChanged(String str1, String str2) {
		for (int i = 0; i < minLength; i++) {
			if(str1.charAt(i) != str2.charAt(i) && !differenceFound)
				differenceFound = true;
		}
		return true;
	}

	@Test
	public void testReplaced() {
		assertEquals(true, isOneAway("aba", "abc"));
		assertEquals(true, isOneAway("abcd", "abc"));
		assertEquals(true, isOneAway("pale", "bale"));
		assertEquals(true, isOneAway("pale", "bake"));
	}
	
	@Test
	public void testChanged() {
		assertEquals(true, isOneAway("abcd", "abc"));
		assertEquals(true, isOneAway("pale", "ple"));
		assertEquals(true, isOneAway("pales", "pale"));
	}

}

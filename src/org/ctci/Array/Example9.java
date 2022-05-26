package org.ctci.Array;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * String Rotation:Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 *
 */

public class Example9 {
	
	static boolean stringRotation(String str1, String str2) {
		String str = str1 + str2;
		return str.contains(str2);
	}
	
	@Test
	public void test() {
		assertEquals(true, stringRotation("waterbottle", "erbottlewat"));
	}

}

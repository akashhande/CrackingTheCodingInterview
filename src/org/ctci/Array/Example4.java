package org.ctci.Array;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 ***************************************** Problem statement ****************************************
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * 				EXAMPLE
 *  				Input: Tact Coa
 *  				Output: True (permutations: "taco cat", "atco eta", etc.)
 */

public class Example4 {

	static boolean isPalindromePermutation(String str) {
		int[] inputString = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		for (int i = 0; i < str.length(); i++) {
			int tempCharValue = Character.getNumericValue(str.charAt(i));
			if (tempCharValue>=a && tempCharValue<=z) {
				int index = tempCharValue - a;
				inputString[index]++;
			}
		}
		
		return isPalindrome(inputString);
	}
	
	private static boolean isPalindrome(int[] inputString) {
		boolean flag = false;
		for (int i = 0; i < inputString.length; i++) {
			if(inputString[i]%2!=0 && flag)
				return false;
			else if(inputString[i]%2==1 && !flag)
				flag = true;
		}
		return true;
	}

	@Test
	public void test() {
		assertEquals(false, isPalindromePermutation("abaca"));
		assertEquals(true, isPalindromePermutation("aba"));
		assertEquals(true, isPalindromePermutation("abaaab"));
		assertEquals(true, isPalindromePermutation("taco cat"));
	}

}

package org.ctci.Meta;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Matching Pairs
 * Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
 * A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. 
 * The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
 * Note: This means you must swap two characters at different indices.
 *
 *	Example 1
 *		s = "abcd"
 *		t = "adcb"
 *			output = 4
 *		Explanation:
 *			Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
 *			Therefore, the number of matching pairs of s and t will be 4.
 *
 *	Example 2
 *		s = "mno"
 *		t = "mno"
 *			output = 1
 *		Explanation:
 *			Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. 
 *			If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.
 *
 */
public class Example5 {

	// 1. Check length of both string is equal or not - if not return 0
	// 2. Check matching pairs in both input strings
	// 3. Check both strings have same characters - count of same characters
	// 4. Compare the characters in the string - if we get 0 return it
	// 5. swap = sameChar - matching 
	// 6. if swap is greater than 0 && 2's compliment then increase count by 2
	// 7. if swap is equals to 0 then decrease count by 2
	
	
	// 			 	abcd			mno				abcd
	//    		 	adcb			mno				efgh
	
	// length   	  4		  		 3				  4
	// matching 	  2				 3			      0
	// same char	  4				 3				  0	
	// swap			  2				 0
	
	
	int matchingPairs(String s, String t) {
		if (s.length()!=t.length()) 
			return 0;
		
		int matchingPairs = getMatchingPairs(s, t);
		int sameCharacters = getSameCharacters(s, t);
		int swap = sameCharacters - matchingPairs;
		if (swap>0 && swap%2==0) 
			return matchingPairs+2;
		else if(swap==0)
			return matchingPairs-2;
		else
			return 0;
	}
	
	int getSameCharacters(String s, String t) {
		char[] s_char = s.toCharArray();
		char[] t_char = t.toCharArray();
		Arrays.sort(s_char);
		Arrays.sort(t_char);
		int count = 0;
		for (int i = 0; i < s_char.length; i++) {
			if (s_char[i]==t_char[i]) 
				count++;
		}
		return count;
	}

	int getMatchingPairs(String s, String t) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)==t.charAt(i)) 
				count++;
		}
		return count;
	}
	
	
	@Test
	public void testRotationalCipher() {
		assertEquals(4, matchingPairs("abcd", "adcb"));
		assertEquals(1, matchingPairs("mno", "mno"));
	}
}

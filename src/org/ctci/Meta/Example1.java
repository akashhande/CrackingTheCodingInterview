package org.ctci.Meta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Rotational Cipher
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. 
 * Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
 * 
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". 
 * Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), 
 * and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). 
 * Note that the non-alphanumeric characters remain unchanged. Given a string and a rotation factor, return an encrypted string.
 * 
 * Example 1
 * 		input = Zebra-493?
 * 		rotationFactor = 3
 * 		output = Cheud-726?
 * 
 * Example 2
 * 		input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * 		rotationFactor = 39
 * 		output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */
public class Example1 {
	
	/**
	 * Assumptions / facts
	 * 1. input contains lower case and upper case
	 * 2. special characters - do not rotate
	 * 3. 
	 * 
	 * Letter - Upper case and lower case
	 * Number - increment
	 * Special character - no change
	 * 
	 */
	String rotationalCipher(String input, int rotationFactor) {
		StringBuffer output = new StringBuffer();
	    for (int i = 0; i < input.length(); i++) {
	    	char c = 0;
	    	if (Character.isLetter(input.charAt(i)) && Character.isUpperCase(input.charAt(i))) 
	    		c = (char)(((int)input.charAt(i) + rotationFactor - 65) % 26 + 65);
	    	else if (Character.isLetter(input.charAt(i)) && Character.isLowerCase(input.charAt(i)))
	    		c = (char)(((int)input.charAt(i) + rotationFactor - 97) % 26 + 97);
	    	else if (Character.isDigit(input.charAt(i)))
	    		c = (char)(((int)input.charAt(i) + rotationFactor - 48) % 10 + 48);
	    	else
	    		c = input.charAt(i);
			
			output.append(c);
		}
	    return output.toString();
	}
	
	
	@Test
	public void testRotationalCipher() {
		assertEquals("dnDvk", rotationalCipher("akAsh", 3));  
		assertEquals("dnDvk-", rotationalCipher("akAsh-", 3));
		assertEquals("Cheud-726?", rotationalCipher("Zebra-493?", 3));  
		assertEquals("nopqrstuvwxyzABCDEFGHIJKLM9012345678", rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
	}
}

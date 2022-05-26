package org.ctci.Amazon;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class Example1 {

	public static int getMinMoves(List<Integer> plates) {
		int max = plates.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
		int min = plates.stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new);
		int minMoves=0, minPosition=0, maxPosition=0;
		int[] platesArrayMinimum = plates.stream().mapToInt(i->i).toArray();
		int[] platesArrayMaximum = plates.stream().mapToInt(i->i).toArray();
		
		for (int i = 0; i < platesArrayMinimum.length; i++) {
			if(platesArrayMinimum[i]==min)
				minPosition=i;
			if(platesArrayMinimum[i]==max)
				maxPosition=i;
		}
		if (platesArrayMinimum[0]!=min) {
			while (minPosition!=0) {
				int temp = platesArrayMinimum[minPosition];
				platesArrayMinimum[minPosition]=platesArrayMinimum[minPosition-1];
				platesArrayMinimum[minPosition-1]=temp;
				minPosition--;
				minMoves++;
			}
		}
		
		if (platesArrayMaximum[platesArrayMaximum.length-1]!=max) {
			while (maxPosition!=platesArrayMaximum[platesArrayMaximum.length-1]) {
				int temp = platesArrayMaximum[maxPosition];
				platesArrayMaximum[maxPosition]=platesArrayMaximum[maxPosition+1];
				platesArrayMaximum[maxPosition+1]=temp;
				maxPosition++;
				minMoves++;
			}
		}
		return minMoves;
	}


	@Test
	public void testRotationalCipher() {

		List<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(2);
		input.add(4);
		input.add(3);
		input.add(1);
		assertEquals(6, getMinMoves(input));

		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(3);
		input1.add(2);
		input1.add(1);
		assertEquals(3, getMinMoves(input1));
	}

}

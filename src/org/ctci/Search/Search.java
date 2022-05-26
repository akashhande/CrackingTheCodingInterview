package org.ctci.Search;

public class Search {
	
	static int[] element = {1, 2, 3, 4, 6, 8, 9, 10, 11, 12};
	
	static int linearSearch(int data) {
		for (int i = 0; i < element.length; i++) {
			if (data==element[i]) 
				return i;
		}
		return -1;
	}
	
	static int binarySearch(int first, int last, int data) {
		int middle=first+last/2;
		
		while(last>=first) {
			if(element[middle]==data) 
				return middle;
			if(element[middle]<data) 
				return binarySearch(middle+1, last, data);
			if(element[middle]>data) 
				return binarySearch(first, middle-1, data);
		}
		
		return -1;		
	}

	public static void main(String[] args) {
		int elementPresent = 4;
		int elementNotPresent = 5;
		System.out.print("\nSearching element - "+elementPresent+" position - "+linearSearch(elementPresent));
		System.out.print("\nSearching element - "+elementNotPresent+" position - "+linearSearch(elementNotPresent));
		
		System.out.print("\nSearching element - "+elementPresent+" position - "+binarySearch(0, element.length, elementPresent));
		System.out.print("\nSearching element - "+elementNotPresent+" position - "+binarySearch(0, element.length, elementNotPresent));
	}
}

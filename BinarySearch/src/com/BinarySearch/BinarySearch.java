package com.BinarySearch;

import java.util.Arrays;

// Binary Search Algorithm recursive and iterative implementations for Sorted Arrays 

public class BinarySearch {

	// BinarySearchRecusive method - user will call for performing a Binary Search recursively on an sorted array
	public static boolean binarySearchRecursive(int[] array, int value) {
		return binarySearchRecursive(array, value, 0, array.length -1);
	}
	
	
	// BinarySearchRecursive Helper method
	private static boolean binarySearchRecursive(int[] array, int value, int left, int right) {
		
		// base case: if the left index is > right, then err i.e. can't find value searching for
		if( left > right) {
			return false;
		}
		
		int middle = left + ((right-left) / 2); // (left+right)/2 would not prevent overflow
		
		if(array[middle] == value) {
			return true;
		} else if (value < array[middle]) {
			return binarySearchRecursive(array, value, left, middle - 1);
		} else {
			return binarySearchRecursive(array, value, middle + 1, right);
		}
	}
	
	
	// BinarySearchIterative  method - user will call for performing a Binary Search iteratively on an sorted array
	public static boolean binarySearchIterative(int[] array, int value) {
		
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right) {
			
			int middle = left + ((right-left) / 2); // (left+right)/2 would not prevent overflow
			
			if(array[middle] == value) {
				return true;
			} else if (value < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {4, 11, 14, 6, 55, 22, 31, 25, 86, 42, 45, 17, 2, 81};
		
		Arrays.sort(arr);
		
		System.out.println("Array: " + Arrays.toString(arr));
		
		// values to search for in various points in array
		int valueToSearchOne = 45;
		int valueToSearchTwo = 2;
		int valueToSearchThree = 86;
		int valueToSearchFour = 52;
		
		// BinarySearchRecursive test
		System.out.println("(Recursive) Does the array contain '" + valueToSearchOne + "': " + binarySearchRecursive(arr, valueToSearchOne));
		System.out.println("(Recursive) Does the array contain '" + valueToSearchTwo + "': " + binarySearchRecursive(arr, valueToSearchTwo));
		System.out.println("(Recursive) Does the array contain '" + valueToSearchThree + "': " + binarySearchRecursive(arr, valueToSearchThree));
		System.out.println("(Recursive) Does the array contain '" + valueToSearchFour + "': " + binarySearchRecursive(arr, valueToSearchFour));
		
		System.out.println();
		
		// BinarySearchRecursive test
		System.out.println("(Iterative) Does the array contain '" + valueToSearchOne + "': " + binarySearchIterative(arr, valueToSearchOne));
		System.out.println("(Iterative) Does the array contain '" + valueToSearchTwo + "': " + binarySearchIterative(arr, valueToSearchTwo));
		System.out.println("(Iterative) Does the array contain '" + valueToSearchThree + "': " + binarySearchIterative(arr, valueToSearchThree));
		System.out.println("(Iterative) Does the array contain '" + valueToSearchFour + "': " + binarySearchIterative(arr, valueToSearchFour));
		
		

	}

}



/*

Array: [2, 4, 6, 11, 14, 17, 22, 25, 31, 42, 45, 55, 81, 86]
(Recursive) Does the array contain '45': true
(Recursive) Does the array contain '2': true
(Recursive) Does the array contain '86': true
(Recursive) Does the array contain '52': false

(Iterative) Does the array contain '45': true
(Iterative) Does the array contain '2': true
(Iterative) Does the array contain '86': true
(Iterative) Does the array contain '52': false


*/




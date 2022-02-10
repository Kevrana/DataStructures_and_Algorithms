package com.LinearSearch;

import java.util.Arrays;

// Linear Search Implementation on Array

public class LinearSearch {
	
	public static int linearSearch(int[] arr, int valueToFind) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == valueToFind)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		
		int[] arr = {4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81};
		int value = 31;
		
		System.out.println("Array: " + Arrays.toString(arr));

		int res = linearSearch(arr, value);
		
		if(res == -1)
			System.out.println("Element not found in array");
		else 
			System.out.println("Element found in array at index: " + res);
		
		

	}

}

package com.InsertionSort;

import java.util.Arrays;

// Insertion Sort implementation
public class InsertionSort {
	
	
	public static void insertionSort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			
			int key = arr[i]; // temp for current item
			int j = i-1; // predecessor
			
			// while predecessor is > than key,
			// shift up larger elements one position 
			// to make space for key's sorted placement
			while((j >= 0) && (arr[j] > key)) {
				arr[j+1] = arr[j];
				j-=1;
			}
			arr[j+1] = key;
		}
		
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81};
		
		System.out.println("Array before Insertion Sort: " + Arrays.toString(arr));
		
		insertionSort(arr);
		
		System.out.println("Array after Insertion Sort: " + Arrays.toString(arr));
		

	}

}


/*
Array before Insertion Sort: [4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81]
Array after Insertion Sort: [-25, -17, -2, 4, 6, 11, 14, 22, 31, 42, 45, 55, 81, 86]
*/
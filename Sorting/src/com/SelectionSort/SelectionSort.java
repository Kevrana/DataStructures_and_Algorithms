package com.SelectionSort;

import java.util.Arrays;

public class SelectionSort {
	
	
	public static void selectionSort(int[] arr) {
		
		int n = arr.length;
		
		
		// each iteration will slide window for unsorted array partition
		// as the min element of that iteration moves to the front
		// which is the sorted sub-array partition of the entire array
		for(int i = 0; i < n-1; i++) {
			
			// find the current min index of the unsorted array
			int minIdx = i;
			for(int j = i+1; j < n; j++) {
				if(arr[j] < arr[minIdx])
					minIdx = j;
			}
			
			// then swap the min index with the first element of the unsorted array partition 
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81};
		
		System.out.println("Array before Selection Sort: " + Arrays.toString(arr));
		
		selectionSort(arr);
		
		System.out.println("Array after Selection Sort: " + Arrays.toString(arr));

	}

}


/* 

Array before Selection Sort: [4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81]
Array after Selection Sort: [-25, -17, -2, 4, 6, 11, 14, 22, 31, 42, 45, 55, 81, 86]

*/
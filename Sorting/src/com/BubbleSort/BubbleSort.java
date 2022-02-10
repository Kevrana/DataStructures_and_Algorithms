package com.BubbleSort;

import java.util.Arrays;

// Bubble sort implementation in Ascending Order
public class BubbleSort {
	
	public static void bubbleSort(int[] arr) {
		
		int n = arr.length;
		
		// loop to check each element in array
		for(int i = 0; i < n-1; i++) {
			
			// loop through the unsorted array partition
			for(int j = 0; j < n-i-1; j++) {
				
				// swap the adjacent elements if not in sorted ascending order
				// (for descending order, make it <)
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}

			}
		}
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81};
		
		System.out.println("Array before Bubble Sort: " + Arrays.toString(arr));
		
		bubbleSort(arr);
		
		System.out.println("Array after Bubble Sort: " + Arrays.toString(arr));
		
	}

}

/*

Array before Bubble Sort: [4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81]
Array after Bubble Sort: [-25, -17, -2, 4, 6, 11, 14, 22, 31, 42, 45, 55, 81, 86]


*/

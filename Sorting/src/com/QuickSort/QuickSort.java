package com.QuickSort;

import java.util.Arrays;

// Quick Sort Implementation

public class QuickSort {
	
	// user will call this method which calls the recursive method with the array and range passed in
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	
	private static void quickSort(int[] arr, int left, int right) {
		
		//base case: cannot divide any further as there is just one element, which is sorted
		// or out of bounds
		if(left >= right) {
			return;
		}
		
		// make pivot the middle of the array (calculates middle's index using integer overflow formula)
		int pivot = arr[left + ((right - left) / 2)];
		
		// partition returns the dividing point from left and right side of array
		int index = partition(arr, left, right, pivot);
		
		// sort the left and right partitions
		quickSort(arr, left, index - 1);
		quickSort(arr, index, right);
	}
	
	private static int partition(int[] arr, int left, int right, int pivot) {
		
		// converge left and right towards each other
		while(left <= right) {
			
			// will stop once it finds an element on left that is > than pivot
			while(arr[left] < pivot) {
				left++;
			}
			
			// will stop once it finds an element on right that is < than pivot
			while(arr[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		
		// return back the dividing point of the partitions
		return left;
		
	}
	
	// helper method to swap 2 indices of an array
	public static void swap(int[] arr, int leftIndex, int rightIndex) {
		int temp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = temp;
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81};
		
		System.out.println("Array before Quick Sort: " + Arrays.toString(arr));
		
		quickSort(arr);
		
		System.out.println("Array after Quick Sort: " + Arrays.toString(arr));

	}
}

/*

Array before Quick Sort: [4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81]
Array after Quick Sort: [-25, -17, -2, 4, 6, 11, 14, 22, 31, 42, 45, 55, 81, 86]


 */




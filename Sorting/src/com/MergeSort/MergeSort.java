package com.MergeSort;

import java.util.Arrays;

// Merge Sort implementation 
// (not in-place sorting as we need a temp array to merge sorted sub-arrays)
public class MergeSort {
	
	// method that user will call that will make a call to the recursive mergesort method
	// and will pass in the temp array to store the sorted array elements
	public static void mergeSort(int[] arr) {
		mergeSort(arr, new int[arr.length], 0, arr.length-1);
	}
	
	// Recursive  method of mergeSort
	private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		
		// base case - we can't divide the array any further, meaning its down to a single element
		// which is sorted, so we begin to merge the sorted halves back up
		if(leftStart >= rightEnd) {
			return;
		}
		
		// where we will divide the array from (calculates this way to avoid integer overflow)
		int middle = leftStart + ((rightEnd - leftStart) / 2);
		
		// sort left half of array recursively
		mergeSort(arr, temp, leftStart, middle);
		// sort right half of array recursively
		mergeSort(arr, temp, middle + 1, rightEnd);
		
		// then, merge those 2 halves
		mergeHalves(arr, temp, leftStart, rightEnd);
		
	}
	
	// mergeHalves method - helper method to merge the 2 sorted subarrays into sorted order
	private static void mergeHalves(int[] arr, int[] temp, int leftStart,  int rightEnd) {
		
		int leftEnd =  leftStart + ((rightEnd - leftStart) / 2); // the end of the left half
		int rightStart = leftEnd +1;  // the start of the right half
		
		int size = rightEnd - leftStart + 1; // total elements being copied over from temp array to main array
		
		int left = leftStart; // pointer to keep track of left half's current index
		int right = rightStart; // pointer to keep track of right half's current index
		int index = leftStart; // pointer for keeping track of temp array's current index
		
		// walk through the 2 halves 
		// and copy over the smaller element from the 2 halves to the temp array
		// and which ever halve's element is copied over, increment it by 1 as well as the index
		while((left <= leftEnd) && (right <= rightEnd)) {
			
			// since merge sort is stable, 
			// it will copy over equal elements in the order it is visited
			if(arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			} else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		
		// copy over the remainder of the elements from  either the left half or right half.
		// The side that doesn't have remainder elements, it's arraycopy() below won't run.
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1); // for left half
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1); // for right half
		
		// then copy everything from temp back into the main array
		System.arraycopy(temp, leftStart, arr, leftStart, size);
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81};
		
		System.out.println("Array before Merge Sort: " + Arrays.toString(arr));
		
		mergeSort(arr);
		
		System.out.println("Array after Merge Sort: " + Arrays.toString(arr));

	}

}



/*

Array before Merge Sort: [4, 11, 14, 6, 55, 22, 31, -25, 86, 42, 45, -17, -2, 81]
Array after Merge Sort: [-25, -17, -2, 4, 6, 11, 14, 22, 31, 42, 45, 55, 81, 86]


*/
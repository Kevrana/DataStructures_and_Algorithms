package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise16 {

	public static void main(String[] args) {
		// 16. Write a Java program to remove duplicate elements from an array.
		
		int[] numArr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 5, 6};
		System.out.println("Array: " + Arrays.toString(numArr));
		
		int len = removeDups(numArr);
		
		System.out.println("Array after duplicates are removed: ");
		
		for(int i = 0; i < len; i++) {
			if( i != len-1)
				System.out.print(numArr[i] + ",");
			else
				System.out.print(numArr[i]);
			
		}
	}
	
	public static int removeDups(int[] arr) {
		
		if(arr == null) {
			return 0;
		}
		
		int index = 1;
		
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] != arr[i+1])
				arr[index++] = arr[i+1];
		}
		
		return index;
	}

}

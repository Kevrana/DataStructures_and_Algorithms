package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Q16: Write a Java program to remove duplicate elements from an array.*/
		int[] numArr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 5};
		
		System.out.println("Array: " + Arrays.toString(numArr));
		
		int len = removeDuplicates(numArr);
		
		System.out.print("After removing duplicates: "); // should print out 1, 2, 3, 4, 5
		
		for(int i = 0; i < len; i++) {
			System.out.print(numArr[i] + ", ");
		}
	}

	public static int removeDuplicates(int[] arr) {
		
		if(arr == null || arr.length<0) {
			return 0;
		}
		
		int index = 1;
		
		
		
		for(int i = 0; i < arr.length -1; i++) {
			if(arr[i] != arr[i+1])
				arr[index++] =arr[i+1];
		}
		
		return index;
		
		
		
		
	}
}

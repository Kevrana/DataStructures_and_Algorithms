package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise6 {

	public static void main(String[] args) {
		/*Question 6:  Write a Java program to find the index of an array element
		 * */
		
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		String str = "Kevin";		
		System.out.println("Array: " + Arrays.toString(strArr));
		System.out.println("does it contain "+ str + ": " + indexOf(strArr, str));
	
	}
	
	public static int indexOf(String[] arr, String item) {
		
		//check to see if array is not null
		if(arr == null)
			return -1;
		
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == item) {
				return i;
			}
		}
		return -1;
	}

}

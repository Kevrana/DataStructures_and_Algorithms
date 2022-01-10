package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*Question 6:  Write a Java program to find the index of an array element
		 * */
		
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
	
		String str = "Kevin";	
		
		
		System.out.println("Array: " + Arrays.toString(strArr));
		System.out.println("Index of string '" + str + "' in array: " + indexOf(strArr, str));
		
		
		
	}
	
	
	public static int indexOf(String[] arr, String value) {
		
		if(arr == null || arr.length < 0)
			return -1;
		
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value)	
				return i;
		}
		
		return -1;
	}

}

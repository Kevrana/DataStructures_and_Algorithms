package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise5 {

	public static void main(String[] args) {
	/*Question 5: Write a Java program to test if an array contains a specific value
		 * */
		
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		String str = "App";
		
		System.out.println("Array: " + Arrays.toString(strArr));
		System.out.println("does it contain "+ str + ": " + contains(strArr, str) );

	}
	
	
	public static boolean contains(String[] arr, String item) {
		for(String s: arr) {
			if(s==item)
				return true;
		}
		return false;
	}

}

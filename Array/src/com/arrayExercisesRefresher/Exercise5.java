package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise5 {

	public static void main(String[] args) {
		
		/*Question 5: Write a Java program to test if an array contains a specific value
		 * */
		
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		String str = "Apple";
		
		
		System.out.println("Array:" + Arrays.toString(strArr));
		System.out.println("Does array contain '" + str + "': " + contains(strArr, str));
		

	}
	
	public static boolean contains(String[] arr, String value) {
		
		if(arr.length < 0 || arr == null)
			return false;
		
		for(String s : arr) {
			if(s.equals(value))
				return true;
		}
		
		return false;

	}

}

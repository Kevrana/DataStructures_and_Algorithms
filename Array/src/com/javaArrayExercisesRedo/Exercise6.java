package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise6 {

	public static void main(String[] args) {
		// 6. Write a Java program to find the index of an array element.
		String[] strArr = {"Tom", "Barry", "Foot", "Catch", "Zone"};
		String value = "Catch";
		
		System.out.println("Array: " + Arrays.toString(strArr));
		System.out.println("What is index of '" + value + "': " + indexOf(strArr, value));
	}
	
	public static int indexOf(String[] arr, String value) {
		if(arr == null || arr.length < 0)
			return -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

}

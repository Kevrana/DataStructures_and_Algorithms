package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise5 {

	public static void main(String[] args) {
		//5. Write a Java program to test if an array contains a specific value.
		
		String[] strArr = {"Tom", "Barry", "Foot", "Catch", "Zone"};
		String value = "Barry";
		
		System.out.println("Array: " + Arrays.toString(strArr));
		System.out.println("Does it contain '" + value + "': " + contains(strArr, value));

	}

	public static boolean contains(String[] arr, String value) {
		for(String s: arr) {
			if(s.equals(value)) {
				return true;
			}
		}
		return false;
	}

}

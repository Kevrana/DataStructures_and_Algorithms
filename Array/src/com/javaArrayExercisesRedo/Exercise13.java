package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise13 {

	public static void main(String[] args) {
		// 13. Write a Java program to find the duplicate values of an array of string values.
		
		String[] strArr = { "Bobby", "Chris", "Morgan", "Chris",  "Anna", "Nicky", "Bobby"};
		
		System.out.println("Array: " + Arrays.toString(strArr));
		for(int i = 0; i < strArr.length - 1; i++) {
			for(int j = i+1; j < strArr.length; j++) {
				if(strArr[i].equals(strArr[j]) && i!=j) {
					System.out.println("Duplicate found: " + strArr[i] + " at indices: (" + i + "," + j + ")" );
				}
			}
		}

	}

}

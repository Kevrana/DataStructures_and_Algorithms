package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise8 {

	public static void main(String[] args) {
		// Write a Java program to copy an array by iterating the array.
		String[] strArr = {"Tom", "Barry", "Foot", "Catch", "Zone"};
		
		String[] strArrCopy = new String[strArr.length];
		
		for(int i = 0; i < strArr.length; i++) {
			strArrCopy[i] = strArr[i];
		}
		
		System.out.println("Array:" + Arrays.toString(strArr) );
		System.out.println("Copied Array:" + Arrays.toString(strArrCopy) );

	}

}

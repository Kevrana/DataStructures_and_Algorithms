package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise8 {

	public static void main(String[] args) {
		/*Q8: Write a Java program to copy an array by iterating the array.*/
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		String[] strCopyArr = new String[strArr.length];
		
		for(int i=0; i<strArr.length; i++) {
			strCopyArr[i] = strArr[i];
		}
		
		System.out.println("Original Array: " + Arrays.toString(strArr));
		System.out.println("copied Array: " + Arrays.toString(strCopyArr));
		
	}
}

package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise1 {
	public static void main(String[] args) {
		
		// 1. Write a Java program to sort a numeric array and a string array
		int[] numArr = { 343 , 435, 102, 560, 99, 203, 495, 600, 777};
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		System.out.println("Num Array prior to sorting: " + Arrays.toString(numArr));
		System.out.println("Num Array prior to sorting: " + Arrays.toString(strArr));
		
		Arrays.sort(numArr);
		Arrays.sort(strArr);
		
		System.out.println("Num Array after sorting: " + Arrays.toString(numArr));
		System.out.println("Num Array after sorting: " + Arrays.toString(strArr));
	}
}

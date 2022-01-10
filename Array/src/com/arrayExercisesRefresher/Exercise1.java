package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise1 {
	
	public static void main(String[] args) {
		
		// Question 1: Write a Java program to sort a numeric array and a string array
		// declare and initialize a numeric array and str array
		
		int[] numArr = {12, 3, 545, 23, 66, 88, 52, 1, 33};
		String[] strArr = {"Bob" , "Carol", "Buffy" , "Willow", "Xander", "Gilles"};
		
		
		System.out.println("Num array before sort: " + Arrays.toString(numArr));
		System.out.println("Str array before sort: " + Arrays.toString(strArr));
		
		Arrays.sort(numArr);
		Arrays.sort(strArr);
		
		System.out.println("Num array after sort: " + Arrays.toString(numArr));
		System.out.println("Str array after sort: " + Arrays.toString(strArr));
		
		
		
		
		
	}

}

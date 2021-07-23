package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise2 {

	public static void main(String[] args) {
	
		//Question 2: Write a Java program to sum values of an array.
		
		//declare and initialize array of int values
		// create a sum variable
		int[] numArr = { 343 , 435, 102, 560, 99, 203, 495, 600, 777};
		int sum = 0;
		
		//iterate over array and add each element's value to sum
		
//		for(int i = 0; i < numArr.length; i ++) {
//			sum += numArr[i];
//		}
		
		// could also use a for each loop
		for(int i : numArr)
			sum+= i;
		
		
		
		System.out.println("Array: " + Arrays.toString(numArr));
		System.out.println("Sum of array: " + sum);
		
		

	}

}

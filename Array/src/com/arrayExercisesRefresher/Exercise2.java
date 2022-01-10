package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise2 {
	public static void main(String[] args) {
		
		//Question 2: Write a Java program to sum values of an array.
		
		//declare and initialize array of int values
		int[] numArr = { 343 , 435, 102, 560, 99, 203, 495, 600, 777};
		int sum = 0;
		
		for(int i : numArr)
			sum+= i;
		
		System.out.println("Array: " + Arrays.toString(numArr));
		System.out.println("Sum: " + sum);
		
		
	}
 
}

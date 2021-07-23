package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise4 {

	public static void main(String[] args) {
		
		/*Exercise 4: Write a Java program to calculate the average value of array elements*/
		int[] numArr = { 20, 30, 25, 35, -16, 60, -100};
		int total = 0;
		
		double average;
		
		
		// iterate through array elements and sum up values
		for(int i : numArr)
			total+= i;
		
		
		average = total/numArr.length;
		
		//print info
		System.out.println("Array: " + Arrays.toString(numArr));
		System.out.println("Total sum: " + total);
		System.out.println("Average of Array: " + average);
		
		
	}

}

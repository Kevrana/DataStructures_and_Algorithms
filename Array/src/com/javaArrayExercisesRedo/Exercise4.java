package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise4 {

	public static void main(String[] args) {
		
		//4. Write a Java program to calculate the average value of array elements
		int[] numArr = { 343 , 435, 102, 560, 99, 203, 495, 600, 777};
		int total = 0;
		double average = 0;
		
		for(int i : numArr)
			total+=i;
		
		average = (double) total/numArr.length;
		
		System.out.println("Array:" + Arrays.toString(numArr));
		System.out.println("Average:" + average);
	}

}

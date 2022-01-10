package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise4 {
	 
	public static void main(String[] args) {
		
		/*Exercise 4: Write a Java program to calculate the average value of array elements*/
		int[] numArr = { 20, 30, 25, 35, -16, 63, -100};
		int total = 0;
		double avg;
		
		for(int i : numArr)
			total+= i;
		
		avg = (double) total/numArr.length;
		
		
		System.out.println("Array: " + Arrays.toString(numArr));
		System.out.println("total: " + total);
		System.out.println("Avg: " + avg);
		
	}

}

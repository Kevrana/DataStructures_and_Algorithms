package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise10 {

	public static void main(String[] args) {
		// 10. Write a Java program to find the maximum and minimum value of an array.
		
		int[] numArr = {34, 10, 22, 52, 40, 97, 67, 102}; 
		int minSoFar = numArr[0];
		int maxSoFar = numArr[0];
		
		for(int i : numArr) {
			if(i < minSoFar)
				minSoFar = i;
			if(i > maxSoFar)
				maxSoFar = i;
		}
			
		System.out.println("Array: " + Arrays.toString(numArr));
		System.out.println("Min:" + minSoFar);
		System.out.println("Max:" + maxSoFar);
		
	}

}

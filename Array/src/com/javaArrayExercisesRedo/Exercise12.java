package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise12 {

	public static void main(String[] args) {
		// 12. Write a Java program to find the duplicate values of an array of integer values.
		
		int[] numArr = {34, 10, 22, 52, 22, 97, 40, 97, 67, 34, 102}; 

		System.out.println("Array: " + Arrays.toString(numArr));
		for(int i = 0; i < numArr.length - 1; i++) {
			for(int j = i+1; j < numArr.length; j++) {
				if(numArr[i] == numArr[j] && i!=j) {
					System.out.println("Duplicate found:" + numArr[i] + " at indices: (" + i + "," + j + ")" );
				}
			}
		}
		
	}

}

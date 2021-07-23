package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise12 {

	public static void main(String[] args) {
		/*q12: Write a Java program to find the duplicate values of an array of integer values.*/
		
		int[] numArr = {25, 14, 77, 56, 15, 36, 56, 77, 18, 25, 29, 49};

		System.out.println("Array: " + Arrays.toString(numArr));
		
		for(int i=0; i < numArr.length-1; i++) {
			for(int j=i+1; j < numArr.length; j++) {
				if((numArr[i] == numArr[j]) && (i!=j))
					System.out.println("Duplicate element: " + numArr[i] + ", at indices: " + i + "," + j);
				
			}
		}
		
	}

}

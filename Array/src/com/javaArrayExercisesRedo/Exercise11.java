package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise11 {

	public static void main(String[] args) {
		// 11.  Write a Java program to reverse an array of integer values.
		
		int[] numArr = {34, 10, 22, 52, 40, 97, 67, 102}; 
		int length = numArr.length;
		
		System.out.println("Array before reverse: " + Arrays.toString(numArr));
		
		for(int i = 0; i < length/2; i++) {
			
			int temp = numArr[i];
			numArr[i] = numArr[length - 1 - i];
			numArr[length - 1 - i] = temp;	
		}
		
		System.out.println("Array after reversed: " + Arrays.toString(numArr));

	}

}

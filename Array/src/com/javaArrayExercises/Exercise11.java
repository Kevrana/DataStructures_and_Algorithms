package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Write a Java program to reverse an array of integer values
		 * */
		
		int[] numArr = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		
		System.out.println("Array before reverse: " + Arrays.toString(numArr));
		
		int arrLen = numArr.length;
		
		for(int i = 0; i < arrLen/2; i++) {
			int temp = numArr[i];
			numArr[i] = numArr[arrLen-1-i];
			numArr[arrLen-1-i] = temp;
		}
		
		System.out.println("Array after reverse: " + Arrays.toString(numArr));

	}

}

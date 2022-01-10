package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise11 {

	public static void main(String[] args) {
		
		/* Write a Java program to reverse an array of integer values
		 * */
		
		int[] numArr = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int length = numArr.length;
		
		System.out.println("Arr before:" + Arrays.toString(numArr));
		
		for(int i = 0; i < length/2; i++) {
			int temp = numArr[i];
			numArr[i] = numArr[length - 1 - i];
			numArr[length - 1 - i] = temp;
		}
		
		
		System.out.println("Arr after:" + Arrays.toString(numArr));

	}

}

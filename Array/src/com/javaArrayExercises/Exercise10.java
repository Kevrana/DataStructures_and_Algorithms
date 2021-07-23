package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise10 {

	public static void main(String[] args) {
		/*Q10: Write a Java program to find the maximum and minimum value of an array.
		 * */
		int[] numArr = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		
		int minSoFar = numArr[0];
		int maxSoFar = numArr[0];
		
		for(int i : numArr) {
			if(i < minSoFar)
				minSoFar = i;
			if(i > maxSoFar)
				maxSoFar = i;
		}
		
		System.out.println("Arry is: " + Arrays.toString(numArr));
		System.out.println("Min is : " + minSoFar);
		System.out.println("Max is : " + maxSoFar);
	}

}

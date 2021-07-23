package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise13 {

	public static void main(String[] args) {
		/*q13: Write a Java program to find the duplicate values of an array of string values. */

		String[] strArr = {"Happy", "Birthday","Kevin", "Apple", "Sauce", "Kevin"};

		System.out.println("Array: " + Arrays.toString(strArr));
		
		for(int i=0; i < strArr.length-1; i++) {
			for(int j=i+1; j < strArr.length; j++) {
				if((strArr[i].equals(strArr[j])) && (i!=j))
					System.out.println("Duplicate element: " + strArr[i] + ", at indices: " + i + "," + j);
				
			}
		}
		
		
		
	}

}

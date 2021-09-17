package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Exercise9 {

	public static void main(String[] args) {
		//  Write a Java program to insert an element (specific position) into an array.
		
		String[] strArr = { "Bobby", "Chris", "Morgan", "Anna", "Nicky"};
		String valueToAdd = "Jamie";
		int insertAtIndex = 1;
		
		System.out.println("Array before adding '" + valueToAdd + "' to index '" + insertAtIndex + "': " + Arrays.toString(strArr));
		
		strArr = insertValue(strArr, valueToAdd, insertAtIndex);
		
		System.out.println("Array after adding '" + valueToAdd + "' to index '" + insertAtIndex + "': " + Arrays.toString(strArr));

	}
	
	public static String[] insertValue(String[] arr, String value, int index) {
		
		if(arr == null || index < 0 || index >= arr.length)
			return arr;
		
		String[] newArr = new String[arr.length + 1];
		
		for(int i = 0, k = 0; i < arr.length; i++) {
			if( i == index)
				newArr[k++] = value;
			newArr[k++] = arr[i];
		}
		return newArr;
	}

}

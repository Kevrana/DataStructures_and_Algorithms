package com.javaArrayExercisesRedo;

import java.util.Arrays;

public class Excercise7 {

	public static void main(String[] args) {
		// 7. Write a Java program to remove a specific element from an array.
		String[] strArr = {"Tom", "Barry", "Foot", "Catch", "Zone"};
		int removeIdx = 2;
		
		System.out.println("Array before removing index '" + removeIdx + "': " + Arrays.toString(strArr));
		
		strArr = removeFromArr(strArr, removeIdx);
		
		System.out.println("Array after removing index '" + removeIdx + "': " + Arrays.toString(strArr));

	}
	
	public static String[] removeFromArr(String[] arr, int index) {
		
		if(arr == null || index >= arr.length || index < 0)
			return arr;
		
		
		String[] newArr = new String[arr.length-1];
		
		for(int i = 0, k = 0; i < arr.length; i++) {
			if(i == index)
			{
				continue;
			}
			newArr[k] = arr[i];
			k++;
		}
	
		return newArr;
	}
}

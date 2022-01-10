package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise7 {

	public static void main(String[] args) {
		
		/*Q7: Write a Java program to remove a specific element from an array*/
		
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		int removeIndex = 2;	
		
		
		System.out.println("Arr before removing index 2: " + Arrays.toString(strArr));
		
		
		strArr = removeElement(strArr, removeIndex);
		
		
		System.out.println("Arr after removing index 2: " + Arrays.toString(strArr));
		

	}
	
	public static String[] removeElement(String[] arr, int index) {
		
		if(arr == null || index < 0 || index > arr.length)
			return arr;
		
		String[] newArr = new String[arr.length - 1];
		
		for(int i = 0,  k = 0; i < arr.length; i++) {
			if( i == index)
				continue;
			newArr[k++] = arr[i];
		}
		
		return newArr;

	}

}

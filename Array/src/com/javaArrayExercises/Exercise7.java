package com.javaArrayExercises;

import java.util.Arrays;

public class Exercise7 {

	public static void main(String[] args) {
		
		/*Q7: Write a Java program to remove a specific element from an array*/
		
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		int removeIndex = 2;	
		
		
		
		System.out.println("Array before removing item at index '"+ removeIndex + "': " + Arrays.toString(strArr));
		
		strArr = removeElement(strArr, removeIndex);
		
		System.out.println("Array after removing item at index '"+ removeIndex + "': " + Arrays.toString(strArr));
		
		

	}
	
	public static String[] removeElement(String[] arr, int index) {
		// iff arr is empty or out of the range, return original array
		if(arr == null || index < 0 || index >=arr.length)
			return arr;
		
		// create a new array with one less in size
		String[] newArr = new String[arr.length - 1];

		for(int i =0, k = 0; i < arr.length; i++) {
			
			//if i is index then don't copy that into newArr
			if(i == index) {
				continue;
			}
			
			// copy to new array and increment
			newArr[k] = arr[i];
			k++;
		}
		
		return newArr;
	}
}

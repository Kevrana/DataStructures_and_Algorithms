package com.arrayExercisesRefresher;

import java.util.Arrays;

public class Exercise9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Q9: Write a Java program to insert an element (specific position) into an array.
		 * */
		
		
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		int addToIndex = 3;	
		String value = "Butter";
		
		
		System.out.println("Array before adding item at index '"+ addToIndex + "': " + Arrays.toString(strArr));
		
		strArr = addElement(strArr, addToIndex, value);
		
		System.out.println("Array after adding item at index '"+ addToIndex + "': " + Arrays.toString(strArr));
		
		
		
	}
	
	
	public static String[] addElement(String[] arr, int index, String value) {
		if(arr == null || index < 0 || index > arr.length)
			return arr;
		
		
		String[] newArr = new String[arr.length + 1];
		
		for(int i = 0, k = 0; i < arr.length; i++) {
			
			if(i == index) {
				newArr[k++] = value;
			}
			newArr[k++] = arr[i];
			
		}
		
		return newArr;
		
		
		
		
		
	}

}

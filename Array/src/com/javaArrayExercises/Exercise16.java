package com.javaArrayExercises;

import java.util.Arrays;
import java.util.HashSet;

public class Exercise16 {

	public static void main(String[] args) {
		/*Q16: Write a Java program to remove duplicate elements from an array.*/
		
		
		int[] numArr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 5};
		
		System.out.println("Array: " + Arrays.toString(numArr));
		
		int len = removeDuplicates(numArr);
		
		System.out.print("After removing duplicates: "); // should print out 1, 2, 3, 4, 5
		
		for(int i = 0; i < len; i++) {
			System.out.print(numArr[i] + ", ");
		}
		
	}
	
	public static int removeDuplicates(int[] num) {
		
		// if array is null then 0 duplicate elements
		if(num.length == 0)
			return 0;
		
		// variable to keep track of where to place new unique number,
		// and starts at 1, because index of  0 is always going to be unique in a sorted array
		int index = 1; 
		
		// compare each 2 elements for uniqueness, up to num.length-1 
		// b/c of case where we are comparing 2nd last element with last element
		for(int i = 0; i < num.length - 1; i++) {
			if(num[i] != num[i+1]) {
				num[index++] = num[i+1]; // place the new unique value in index and increment index by 1. 
				
			}
			
		}
		return index;
	}

}

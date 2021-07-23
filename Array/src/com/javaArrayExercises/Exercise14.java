package com.javaArrayExercises;

import java.util.Arrays;
import java.util.HashSet;

public class Exercise14 {

	public static void main(String[] args) {
		/*q14: Write a Java program to find the common elements between two arrays (string values)
		 * */

		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		String[] strArrTwo = {"Happy", "Loser", "Turtle", "Max", "Kevin"};
		
		
		System.out.println("Arry 1: " + Arrays.toString(strArr));
		System.out.println("Arry 2: " + Arrays.toString(strArrTwo));
		
		System.out.println("Common elements between these 2 arrays: " + findCommon(strArr, strArrTwo));
	}
	
	public static HashSet<String> findCommon(String[] arr1, String[] arr2) {
			
		HashSet<String> hs = new HashSet<>();
		
		if(arr1 == null || arr2 == null) 
			return hs;
		
		for(String i :arr1)
			for(String j: arr2) {
				if(i.equals(j))
					hs.add(i);
			}
		return hs;
	}
}

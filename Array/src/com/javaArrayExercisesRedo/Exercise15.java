package com.javaArrayExercisesRedo;

import java.util.Arrays;
import java.util.TreeSet;

public class Exercise15 {

	public static void main(String[] args) {
		// 15. Write a Java program to find the common elements between two arrays of integers
		int[] numArr = { 20, 30, 25, 35, -16, 60, -100};
		int[] numArrTwo = { 27, 30, 35, 24, 12, 20, 44 };
		
		System.out.println("Arry 1: " + Arrays.toString(numArr));
		System.out.println("Arry 2: " + Arrays.toString(numArrTwo));
		
		System.out.println("Common elements between these 2 arrays: " + findCommon(numArr, numArrTwo));
	}
	
	public static TreeSet<Integer> findCommon(int[] arr1, int[] arr2){
		
		TreeSet<Integer> ts = new TreeSet<>();
		
		if(arr1 == null || arr2 == null)
			return ts;

		for(int i : arr1) {
			for(int j : arr2) {
				if(i == j) {
					ts.add(i);
				}
			}
		}	
		return ts;
	}
}

package com.javaArrayExercises;
import java.util.Arrays;

public class Exercise1 {
	public static void main(String[] args) {
		
		// Question 1: Write a Java program to sort a numeric array and a string array
		
		
		
		// declare and initialize a numeric array and str array
		int[] numArr = { 343 , 435, 102, 560, 99, 203, 495, 600, 777};
		String[] strArr = {"Happy", "Birthday", "Apple", "Sauce", "Kevin"};
		
		// print the before version of the arrays using Arrays.toString()
		System.out.println("Num array before sorting: " + Arrays.toString(numArr));
		System.out.println("String array before sorting: " + Arrays.toString(strArr));
		
		// sort using Arrays.sort
		Arrays.sort(numArr);
		Arrays.sort(strArr);
		
		// print after sort is done
		System.out.println("Num array before sorting: " + Arrays.toString(numArr));
		System.out.println("String array before sorting: " + Arrays.toString(strArr));
		
	}

}

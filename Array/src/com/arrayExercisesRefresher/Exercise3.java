package com.arrayExercisesRefresher;

public class Exercise3 {

	public static void main(String[] args) {
		
		/*
		Question 3: Write a Java program to print the following grid.
		Expected Output :
		
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -                                                                                           
		- - - - - - - - - -
		*/
		
		
		
		String[][] grid = new String[10][10];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = "- ";
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}

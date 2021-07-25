package com.array.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

// Stack Data structure array implementation following LIFO principle 
// with dynamic resizing
public class Stack {

	private int size; // counter for current # of elements in stack array
	private int[] numStack; // stack array
	private int top; // top reference for pushing/popping/peeking items.
	
	public Stack(int initialCapacity) {
		this.size = 0;
		this.numStack = new int[initialCapacity];
		this.top = -1;
	}
	
	// helper methods
	public boolean isFull() {
		return size == numStack.length;
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public void increaseCapacity() {
		int newCapacity = numStack.length*2;
		int[] tempArr = new int[newCapacity];
		for(int i = 0; i < numStack.length; i ++) {
			tempArr[i] = numStack[i];
		}
		numStack = tempArr;
	}
	
	public void decreaseCapacity() {
		int newCapacity = numStack.length-1;
		int[] tempArr = new int[newCapacity];
		for(int i = 0; i < tempArr.length; i ++) {
			tempArr[i] = numStack[i];
		}
		numStack = tempArr;
	}
	
	public void display() {
		
		if(!isEmpty()) {
			System.out.println("Stack Array:");
			System.out.print("Top:   |  ");
			for(int i = 0; i < numStack.length; i++) {
				if(i == top) {
					System.out.print("top | ");
				}
				else {
					System.out.print("- |  ");
				}
			}
			System.out.println();
			System.out.print("Index: | ");
			for(int i=0; i < numStack.length; i++) {
				System.out.printf("%02d | ", i);
			}
			System.out.println();
			System.out.print("Value: | ");
			for(int element: numStack) {
				System.out.print(element + " | ");
			}
			System.out.println();
		}
		else {
			System.out.println("Stack empty! Try pushing something in first?");
		}
	}
	
	
	// insert
	public void push(int data) {
		if(isFull()) {
			increaseCapacity(); // will make push() become O(n) 
		}
		numStack[++top] = data;
		size++;
	}
	
	// access (to top, since random access )
	public int peek() {
		if(!isEmpty()) {
			return numStack[top];
		}
		throw new EmptyStackException();
	}
	
	// delete
	 public int pop(){
		 if(!isEmpty()) {
			 int poppedData = peek();
			 decreaseCapacity();
			 top--;
			 size--;
			 return poppedData;
		 }
		 throw new EmptyStackException();
	 }
	
	
	
	
	public static void main(String[] args) {
		
		Stack stack = new Stack(10);
		
		// pushing
		stack.push(10);// bottom of stack
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.push(90);
		stack.push(100);// top of stack (last in, first out)
		
		// display
		stack.display();
		
		// peeking top
		System.out.println();
		System.out.println("The top value is: "+ stack.peek());
		
		// popping
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		System.out.println();
		System.out.println("Popped off: "+ stack.pop());
		stack.display();
		
		
		
		System.out.println("Stack empty? " + stack.isEmpty());
		
		
		

	}

}

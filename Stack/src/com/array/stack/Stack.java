package com.array.stack;

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
	// checks to see if stack is full
	public boolean isFull() {
		return size == numStack.length;
	}
	
	// checks to see if stack is empty
	public boolean isEmpty() {
		return top < 0;
	}
	
	// resizes stack array with double the previous capacity
	public void increaseCapacity() {
		int newCapacity = numStack.length*2;
		int[] tempArr = new int[newCapacity];
		for(int i = 0; i < numStack.length; i ++) {
			tempArr[i] = numStack[i];
		}
		numStack = tempArr;
	}
	
	// resizes stack array with 1 less the previous capacity
	public void decreaseCapacity() {
		int newCapacity = numStack.length-1;
		int[] tempArr = new int[newCapacity];
		for(int i = 0; i < tempArr.length; i ++) {
			tempArr[i] = numStack[i];
		}
		numStack = tempArr;
	}
	
	// displays the stack in an easy to read output
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
	
	
	// insert - adds item to the stack and if full, resize
	public void push(int data) {
		if(isFull()) {
			increaseCapacity(); // will make push() become O(n) 
		}
		numStack[++top] = data;
		size++;
	}
	
	// access (to top, since random access )
	// gets value of top of stack without removing it
	public int peek() {
		if(!isEmpty()) {
			return numStack[top];
		}
		throw new EmptyStackException();
	}
	
	// delete - removes item off the top of stack and resizes
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
		
		stack.display();
		System.out.println();
		
		// pushing
		stack.push(10);// bottom of stack
		stack.display();
		System.out.println();
		
		
		stack.push(20);
		stack.display();
		System.out.println();
		
		stack.push(30);
		stack.display();
		System.out.println();
		
		stack.push(40);
		stack.display();
		System.out.println();
		
		stack.push(50);
		stack.display();
		System.out.println();
		
		stack.push(60);
		stack.display();
		System.out.println();
		
		stack.push(70);
		stack.display();
		System.out.println();
		
		stack.push(80);
		stack.display();
		System.out.println();
		
		stack.push(90);
		stack.display();
		System.out.println();
		
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


/*Output:
Stack empty! Try pushing something in first?

Stack Array:
Top:   |  top | - |  - |  - |  - |  - |  - |  - |  - |  - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 

Stack Array:
Top:   |  - |  top | - |  - |  - |  - |  - |  - |  - |  - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 

Stack Array:
Top:   |  - |  - |  top | - |  - |  - |  - |  - |  - |  - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 

Stack Array:
Top:   |  - |  - |  - |  top | - |  - |  - |  - |  - |  - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 | 0 | 0 | 0 | 0 | 0 | 0 | 

Stack Array:
Top:   |  - |  - |  - |  - |  top | - |  - |  - |  - |  - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 | 50 | 0 | 0 | 0 | 0 | 0 | 

Stack Array:
Top:   |  - |  - |  - |  - |  - |  top | - |  - |  - |  - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 0 | 0 | 0 | 0 | 

Stack Array:
Top:   |  - |  - |  - |  - |  - |  - |  top | - |  - |  - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 70 | 0 | 0 | 0 | 

Stack Array:
Top:   |  - |  - |  - |  - |  - |  - |  - |  top | - |  - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 70 | 80 | 0 | 0 | 

Stack Array:
Top:   |  - |  - |  - |  - |  - |  - |  - |  - |  top | - |  
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 70 | 80 | 90 | 0 | 

Stack Array:
Top:   |  - |  - |  - |  - |  - |  - |  - |  - |  - |  top | 
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 70 | 80 | 90 | 100 | 

The top value is: 100

Popped off: 100
Stack Array:
Top:   |  - |  - |  - |  - |  - |  - |  - |  - |  top | 
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 70 | 80 | 90 | 

Popped off: 90
Stack Array:
Top:   |  - |  - |  - |  - |  - |  - |  - |  top | 
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 70 | 80 | 

Popped off: 80
Stack Array:
Top:   |  - |  - |  - |  - |  - |  - |  top | 
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 70 | 

Popped off: 70
Stack Array:
Top:   |  - |  - |  - |  - |  - |  top | 
Index: | 00 | 01 | 02 | 03 | 04 | 05 | 
Value: | 10 | 20 | 30 | 40 | 50 | 60 | 

Popped off: 60
Stack Array:
Top:   |  - |  - |  - |  - |  top | 
Index: | 00 | 01 | 02 | 03 | 04 | 
Value: | 10 | 20 | 30 | 40 | 50 | 

Popped off: 50
Stack Array:
Top:   |  - |  - |  - |  top | 
Index: | 00 | 01 | 02 | 03 | 
Value: | 10 | 20 | 30 | 40 | 

Popped off: 40
Stack Array:
Top:   |  - |  - |  top | 
Index: | 00 | 01 | 02 | 
Value: | 10 | 20 | 30 | 

Popped off: 30
Stack Array:
Top:   |  - |  top | 
Index: | 00 | 01 | 
Value: | 10 | 20 | 

Popped off: 20
Stack Array:
Top:   |  top | 
Index: | 00 | 
Value: | 10 | 

Popped off: 10
Stack empty! Try pushing something in first?
Stack empty? true
*/
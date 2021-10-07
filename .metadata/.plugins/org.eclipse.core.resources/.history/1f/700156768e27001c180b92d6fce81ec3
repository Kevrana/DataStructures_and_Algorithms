package com.linkedlist.stack;

import java.util.EmptyStackException;

// Stack Data Structure LinkedList based implementation
public class Stack {
	private Node top; // pointer to top of stack for pushing/peeking/popping data
	private int size; // the current number of items in the stack
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null; 
		}
	}
	
	
	
	// helper methods
	// checks if stack is empty
	public boolean isEmpty() {
		return top == null;
	}
	
	// displays stack in an easy to read output
	public void display() {
		Node curr = top;
		if(!isEmpty()) {
			System.out.println("The Stack is: ");
			while(curr.next != null) {
				if(curr == top)
					System.out.println(" | " + curr.data + " | <== TOP ");
				else
					System.out.println(" | " + curr.data + " | ");
				curr = curr.next;
			}
			if(curr == top)
				System.out.println(" | " + curr.data + " | <== TOP ");
			else
				System.out.println(" | " + curr.data + " | ");
			System.out.println(" ````` ");
		}
		else {
			System.out.println("The Stack is: Empty! Try adding an item or don't.... it's your call.");
		}
		
	}
	
	// returns the current number of items in the stack
	public int size() {
		return size;
	}
	
	// insert - adds an item to top of stack
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	// access - gets the value at top of stack without removing it
	public int peek() {
		if(!isEmpty()) {
			return top.data;
		}
		throw new EmptyStackException();
	}
	
	// delete - removes item from top of stack
	public int pop() {
		if(!isEmpty()){
			int toDelete = top.data;
			top = top.next;
			size--;
			return toDelete;
		}
		throw new EmptyStackException();
	}
	
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		// display
		stack.display();
		System.out.println();
		
		
		//pushing
		stack.push(1);
		stack.display();
		System.out.println();
		
		stack.push(2);
		stack.display();
		System.out.println();
		
		stack.push(3);
		stack.display();
		System.out.println();
		
		stack.push(4);
		stack.display();
		System.out.println();
		
		stack.push(5);
		
		
		// display
		stack.display();
		
		// peeking
		System.out.println();
		System.out.println("The top of stack is: " + stack.peek());
		System.out.println("Size: " + stack.size());
		
		//popping
		System.out.println();
		System.out.println("Popped item: " + stack.pop());
		stack.display();
		System.out.println("Size: " + stack.size());

		System.out.println();
		System.out.println("Popped item: " + stack.pop());
		stack.display();
		System.out.println("Size: " + stack.size());
		
		System.out.println();
		System.out.println("Popped item: " + stack.pop());
		stack.display();
		System.out.println("Size: " + stack.size());
		
		System.out.println();
		System.out.println("Popped item: " + stack.pop());
		stack.display();
		System.out.println("Size: " + stack.size());
		
		System.out.println();
		System.out.println("Popped item: " + stack.pop());
		stack.display();
		System.out.println("Size: " + stack.size());
		
		System.out.println();
		System.out.println("Stack empty? " + stack.isEmpty());
		

	}

}

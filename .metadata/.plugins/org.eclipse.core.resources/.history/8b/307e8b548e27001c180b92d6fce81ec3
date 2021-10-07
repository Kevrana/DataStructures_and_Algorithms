package com.linkedlist.queue;

import java.util.NoSuchElementException;

// Queue Data Structure implementation using linked list
public class Queue {
	private Node head; // front of queue pointer
	private Node tail; // tail of queue pointer
	private int size; // # of items in the queue currently
	
	public Queue() {
		this.head = this.tail = null;
		this.size = 0;
	}
	
	
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	 
	// helper methods
	// checks to see if queue is empty
	public boolean isEmpty() {
		return head == null;
	}
	
	// returns the current number of items in queue
	public int size() {
		return size;
	}
	
	// displays the queue in an easy to follow output
	public void display() {
		
		if(!isEmpty()) {
			System.out.println("The LinkedList Queue is: ");
			
			System.out.print("Position: | ");
			for(int i=1; i <= size; i++) {
				System.out.printf("%02d | ", i);
			}
			
			System.out.println();
			System.out.print("   Value: | ");
			
			Node curr = head;
			while(curr.next != null) {
				System.out.print( curr.data + " | ");
				curr = curr.next;
			}
			System.out.print( curr.data + " | ");
			System.out.println();
		}
		else {
			System.out.println("The LinkedList Queue is: Empty!!!");
		}
	}
	
	
	
	// insert - adds item to queue
	public void enqueue(int data) {
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			head = tail = newNode;	
		}else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	// remove - removes item from head.
	public int dequeue() {
		if(!isEmpty()) {
			int toDelete = head.data;
			head = head.next;
			size--;
			return toDelete;
		}
		throw new NoSuchElementException("Cannot dequeue b/c queue is in fact... empty!");
	}
	
	// access - returns the value at head without removing it
	public int peek() {
		if(isEmpty())
			throw new NoSuchElementException("Cannot dequeue b/c queue is in fact... empty!");
		return head.data;
	}
	
	
	
	//execution
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		System.out.println("****************ENQUEUE TEST*******************");
		// enqueuing
		queue.enqueue(11);
		queue.enqueue(12);
		queue.enqueue(13);
		queue.enqueue(14);
		queue.enqueue(15);
		queue.enqueue(16);
		
		System.out.println();
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Current value of head: " + queue.peek());
		
		System.out.println();
		System.out.println("****************DEQUEUE TEST*******************");

		System.out.println();
		System.out.println("Dequeued value: " +  queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Current value of head: " + queue.peek());
		
		System.out.println();
		System.out.println("Dequeued value: " +  queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Current value of head: " + queue.peek());
		
		System.out.println();
		System.out.println("Dequeued value: " +  queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Current value of head: " + queue.peek());
		
		System.out.println();
		System.out.println("Dequeued value: " +  queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Current value of head: " + queue.peek());
		
		System.out.println();
		System.out.println("Dequeued value: " +  queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Current value of head: " + queue.peek());
		
		
		System.out.println();
		System.out.println("Dequeued value: " +  queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		

		
	}

}

package com.array.circular.queue;

import java.util.NoSuchElementException;


public class Queue {
	
	private int head; // front of the queue, where we remove from
	private int tail; // rear of the queue, where we add to
	private int size; // the current number of items in the queue
	private int[] queue; // the queue array, where 0 indicates "null" element.
	
	public Queue(int Capacity) {
		this.head = this.tail = -1;
		this.size = 0;
		queue = new int[Capacity];
	}
	
	
	
	
	
	// helper methods
	public boolean isFull() {
		return (tail + 1) % queue.length == head;
	}

	public boolean isEmpty() {
		return head == -1; // or head < 0 or tail < 0 or tail == -1
	}
	
	public void resize() {
		int newCapacity = queue.length*2;
		int[] tempArr = new int[newCapacity];
		
		int i = 0; // used to traverse  the new array
		int j = head; // used to traverse  old array
		
		do { 
			tempArr[i++] = queue[j];
			j = (j+1) % queue.length;	// will eventually == head
		}while( j != head);
		
		head = 0;
		tail = queue.length-1; // b/c old arr is full,tail is last index of old arr
		queue = tempArr;
	}
	
	public void display() {	
		if(!isEmpty()) {
			System.out.println("Queue Array: ");
			System.out.println();
			
			System.out.print("Index: | ");
			for(int i=0; i < queue.length; i++) {
				System.out.printf("%02d | ", i);
			}
			
			System.out.println();
			System.out.print("Value: | ");
			for(int i = 0; i < queue.length; i++) {
				if(queue[i] != 0)
					System.out.print(queue[i] + " | ");
				else
					System.out.print("   | ");
			}
			System.out.println();
		}
		else {
			System.out.println("Stack empty! Try pushing something in first?");
		}
	}
	
	public int size() {
		return size;
	}
	
	
	
	
	// insert -> O(n) because of resize()
	public void enqueue(int data) {
		if(isFull())
			resize();
		else if(isEmpty())
			head++;
		tail  = (tail + 1) % queue.length;
		queue[tail] = data;
		size++;
	}
	
	// remove
	public int dequeue() {
		
		if(isEmpty())
			throw new NoSuchElementException();
		int toDelete = queue[head];
		size--;
		// if the head we are removing is also tail
		if(head == tail) {
			queue[head] = 0;
			head = tail = -1; // then, reset queue to indicate its empty
			size = 0;
		}else {
			queue[head] = 0;
			head = (head+1) % queue.length;
		}
		return toDelete;	
	}
	
	// peek
	public int peek() {
		if(isEmpty())
			throw new NoSuchElementException();
		return queue[head];
	}
	
	
	
	
	public static void main(String[] args) {
Queue queue = new Queue(10);
		
		System.out.println("****************ENQUEUE TEST*******************");
		// enqueuing
		queue.enqueue(10);
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
		queue.enqueue(20);
		System.out.println();
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
		queue.enqueue(30);
		System.out.println();
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
		queue.enqueue(40);
		System.out.println();
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
		queue.enqueue(50);
		System.out.println();
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
		
		System.out.println();
		System.out.println("*****************PEEK TEST***************");
		//peeking
		System.out.println();
		System.out.println("Front of queue: " + queue.peek());
		
		System.out.println();
		System.out.println("*****************DEQUEUE TEST*************");
		// dequeuing
		System.out.println();
		System.out.println("Removed from queue: " + queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
		
		System.out.println();
		System.out.println("Removed from queue: " + queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
		System.out.println();
		System.out.println("Removed from queue: " + queue.dequeue());
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		


		System.out.println();
		System.out.println("*********ENQUEUE AGAIN AFTER DEQUEUING SOME TEST************");
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(82);
		queue.enqueue(83);
		queue.enqueue(84);
		queue.enqueue(85);
		queue.enqueue(86);
		
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
		
		System.out.println();
		System.out.println("*********ENQUEUE AGAIN AFTER FULL QUEUE TEST************");

		queue.enqueue(87);
		
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
	}

}

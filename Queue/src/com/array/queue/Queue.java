package com.array.queue;

import java.util.NoSuchElementException;

// Queue Data Structure implementation using an Array following FIFO principle
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
	//checks to see if queue is empty
	public boolean isEmpty() {
		return head < 0;
	}
	
	// checks to see if queue is full
	public boolean isFull() {
		return size == queue.length; // or can be tail == queue.length-1
	}
	
	// returns the current number of items in queue
	public int size() {
		return size;
	}
	
	// displays the queue in an easy to follow output
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

	
	
	// inserts item to queue
	public void enqueue(int data) {
		if(isFull()) {
			throw new IllegalStateException();
		}
		else {
			if(isEmpty())
				head++;
			queue[++tail] = data;
			size++;
		}
	}
	
	
	// deletes item from head of queue
	public int dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		int toDelete = queue[head];
		size--;
		if(head == tail) {
			queue[head] = 0;
			head = tail = -1;
			size = 0;
		}else {
			queue[head++] = 0;
			
		}
		return toDelete;
	}
	
	// access - returns value at head of queue without removing it
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
		System.out.println("*********ENQUEUE AGAIN AFTER RESETING TEST************");
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		
		queue.display();
		System.out.println("Size: " + queue.size());
		System.out.println("Front: " + queue.head);
		System.out.println("Rear: " + queue.tail);
		
	}

}

/*Output:
****************ENQUEUE TEST*******************
Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 |    |    |    |    |    |    |    |    |    | 
Size: 1
Front: 0
Rear: 0

Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 |    |    |    |    |    |    |    |    | 
Size: 2
Front: 0
Rear: 1

Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 |    |    |    |    |    |    |    | 
Size: 3
Front: 0
Rear: 2

Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 |    |    |    |    |    |    | 
Size: 4
Front: 0
Rear: 3

Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 10 | 20 | 30 | 40 | 50 |    |    |    |    |    | 
Size: 5
Front: 0
Rear: 4

*****************PEEK TEST***************

Front of queue: 10

*****************DEQUEUE TEST*************

Removed from queue: 10
Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: |    | 20 | 30 | 40 | 50 |    |    |    |    |    | 
Size: 4
Front: 1
Rear: 4

Removed from queue: 20
Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: |    |    | 30 | 40 | 50 |    |    |    |    |    | 
Size: 3
Front: 2
Rear: 4

Removed from queue: 30
Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: |    |    |    | 40 | 50 |    |    |    |    |    | 
Size: 2
Front: 3
Rear: 4

Removed from queue: 40
Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: |    |    |    |    | 50 |    |    |    |    |    | 
Size: 1
Front: 4
Rear: 4

Removed from queue: 50
Stack empty! Try pushing something in first?
Size: 0
Front: -1
Rear: -1

*********ENQUEUE AGAIN AFTER RESETING TEST************
Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 60 | 70 | 80 |    |    |    |    |    |    |    | 
Size: 3
Front: 0
Rear: 2
*/
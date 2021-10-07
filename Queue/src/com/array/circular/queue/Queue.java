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
	
	// checks if queue is full
	public boolean isFull() {
		return (tail + 1) % queue.length == head;
	}

	// checks if queue is empty
	public boolean isEmpty() {
		return head == -1; // or head < 0 or tail < 0 or tail == -1
	}
	
	// resizes queue if it gets full so it can add more items to it
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
	
	// displays queue in an easy to follow output
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
	
	// returns the current number of items in queue
	public int size() {
		return size;
	}
	
	
	
	
	// insert item to queue ->normally o(1), but O(n) because of resize()
	public void enqueue(int data) {
		if(isFull())
			resize();
		else if(isEmpty())
			head++;
		tail  = (tail + 1) % queue.length;
		queue[tail] = data;
		size++;
	}
	
	// remove item from head of queue
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
	
	// peek - returns value at head without removing
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

*********ENQUEUE AGAIN AFTER DEQUEUING SOME TEST************
Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 
Value: | 84 | 85 | 86 | 40 | 50 | 60 | 70 | 80 | 82 | 83 | 
Size: 10
Front: 3
Rear: 2

*********ENQUEUE AGAIN AFTER FULL QUEUE TEST************
Queue Array: 

Index: | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 
Value: | 40 | 50 | 60 | 70 | 80 | 82 | 83 | 84 | 85 | 86 | 87 |    |    |    |    |    |    |    |    |    | 
Size: 11
Front: 0
Rear: 10
*/
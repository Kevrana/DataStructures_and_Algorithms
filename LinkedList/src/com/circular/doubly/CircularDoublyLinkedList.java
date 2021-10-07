package com.circular.doubly;

class Node {
	int data;
	Node next;
	Node prev;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}



public class CircularDoublyLinkedList {
	
	Node head;
	Node tail;
	int counter;
	
	//inserts
	// adds node at end of list and updates cycle
	public void append(int data) {
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
			tail.next = head;
			head.prev = tail;
			counter++;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			tail.next = head;
			head.prev = tail;
			counter++;
		}
		
	}
	
	// adds node at beginning of list and updates cycle
	public void prepend(int data) {
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
			tail.next = head;
			head.prev = tail;
			counter++;
		}
		else {
			newNode.next = head;
			tail.next = newNode;
			newNode.prev = head.prev;
			head.prev = newNode;
			head = newNode;
			counter++;
		}
		
	}
	
	// adds Node after specified index and updates cycle
	public void addAfter(int index, int data) {
		Node newNode = new Node(data);
		Node curr = head;
		int position = 0;
		
		if(head == null || index >= counter || index < 0) {
			System.out.println("List empty or index out of bound!!!");
			return;
		}
		
		do{
			if(position == index) {
				newNode.next = curr.next;
				curr.next.prev = newNode;
				newNode.prev = curr;
				curr.next = newNode;
				counter++;
				break;
			}
			curr = curr.next;
			position++;
		}
		while(curr.next != head);
		
		if(curr.next == head) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			tail.next = head;
			head.prev = tail;
			counter++;
		}
		
	}
	
	
	// deletes
	
	// deletes node at end, updates cycle, and returns node
	public Node removeLast() {
		Node toDelete = head;
		
		if(head == null || head.next == head) {
			head = null;
			counter--;
			return toDelete;
		}
		
		Node curr = head;
		while(curr.next != tail) {
			curr = curr.next;
		}
		
		if(curr.next == tail) {
			toDelete = curr.next;
			curr.next = head;
			head.prev = tail.prev;
			tail.prev = null;
			tail.next = null;
			tail = curr;
			counter--;
		}
		return toDelete;
	}
	
	// deletes node at beginning, updates cycle, and returns node
	public Node removeFirst() {
		Node toDelete = head;
		if(head == null || head.next == head) {
			head = null;
			counter--;
			return toDelete;
		}
		tail.next = head.next;
		head.next.prev = head.prev;
		head = head.next;
		counter--;
		return toDelete;
	}
	
	// deletes node after specified index, updates cycle, and returns node
	public Node removeAfter(int index) {
		if(isEmpty()) {
			return null;
		}
		
		Node toDelete = null;
		Node curr = head;
		int position = 0;
		
		
		while(curr.next != head) {
			if(position == index) {
				if(curr.next == tail) {
					toDelete = curr.next;
					curr.next = head;
					head.prev = tail.prev;
					tail.prev = null;
					tail.next = null;
					tail = curr;
					counter--;
					return toDelete;
				}
				toDelete = curr.next;
				curr.next = curr.next.next;
				curr.next.next.prev = curr;
				counter--;
				return toDelete;
			}
			curr = curr.next;
			position++;
		}
		
		
		if(curr.next == head) {
			if(position == index) {
				toDelete = curr.next;
				curr.next = head.next;
				head.next.prev = curr;
				head = head.next;
				counter--;
				return toDelete;
			}
		}
		
		return toDelete;
	}
	
	
	// access
	// gets the data at the specified index and returns it
	public int get(int index) {
		
		if(head == null || index >= counter || index < 0) {
			return -1;
		}
		
		Node curr = head;
		int position = 0;
		
		while(curr.next != head) {
			if(position == index) {
				return curr.data;
			}
			curr = curr.next;
			position++;
		}
		
		if (curr.next == head) {
			if(position == index)
				return curr.data;
		}
		return -1;
	}
	
	// search
	// checks list if it has the specified data
	public boolean contains(int data) {
		Node curr = head;
		
		if(head.data == data) {
			return true;
		}
		
		while(curr.next != head) {
			if(curr.data == data) {
				return true;
			}
			curr = curr.next;
		}
		
		if(curr.next == head) {
			if(curr.data == data) {
				return true;
			}
		}
		return false;
	}
	
	//helpers
	// checks if list is empty
	public boolean isEmpty() {
		return (head==null);
	}
	
	// returns the current number of items in list
	public int size() {
		return counter;
	}
	
	// displays list
	public void printList() {
		Node curr = head;
		
		if(isEmpty()) {
			System.out.println("List is empty!!!!!");
		}
		else {
			System.out.println("Circular Doubly LinkedList is: ");
			do {
				System.out.print(curr.data + ", ");
				curr = curr.next;
			}
			while(curr != head);
			
			System.out.println();
		}
	}
	
	//execution
	public static void main(String[] args) {
		
		CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
		
		cdll.append(1);
		cdll.append(2);
		cdll.append(3);
		cdll.append(4);
		cdll.append(5);
		cdll.prepend(6);
		cdll.prepend(7);
		cdll.addAfter(6,8);
		cdll.prepend(9);
		cdll.prepend(10);
		cdll.append(11);
		cdll.addAfter(10,12);
		
		cdll.printList();
		System.out.println("Size: " + cdll.size());
		
		
		System.out.println();
		System.out.println("Removed last: " + cdll.removeLast().data);
		cdll.printList();
		System.out.println("Size: " + cdll.size());
		
		
		System.out.println();
		System.out.println("Removed first: " + cdll.removeFirst().data);
		cdll.printList();
		System.out.println("Size: " + cdll.size());
		
		
		System.out.println();
		System.out.println("Removed after index 3: " + cdll.removeAfter(3).data);
		cdll.printList();
		System.out.println("Size: " + cdll.size());
		
		System.out.println("Does list contain 1 : " + cdll.contains(1));
		
		System.out.println("Get value at index 4: " + cdll.get(4));

	}

}


/*Output:
Circular Doubly LinkedList is: 
10, 9, 7, 6, 1, 2, 3, 4, 5, 8, 11, 12, 
Size: 12

Removed last: 12
Circular Doubly LinkedList is: 
10, 9, 7, 6, 1, 2, 3, 4, 5, 8, 11, 
Size: 11

Removed first: 10
Circular Doubly LinkedList is: 
9, 7, 6, 1, 2, 3, 4, 5, 8, 11, 
Size: 10

Removed after index 3: 2
Circular Doubly LinkedList is: 
9, 7, 6, 1, 3, 4, 5, 8, 11, 
Size: 9
Does list contain 1 : true
Get value at index 4: 3
*/
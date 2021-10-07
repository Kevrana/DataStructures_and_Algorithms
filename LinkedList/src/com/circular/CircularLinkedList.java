package com.circular;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

// implementation of a singly circular linkedlist
// note: a doubly linked list can be followed, but will have both a next and previous pointer for each node
public class CircularLinkedList {
	Node head;
	Node tail;
	int counter; 

	// inserts
	// appends to end of list which links back to the head
	public void append(int data) {
		Node newNode = new Node(data);
		
		// if list is empty, set both head and tail to the newNode and newNode's next to head.
		if(head == null) {
			head = newNode;
			tail = newNode;
			tail.next = head;
			counter++;
		}
		else {
			// otherwise, we append the newNode directly to the tail's next node, point tail to the newNode
			// and finally, point tail's next to head. 
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
			counter++;
		}
		
	}
	
	// adds node to the beginning of the list and updates cycle
	public void prepend(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
			tail.next = head;
			counter++;
		}
		else {
			newNode.next = head;
			head = newNode;
			tail.next = head;
			counter++;
		}
	}
	
	// adds node after specified index and updates cycle
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
				curr.next = newNode;
				counter++;
				break;
			}
			curr = curr.next;
			position++;
		}
		while(curr.next != head);
		
		if(curr.next == head) {
			newNode.next = head;
			curr.next = newNode;
			tail = newNode;
			counter++;	
		}
	}
	
	
	// deletes
	// removes last node and updates cycle
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
			tail.next = null;
			tail = curr;
			counter--;
		}
		return toDelete;
	}
	
	// removes first node and updates cycle
	public Node removeFirst() {
		Node toDelete = head;
		if(head == null || head.next == head) {
			head = null;
			counter--;
			return toDelete;
		}
		tail.next = head.next;
		head = head.next;
		counter--;
		return toDelete;
	}
	
	// removes node after specified index and updates cycle
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
					tail.next = null;
					tail = curr;
					counter--;
					return toDelete;
				}
				toDelete = curr.next;
				curr.next = curr.next.next;
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
				head = head.next;
				counter--;
				return toDelete;
			}
		}
		
		return toDelete;
	}
	
	
	// search
	// checks to see if list has the specified data
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
	
	
	// access
	// gets the data of the specified index
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
			return curr.data;
		}
	
		return -1;

	}
	
	
	// helpers
	// checks if list is empty
	public boolean isEmpty() {
		return (head == null);
	}
	
	// returns the current number of items in the list
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
			System.out.println("Circular list is: ");
			do {
				System.out.print(curr.data + ", ");
				curr = curr.next;
			}
			while(curr != head);
			
			System.out.println();
		}
	}
	

	
	
	

	
	// execution
	public static void main(String[] args) {
	
		CircularLinkedList cll = new CircularLinkedList();
		
		cll.append(1);
		cll.append(2);
		cll.append(3);
		cll.append(4);
		cll.append(5);
		cll.prepend(6);
		cll.prepend(7);
		cll.addAfter(1,8);
		
		cll.printList();
		System.out.println("Size: " + cll.size());
		
		System.out.println();
		System.out.println("Removed last: " + cll.removeLast().data);
		cll.printList();
		System.out.println("Size: " + cll.size());
	
		System.out.println();
		System.out.println("Removed first: " + cll.removeFirst().data);
		cll.printList();
		System.out.println("Size: " + cll.size());
		
		System.out.println();
		System.out.println("Removed after index 5: " + cll.removeAfter(5).data);
		cll.printList();
		System.out.println("Size: " + cll.size());
		
		
		System.out.println();
		System.out.println("Removed first: " + cll.removeFirst().data);
		cll.printList();
		System.out.println("Size: " + cll.size());
		
		System.out.println();
		System.out.println("Removed last: " + cll.removeLast().data);
		cll.printList();
		System.out.println("Size: " + cll.size());
		
		System.out.println("Does list contain 1 : " + cll.contains(1));
		
		System.out.println("Get value at index 0: " + cll.get(0));
		

	}

}


/*Output:
Circular list is: 
7, 6, 8, 1, 2, 3, 4, 5, 
Size: 8

Removed last: 5
Circular list is: 
7, 6, 8, 1, 2, 3, 4, 
Size: 7

Removed first: 7
Circular list is: 
6, 8, 1, 2, 3, 4, 
Size: 6

Removed after index 5: 6
Circular list is: 
8, 1, 2, 3, 4, 
Size: 5

Removed first: 8
Circular list is: 
1, 2, 3, 4, 
Size: 4

Removed last: 4
Circular list is: 
1, 2, 3, 
Size: 3
Does list contain 1 : true
Get value at index 0: 1
*/
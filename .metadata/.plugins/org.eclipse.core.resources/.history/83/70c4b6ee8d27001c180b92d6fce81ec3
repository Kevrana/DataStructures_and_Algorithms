package com.doubly;


public class DoublyLinkedListRedo {
	
	// node Class
	static class Node {
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	Node head; // pointer reference to the head of the list, initially it is pointing  to null
	int size; // size counter for the number of nodes in the list
	
	
	
	/*** HELPER METHODS **************/
	
	// returns current size of list
	public int size() {
		return size;
	}
	
	
	// checks to see if list is Empty
	public boolean isEmpty() {
		return head == null;
	}
	
	
	// prints the list
	public void printList() {
		Node curr = head;
		System.out.print("Current List: ");
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	
	
	/*** Insert METHODS **************/
	
	// append to list - add to tail end of the list
	public void append(int data) {
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			head = newNode;
			size++;
		}
		else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.prev = curr;
			size++;
		}
	}
	
	
	// prepend to list - add to the head of the list
	public void prepend(int data) {
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			head = newNode;
			size++;
		}
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size++;
		}
	}
	
	// add after given Node index
	public void addAfter(int index, int data) {
		
		if(isEmpty() || index > size-1 || index < 0) {
			System.out.println("Can't add, either list is empty or given index is out of bounds of the list.");
			return;
		}
		
		Node newNode = new Node(data);
		Node curr = head;
		int position = 0;
		
		while(curr.next != null) {
			if(position == index) {
				curr.next.prev = newNode;
				newNode.next = curr.next;
				curr.next = newNode;
				newNode.prev = curr;
				size++;
			}
			curr = curr.next;
			position++;
		}
		if(curr.next == null) {
			if(position == index) {
				curr.next = newNode;
				newNode.prev = curr;
				size++;
			}
		}
	}
	
	
	/*** Delete METHODS **************/
	
	// remove first
	public Node removeFirst() {
		Node toDelete = head;
		
		if(isEmpty() || head.next == null) {
			head = null;
			size--;
			return toDelete;
		}
		
		head = head.next;
		head.prev = null;
		size--;
		return toDelete;
	}
	
	// remove last
	public Node removeLast() {
		
		Node toDelete = head;
		
		if(isEmpty() || head.next == null) {
			head = null;
			size--;
			return toDelete;
		}
			
		while(toDelete.next != null) {
			toDelete = toDelete.next;
		}
		
		// Once we have the last node stored in toDelete, we disconnect it from the list
		toDelete.prev.next = null;
		size--;	
		return toDelete;
	}
	
	
	
	
	// remove after given data
	public Node removeAfter(int data) {
		Node toDelete = head;
		
		while(toDelete != null) {
			if(toDelete.data == data) {
				toDelete = toDelete.next;
				break;
			}
			toDelete = toDelete.next;
		}
		
		if(toDelete != null) {
			if(toDelete.next != null) {
				toDelete.next.prev = toDelete.prev;
			}
			toDelete.prev.next = toDelete.next;
			size--;
		}
		return toDelete;
	}
	
	

	
	/*** Search METHOD **************/
	
	// checks to see if list contains given data
	public boolean contains(int data) {
		
		Node curr = head;
		
		if(head == null)
			return false;
		
		if(head.data == data) {
			return true;
		}
		
		while(curr.next != null) {
			if(curr.data == data) {
				return true;
			}
			curr = curr.next;
		}
		
		if(curr.next == null) {
			if(curr.data == data) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	/*** Access METHOD **************/
	
	// checks through list and returns the data of the given Node's index.
	
	public int get(int index) {
		
		if(head == null || index > size-1 || index < 0) {
			return -1;
		}
		
		Node curr = head;
		int position = 0;
		
		while(curr.next != null) {
			if(position == index) {
				return curr.data;
			}
			curr = curr.next;
			position++;
		}
		
		if(curr.next == null) {
			if(position == index) {
				return curr.data;
			}
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		DoublyLinkedListRedo dll = new DoublyLinkedListRedo();
		System.out.println("List empty? " + dll.isEmpty());
		System.out.println("Size of list: " + dll.size());
		
		dll.append(1);
		dll.append(2);
		dll.append(3);
		dll.prepend(4);
		dll.prepend(5);
		dll.addAfter(2, 6);
		
		System.out.println();
		dll.printList();
		System.out.println("List empty? " + dll.isEmpty());
		System.out.println("Size of list: " + dll.size());
		System.out.println("Value at index 2: " + dll.get(2));
		System.out.println("Does it contain 3: " + dll.contains(3));
		
		System.out.println();
		System.out.println("last item removed: " + dll.removeLast().data);
		dll.printList();
		System.out.println("Size of list: " + dll.size());
		
		System.out.println();
		System.out.println("first item removed: " + dll.removeFirst().data);
		dll.printList();
		System.out.println("Size of list: " + dll.size());
		
		
		System.out.println();
		System.out.println("Remove item after Node with value '1': " + dll.removeAfter(1).data);
		dll.printList();
		System.out.println("Size of list: " + dll.size());
		
		
		
		
	}

}

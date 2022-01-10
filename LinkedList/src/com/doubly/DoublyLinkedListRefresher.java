package com.doubly;

public class DoublyLinkedListRefresher {

	
	static class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	
	// doublyLinkedList field/class variables
	
	Node head;
	int size;
	
	
	// helper methods - isEmpty, printList, size
	
	public int size(){
		return size;
	}
	
	public void printList() {
		Node curr = head;
		
		System.out.println("Current list: ");
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	
	public boolean isEmpty() {
		return head == null;
	}
	
	
	
	
	// add methods - append, prepend, addAfter(index,data)
	
	public void append(int data) {
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			head = newNode;
			size++;
		}else {
			Node curr = head;
			
			while(curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = newNode;
			newNode.prev = curr;
			size++;
		}
	}
	
	public void prepend(int data) {
		
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			head = newNode;
			size++;
		}else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size++;
		}
	}
	
	public void addAfter(int index, int data) {
		
		if(isEmpty() || index > size-1 || index < 0) {
			System.out.println("Cant add, list empty or index out of bounds!");
			return;
		}
		
		Node curr = head;
		Node newNode = new Node(data);
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
	
	
	
	// remove methods - removeFirst, removeLast, removeAfter(data)
	
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
		
		toDelete.prev.next = null;
		size--;
		return toDelete;
		
	}
	
	
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
	
	
	

	// search method - contains(data)
	
	public boolean contains(int data) {
		
		Node curr = head;
		
		if(isEmpty())
			return false;
		
		if(head.data == data) {
			return true;
		}
		
		
		while(curr.next != null) {
			if(curr.data == data)
				return true;
			curr = curr.next;
		}
		
		if(curr.next == null) {
			if(curr.data == data)
				return  true;
		}
		
		return false;

	}
	
	
	
	// access method - get data at given index
	public int get(int index) {
		
		if(isEmpty() || index > size - 1 || index < 0)
			return -1;
		
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
		// TODO Auto-generated method stub

	}

}

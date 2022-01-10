package com.singly;

public class LinkedListRefresher {
	
	
	static class Node{
		Node next;
		int data;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
	}
	
	// LinkedList Class variables
	Node head;
	int size;
	
	
	// Add/Insert Methods - append, prepend, addAfter
	
	public void append(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			size++;
		} else {
			Node curr = head;
			
			while(curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = newNode;
			size++;
		}
		
	}
	
	public void prepend(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			size++;
		}else {
			newNode.next = head;
			head = newNode;
			size++;
		}
		
	}
	
	public void addAfter(int index, int data) {
		
		if(head == null || index > size - 1 || index < 0) {
			System.out.println("Cant add: list empty or index out of bound");
			return;
		}
		
		
		Node newNode = new Node(data);
		Node curr = head;
		int position = 0;
		
		while(curr != null) {
			if(position == index) {
				newNode.next = curr.next;
				curr.next = newNode;
				size++;
				break;
			}
			curr = curr.next;
			position++;
		}

	}
	
	
	
	// remove methods - removeFirst, removeLast, removeAfter(index), remove(data)
	
	public Node removeFirst() {
		
		if(head != null) {
			Node toDelete = head;
			head = head.next;
			size--;
			return toDelete;
		}
		
		return null;
	}
	
	
	public Node removeLast() {
		
		Node curr = head;
		
		if(curr == null || curr.next == null) {
			head = null;
			size--;
			return curr;
		}
		
		Node nextNode = curr.next;
		
		while(curr.next != null) {
			if(nextNode.next == null) {
				curr.next = null;
				size--;
			}
			curr = nextNode;
			nextNode = nextNode.next;
		}
		
		return curr;
	}
	
	
	public Node removeAfter(int index) {
		
		Node toDelete = null;
		Node curr = head;
		int position = 0;
		
		while(curr != null && curr.next != null) {
			if(position == index) {
				toDelete = curr.next;
				curr.next = toDelete.next;
				size--;
			}
			curr = curr.next;
			position++;
		}
		
		return toDelete;
	}
	
	
	public Node remove(int data) {
		
		Node toDelete = null;
		
		if(head == null) {
			return toDelete;
		}
		
		if(head.data == data) {
			toDelete = head;
			head = head.next;
			size--;
			return toDelete;
		}
		
		Node curr = head;
		
		while(curr.next != null) {
			if(curr.next.data == data) {
				toDelete = curr.next;
				curr.next = toDelete.next;
				size--;
				return toDelete;
			}
			curr = curr.next;
		}
		
		
		return toDelete;
	}
	
	
	
	
	// search Method - contains(data)
	
	public boolean contains(int data) {
		
		if(head == null)
			return false;
		
		Node curr = head;
		
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
	
	
	// access/get method - get(index)
	
	public int get(int index) {
		
		if(head == null || index > size - 1 || index < 0)
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
	
	
	
	
	
	
	// helper methods - printList, size, and isEmpty

	// print list method
	public void printList() {
		
		Node curr = head;
		System.out.println("Current list: ");
		while(curr != null) {
			System.out.println(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	// size method
	public int size() {
		return size;
	}
	
	// isEmpty method
	public boolean isEmpty() {
		return head == null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {



	}

}

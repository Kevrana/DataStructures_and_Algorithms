package com.singly;

public class LinkedList {

	Node head;
	int counter;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	
	// insert
	public void add(int data) {
		Node newNode = new Node(data);
		
		// if the head is null, meaning list is empty, then head points to the new node
		if(head == null) {
			head = newNode;
			counter++;
				
		}
		else {
			Node curr = head;
			// else traverse through the list until we reach tail
			while(curr.next != null) {
				curr = curr.next;
			}
			// once at tail,  tail's next points to the new node
			curr.next = newNode;
			counter++;
			
		}	
	}
	
	
	public void addFirst(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			counter++;
			
		}
		else {
			newNode.next = head;
			head = newNode;
			counter++;
			
		}
	}
	
	
	public void addLast(int data) {
		Node newNode = new Node(data);
		
		// if the head is null, meaning list is empty, then head points to the new node
		if(head == null) {
			head = newNode;
			counter++;
			
		}
		else {
			Node curr = head;
			// else traverse through the list until we reach tail
			while(curr.next != null) {
				curr = curr.next;
			}
			// once at tail,  tail's next points to the new node
			curr.next = newNode;
			counter++;
			
		}	
	}
	
	
	public void addAfter(int index, int data) {
		
		if(head == null || index >= counter || index < 0) {
			System.out.println("Can't add. List empty or index out of bound.");
			return;
		}
		
		Node curr = head;
		Node newNode = new Node(data);
		int position = 0;
		
		while(curr.next != null) {
			if(position == index) {
				
				newNode.next = curr.next;
				curr.next = newNode;
				counter++;
				break;
			}
			curr = curr.next;
			position++;
		}
		
		if(curr.next == null) {
			curr.next = newNode;
			counter++;
			
		}
	}
	
	
	// deletes
	public Node removeStart() {
		if(head != null) {
			Node toDelete = head;
			head = head.next;
			counter--;
			return toDelete;
		}
		return null;
	}
	
	
	public Node removeLast() {
		Node curr = head;
		
		if(curr == null || curr.next == null) {
			head = null;
			counter--;
			return curr;
		}
		
		Node nextNode = curr.next;
		
		while(curr.next != null) {
			if(nextNode.next == null) {
				curr.next = null;
				counter--;
			}
			curr = nextNode;
			nextNode = nextNode.next;
		}
		
		return curr;
	}
	
	
	public Node removeAfter(int index) {
		
		Node curr = head;
		
		Node toDelete = null;
		
		int position = 0;
		
		while(curr != null && curr.next !=null) {
			if(position == index && curr.next !=null) {
				toDelete = curr.next;
				curr.next = toDelete.next;
				counter--;
			}
			curr = curr.next;
			position++;
		}
		
		
		return toDelete;
	}
	
	public Node remove(int data) {
		
		Node toDelete = null;
		
		if(head == null)
			return toDelete;
		
		if(head.data == data) {
			toDelete = head;
			head = head.next;
			counter--;
			return toDelete;
		}
		
		Node curr = head;
		while(curr.next != null) {
			if(curr.next.data == data) {
				toDelete = curr.next;
				curr.next = curr.next.next;
				counter--;
				return toDelete;
			}
			curr = curr.next;
		}
		return toDelete;
	}
	
	// access
	public int get(int index) {
		
		if(head == null || index >= counter || index < 0) {
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
		
		if (curr.next == null) {
			return curr.data;
		}
	
		return -1;

	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void printList() {
		Node curr = head;
		
		System.out.print("Current list: ");
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}	
		System.out.println();
		
	}
	
	public int size() {
		return counter;
	}
	
	// search
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
		return false;
	}
	
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		
		// add() - addLast() is same so not doing
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.printList();
		
		// size()
		System.out.println("Size of the list now: " + ll.size());
		
		
		// addFirst()
		ll.addFirst(4);
		System.out.println();
		System.out.println("after adding to first: ");
		ll.printList();
		System.out.println("Size of the list now: " + ll.size());
		
		
		
		// adding normally again
		System.out.println();
		System.out.println("After appending one more: ");
		ll.add(5);
		ll.printList();
		System.out.println("Size of the list now: " + ll.size());
		
		
		// get()
		System.out.println("The value at index 4: " + ll.get(6));
		
		
		
		//addAfter()
		System.out.println();
		System.out.println("Adding after index 2: ");
		ll.addAfter(2, 66);
		ll.printList();
		System.out.println("Size of the list now: " + ll.size());
//		
//		
//		//contains()
//		System.out.println();
//		System.out.println("Does it contain 66?  " + ll.contains(66));
//		ll.printList();
		
		
		
		
		
//		// remove(66)
//		System.out.println();
//		System.out.println("Removing node with value 66: " + ll.remove(66).data);
//		ll.printList();
//		System.out.println("Size of the list now: " + ll.size());
//		
//		
//		
//		//removeLast()
//		System.out.println();
//		System.out.println("Removing last: " + ll.removeLast().data);
//		ll.printList();
//		System.out.println("Size of the list now: " + ll.size());
//		
//		
//		//removeStart()
//		System.out.println();
//		System.out.println("Removing head: " + ll.removeStart().data);
//		ll.printList();
//		System.out.println("Size of the list now: " + ll.size());
//		
//		
//		System.out.println();
//		System.out.println("Removing after index 1:");
//		ll.removeAfter(1);
//		System.out.println("Size of the list now: " + ll.size());
//		ll.printList();

	}

}

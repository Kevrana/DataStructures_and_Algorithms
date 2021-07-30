package com.doubly;

class Node{
	int data;
	Node prev;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class DoublyLinkedList {
	Node head;
	int counter;
	
	
	
	
	// helper methods
	
	//checks if list is empty
	public boolean isEmpty() {
		return (head == null);
	}
	
	// displays list
	public void printList() {
		Node curr = head;
		
		System.out.print("Current list: ");
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}	
		System.out.println();
		
	}
	
	// returns current number of items in list
	public int size() {
		return counter;
	}
	
	// access
	// gets the data for specified index
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
	
	// search
	// searches list for specified data
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
	
	// inserts
	// inserts node to end of list
	public void append(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			counter++;
		}
		else {
			Node curr = head;
			
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.prev = curr;
			counter++;
		}
		
	}
	
	// inserts node at beginning of list
	public void prepend(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			counter++;
		}
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			counter++;
		}
	}
	
	
	// adds node after the specified index in list
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
				curr.next.prev = newNode;
				newNode.next = curr.next;
				curr.next = newNode;
				newNode.prev = curr;
				counter++;
				break;
			}
			curr = curr.next;
			position++;
		}
		
		if(curr.next == null) {
			curr.next = newNode;
			newNode.prev = curr;
			counter++;
			
		}
	}
	
	// deletes
	// removes first node and returns it
	public Node removeFirst() {
		Node toDelete = head;
		
		if(head == null || head.next == null) {
			head = null;
			counter --;
			return toDelete;
		}
		
		head = head.next;
		head.prev = null;
		counter--;
		return toDelete;
	}
	
	// removes last node and returns it
	public Node removeLast() {
		Node toDelete = head;
		
		if(head == null || head.next == null) {
			head = null;
			counter--;
			return toDelete;
		}
		while(toDelete.next != null) {
			toDelete = toDelete.next;
		}
		toDelete.prev.next = null;
		counter--;
		return toDelete;
	}
	
	// removes Node after specified data and returns it
	public Node removeAfter(int data) {
		Node toDelete = head;
		
		while(toDelete != null) {
			if( toDelete.data == data) {
				toDelete = toDelete.next;
				break;
			}
			toDelete = toDelete.next;
		}
		if( toDelete != null) {
			if(toDelete.next != null) {
				toDelete.next.prev = toDelete.prev;
			}
			toDelete.prev.next = toDelete.next;
		}
		
		counter--;
		return toDelete;
	}

	
	
	
	

	// execution
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
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
		System.out.println("Does it contain 6: " + dll.contains(6));
		
		System.out.println();
		System.out.println("last item removed: " + dll.removeLast().data);
		dll.printList();
		System.out.println("Size of list: " + dll.size());
		
		System.out.println();
		System.out.println("first item removed: " + dll.removeFirst().data);
		dll.printList();
		System.out.println("Size of list: " + dll.size());
		
		
		System.out.println();
		System.out.println("Remove item after index 1: " + dll.removeAfter(1).data);
		dll.printList();
		System.out.println("Size of list: " + dll.size());
		
		
	}

}

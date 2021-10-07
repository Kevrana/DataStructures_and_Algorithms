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
	
	// prepend method
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
	
	// append method, same as our add method above
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
	
	// insert in the position after the specified index
	public void addAfter(int index, int data) {
		
		// conditional check for null or  out of bounds
		if(head == null || index > counter-1 || index < 0) {
			System.out.println("Can't add. Reason: List empty or given index out of bound.");
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
				return;
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
	
	// remove node from beginning and return it
	public Node removeStart() {
		if(head != null) {
			Node toDelete = head;
			head = head.next;
			counter--;
			return toDelete;
		}
		return null;
	}
	
	// remove node from end and return it
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
	
	
	// remove node after the specified index and return it
	public Node removeAfter(int index) {
		
		Node curr = head;
		
		Node toDelete = null;
		
		int position = 0;
		
		while(curr != null && curr.next !=null) {
			if(position == index) {
				toDelete = curr.next;
				curr.next = toDelete.next;
				counter--;
			}
			curr = curr.next;
			position++;
		}
		
		
		return toDelete;
	}
	
	// remove Node with the specified data and return it
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
	
	// get the data at specified index
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
			if(position == index) {
				return curr.data;
			}
		}
	
		return -1;

	}
	
	// checks if list is empty
	public boolean isEmpty() {
		return (head == null);
	}
	
	// displays the list
	public void printList() {
		Node curr = head;
		
		System.out.print("Current list: ");
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}	
		System.out.println();
		
	}
	
	// returns current size of list
	public int size() {
		return counter;
	}
	
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
		
		if(curr.next == null) {
			if(curr.data == data) {
				return true;
			}
		}
		
		return false;
	}
	
	
	// execution
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
		System.out.println("The value at index 4: " + ll.get(4));
		
		
		
		//addAfter()
		System.out.println();
		System.out.println("Adding after index 2: ");
		ll.addAfter(2, 66);
		ll.printList();
		System.out.println("Size of the list now: " + ll.size());
		
		
		//contains()
		System.out.println();
		System.out.println("Does it contain 66?  " + ll.contains(66));
		ll.printList();
		
		
		
		
		
		// remove(66)
		System.out.println();
		System.out.println("Removing node with value 66: " + ll.remove(66).data);
		ll.printList();
		System.out.println("Size of the list now: " + ll.size());
		
		
		
		//removeLast()
		System.out.println();
		System.out.println("Removing last: " + ll.removeLast().data);
		ll.printList();
		System.out.println("Size of the list now: " + ll.size());
		
		
		//removeStart()
		System.out.println();
		System.out.println("Removing head: " + ll.removeStart().data);
		ll.printList();
		System.out.println("Size of the list now: " + ll.size());
		
		
		System.out.println();
		System.out.println("Removing after index 1:");
		ll.removeAfter(1);
		System.out.println("Size of the list now: " + ll.size());
		ll.printList();

	}

}

/*Output:
Current list: 1, 2, 3, 
Size of the list now: 3

after adding to first: 
Current list: 4, 1, 2, 3, 
Size of the list now: 4

After appending one more: 
Current list: 4, 1, 2, 3, 5, 
Size of the list now: 5
The value at index 4: 5

Adding after index 2: 
Current list: 4, 1, 2, 66, 3, 5, 
Size of the list now: 6

Does it contain 66?  true
Current list: 4, 1, 2, 66, 3, 5, 

Removing node with value 66: 66
Current list: 4, 1, 2, 3, 5, 
Size of the list now: 5

Removing last: 5
Current list: 4, 1, 2, 3, 
Size of the list now: 4

Removing head: 4
Current list: 1, 2, 3, 
Size of the list now: 3

Removing after index 1:
Size of the list now: 2
Current list: 1, 2, 
*/
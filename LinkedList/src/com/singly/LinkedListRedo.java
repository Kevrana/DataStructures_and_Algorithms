package com.singly;

public class LinkedListRedo {

	// Inner Node class to create nodes with the data passed
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}	
		
	// LinkedList Class variables
	
	Node head; // head Node
	int size;// current size/number of nodes in list
	
	
	// ADDING METHODS - return types are of void *******************************************
	
	// append - add to the end of list
	public void append(int data) {
		
		// 1. create node
		Node newNode = new Node(data);
		
		
		// 2. check if head is empty i.e. list is empty, if yes, make head point to this newNode
		// and increment counter
		if(head == null) {
			head = newNode;
			size++;
		}
		
		// 3. else, traverse through list until we reach tail (node with next == null)
		else 
		{
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			// 4. Point the tail node's next to the newNode;
			curr.next = newNode;
			size++;
		}
		
		
	}
	
	// prepend
	public void prepend(int data) {
		
		// 1. create new node with given data
		Node newNode = new Node(data);
		
		// 2. check if head is null, if yes point head to null and increment size
		if(head == null) {
			head = newNode;
			size++;
		}
		// 3. else, set the newNode's next to the head, and then point head to the newNode, and increment size
		else {
			newNode.next = head;
			head = newNode;
			size++;
		}
	}
	
	// addAfter given index
	public void addAfter(int index, int data) {
		
		// 1. conditional check to see if list is empty or index given is out of bound
		if(head == null || index > size - 1 || index < 0) {
			System.out.println("Can't add b/c list is empty or index given is out of bound!");
			return;
		}
		
		//2. create Node curr to track current node, initialize it to point to head
		// create the new Node with the given data
		// also, create an int position to keep track of the index of the curr Node
		
		Node curr = head;
		Node newNode = new Node(data);
		int position = 0;
		
		// 3. traverse through the list until the current node is not null,
		//and check if the position of the node is equal to the given index
		
		while(curr != null) {
			
			// 4. if it is, then assign the newNode's next to the curr.next
			// and assign curr.next to the new Node and increment the size
			if(position == index) {
				newNode.next = curr.next;
				curr.next = newNode;
				size++;
			}
			
			// 5. other wise move to next node and increment position
			curr = curr.next;
			position++;
		}
		
	}
	
	
	
	
	
	// DELETING METHODS - return types are of Node  ******************************************
	
	// remove first
	public Node removeFirst() {
		if(head != null) {
			Node toDelete = head;
			head = head.next;
			size--;
			return toDelete;
		}
		return null;
	}
	
	// remove last
	public Node removeLast() {
		
		// 1. create current Node to point to head
		Node curr = head;
		
		// 2. check if the head is null (empty list) or the head's next is null (only head is in list)
		// if true, set head to null, decrement size, then return curr which is holding the head Node.
		if(curr == null || curr.next == null) {
			head = null;
			size--;
			return curr;
		}
		
		
		// 3. otherwise, create a nextNode to point to curr node's next.
		Node nextNode = curr.next;
		
		// 4. // travesrse through list until at end
		while(curr.next != null) {
			
			// 5. if nextNode's next is the last Node of the list,
			// set curr's next to point to null and decrement size;
			if(nextNode.next == null) {
				curr.next = null;
				size--;
			}
			// 6. otherwise, set curr to nextNode, and nextNode to its next
			curr = nextNode;
			nextNode = nextNode.next;
		}
		
		return curr;
	}
	
	
	// remove after
	public Node removeAfter(int index) {
		Node curr = head;
		Node toDelete = null;
		
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
	
	// remove node with given data
	public Node remove(int data) {
		
		Node toDelete = null;
		
		if(head == null) {
			return toDelete;
		}
		
		if (head.data == data) {
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
	
	
	
	// SEARCH METHOD*********************************************
	
	// check if list contains this value
	public boolean contains(int data) {
		Node curr = head;
		
		if(head == null) {
			return false;
		}
		
		while(curr.next != null) {
			if(curr.data == data) {
				return true;
			}
			curr = curr.next;
			
		}
		
		if(curr.next == null) {
			if (curr.data == data) {
				return true;
			}
		}
		return false;
	}
	
	
	
	// ACCESS METHOD********************************************
	
	// get the value at this given index
	public int get(int index) {
		
		if(head == null || index > size - 1 | index < 0) {
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
	
	
	// HELPER METHODS********************************************
	
	// return the size of the list
	public int size() {
		return size;
	}
	
	// print the list
	public void printList() {
		
		Node curr = head;
		System.out.print("Current list: ");
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	// check to see if list is empty
	public boolean isEmpty() {
			return head == null;
		}
		
	
	
	
	public static void main(String[] args) {
		
		LinkedListRedo llr = new LinkedListRedo();
		
		
		
		// add() - addLast() is same so not doing
		llr.append(1);
		llr.append(2);
		llr.append(3);
		llr.printList();
		
		// size()
		System.out.println("Size of the list now: " + llr.size());
		
		
		// addFirst()
		llr.prepend(4);
		System.out.println();
		System.out.println("after adding to first: ");
		llr.printList();
		System.out.println("Size of the list now: " + llr.size());
		
		
		
		// adding normally again
		System.out.println();
		System.out.println("After appending one more: ");
		llr.append(5);
		llr.printList();
		System.out.println("Size of the list now: " + llr.size());
		
		
		// get()
		System.out.println("The value at index 4: " + llr.get(4));
		
		
		
		//addAfter()
		System.out.println();
		System.out.println("Adding after index 2: ");
		llr.addAfter(2, 66);
		llr.printList();
		System.out.println("Size of the list now: " + llr.size());
		
		
		//contains()
		System.out.println();
		System.out.println("Does it contain 66?  " + llr.contains(66));
		llr.printList();
		
		
		
		
		
		// remove(66)
		System.out.println();
		System.out.println("Removing node with value 66: " + llr.remove(66).data);
		llr.printList();
		System.out.println("Size of the list now: " + llr.size());
		
		
		
		//removeLast()
		System.out.println();
		System.out.println("Removing last: " + llr.removeLast().data);
		llr.printList();
		System.out.println("Size of the list now: " + llr.size());
		
		
		//removeStart()
		System.out.println();
		System.out.println("Removing head: " + llr.removeFirst().data);
		llr.printList();
		System.out.println("Size of the list now: " + llr.size());
		
		
		System.out.println();
		System.out.println("Removing after index 1:");
		llr.removeAfter(1);
		System.out.println("Size of the list now: " + llr.size());
		llr.printList();
		

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
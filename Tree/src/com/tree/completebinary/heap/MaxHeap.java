package com.tree.completebinary.heap;

import java.util.Arrays;

//Java implementation of the MaxHeap data structure.
//MaxHeaps are Complete Binary Trees, so every level is filled, top to bottom, left to right
//except the last level which is filled from the left till the last inserted node.
public class MaxHeap {

	// Instance variables
	int size;
	int[] heap;
	
	public MaxHeap(int intialCapacity) {
		size = 0;
		heap = new int[intialCapacity];
	}
	
	// Heap Methods
	
	// Insert Method - inserts node into the heap
	public void insert(int data) {
	
		checkCapacity(); // first, check if capacity is full to resize heap before inserting
		heap[size++] = data; // add item to end of heap and increment size
		heapifyUp(); // will try to move newly added node up until max heap property is restored
	}
	
	// Peek method - gets max of heap
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		return heap[0];
	}
	
	// Delete method - returns the root value and removes it from the heap
	public int poll() {
		if(isEmpty())
			throw new IllegalStateException();
		
		int toDelete = peek(); // store root(max) of heap in a temp
		heap[0] = heap[size-1]; // move the last element to the first
		size--; 
		heapifyDown(); // will try to move new root down until max heap property is restored
		return toDelete;
	}
	
	
	// Heapify Methods 
	
	// HeapifyUp - used when inserting new value in heap,
	// will bubble up value until max heap property is restored
	public void heapifyUp() {
		
		// get the index of recently inserted item
		int index = size-1;
		
		// while the inserted node has a parent and the parent is smaller than it, swap them
		while(hasParent(index) && getParent(index) < heap[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index); //  check for each parent
		}
		
	}
	
	// HeapifyDown - used when deleting root(max) value in heap,
	// will sink down value until max heap property is restored
	public void heapifyDown() {
		
		//the index of root, which is holding the recent replacement of recently removed root
		int index = 0;
		
		// while this index has children, swap with the larger of the 2 children
		while(hasLeftChild(index)) {
			
			// holds the index of the child which has the max value of the 2
			int largerChildIndex = getLeftChildIndex(index);
			
			// if right child is larger than left, right's index becomes largerChildIndex
			if(hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {
				largerChildIndex = getRightChildIndex(index);
			}
			
			
			// if item is smaller than its child, swap to maintain max heap property
			if(heap[index] > heap[largerChildIndex]) {
				break;
			}
			else {
				swap(index, largerChildIndex);	
			}

			index = largerChildIndex;
		}
	}
	
	
	//Helper methods

	// prints the heap array
	public void print() {
		System.out.println("Current Max Heap: (size: " + this.size() + ")" );
		for(int i = 0; i < size; i++) {
			System.out.print(heap[i] + ", ");
		}
		System.out.println("\n");
	}
	
	// return the size of the heap
	public int size() {
		return size;
	}
	
	// checks if heap is empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	// checks if heap is full
	public boolean isFull() {
		return size == heap.length;
	}
	
	// Increases the capacity of the heap array if it is full
	public void checkCapacity() {
		if(isFull())
			heap = Arrays.copyOf(heap, heap.length * 2);
	}
	
	// Swap method - swaps parent node with current node for maintaining max heap property
	public void swap(int indexOne, int indexTwo) {
		int temp = heap[indexOne];
		heap[indexOne] = heap[indexTwo];
		heap[indexTwo] = temp;
	}
	
	// Retrieves the parent index of the given child index
	public int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}
	
	// Retrieves the left child index of the given parent index
	public int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	// Retrieves the right child index of the given parent index
	public int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	// checks if a parent exists for this child index
	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	// checks if a left child exists for this parent index
	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	// checks if a right child exists for this parent index
	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	// returns the parent of the given child index
	public int getParent(int index) {
		return heap[getParentIndex(index)];
	}
	
	// returns the left child of the given parent index
	public int getLeftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}
	
	// returns the right child of the given parent index
	public int getRightChild(int index) {
		return heap[getRightChildIndex(index)];
	}
	
	
	// execution
	public static void main(String[] args) {
		
		// declare and instantiate a max heap with 10 slots.
		MaxHeap maxHeap = new MaxHeap(10);
		
		// insert 10 items into heap
		maxHeap.insert(5);
		maxHeap.insert(9);
		maxHeap.insert(3);
		maxHeap.insert(4);
		maxHeap.insert(8);
		maxHeap.insert(10);
		maxHeap.insert(7);
		maxHeap.insert(6);
		maxHeap.insert(2);
		maxHeap.insert(1);
		
		// print heap
		maxHeap.print();
		
		// get the max of heap
		System.out.println("What is the maximum of heap currently? " + maxHeap.peek());
		System.out.println();
		
		// remove the max of heap
		System.out.println("Removing max of heap(root): " + maxHeap.poll());
		System.out.println();
	
		// print heap
		maxHeap.print();
		
		// check if it heap resizes after inserting past initial capacity of 10
		maxHeap.insert(22);
		maxHeap.insert(10);
		
		maxHeap.print();

	}

}

/*Output:
Current Max Heap: (size: 10)
10, 8, 9, 6, 5, 3, 7, 4, 2, 1, 

What is the maximum of heap currently? 10

Removing max of heap(root): 10

Current Max Heap: (size: 9)
9, 8, 7, 6, 5, 3, 1, 4, 2, 

Current Max Heap: (size: 11)
22, 10, 7, 6, 9, 3, 1, 4, 2, 5, 8, 
 */






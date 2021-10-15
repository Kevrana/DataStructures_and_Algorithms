package com.tree.completebinary.heap;

import java.util.Arrays;

//Java implementation of the MinHeap data structure.
//MinHeaps are Complete Binary Trees, so every level is filled, top to bottom, left to right
// except the last level which is filled from the left till the last inserted node.
public class MinHeap {
	
	// Instance variables
	int size;
	int[] heap;
	
	public MinHeap(int intialCapacity) {
		size = 0;
		heap = new int[intialCapacity];
	}
	
	
	
	
	// Heap Methods
	
	// Insert Method - inserts node into the heap
	public void insert(int data) {
	
		checkCapacity(); // first, check if capacity is full to resize heap before inserting
		heap[size++] = data; // add item to end of heap and increment size
		heapifyUp(); // will try to move newly added node up until min heap property is restored
	}
	
	// Peek method - gets min of heap
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		return heap[0];
	}
	
	// Delete method - returns the root value and removes it from the heap
	public int poll() {
		if(isEmpty())
			throw new IllegalStateException();
		
		int toDelete = peek(); // store root(min) of heap in a temp
		heap[0] = heap[size-1]; // move the last element to the first
		size--; 
		heapifyDown(); // will try to move new root down until min heap property is restored
		return toDelete;
	}
	
	
	// Heapify Methods 
	
	// HeapifyUp - used when inserting new value in heap,
	// will bubble up value until min heap property is restored
	public void heapifyUp() {
		
		// get the index of recently inserted item
		int index = size -1;
		
		// while the inserted node has a parent and the parent is larger than it, swap them
		while(hasParent(index) && getParent(index) > heap[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index); //  check for each parent
		}
		
	}
	
	// HeapifyDown - used when deleting root(min) value in heap,
	// will sink down value until min heap property is restored
	public void heapifyDown() {
		
		//the index of root, which is holding the recent replacement of recently removed root
		int index = 0;
		
		// while this index has children, swap with the smaller of the 2 children
		while(hasLeftChild(index)) {
			
			// holds the index of the child which has the min value of the 2
			int minChildIndex = getLeftChildIndex(index);
			
			// if right child is smaller than left, right's index becomes minChildIndex
			if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
				minChildIndex = getRightChildIndex(index);
			}
			
			
			// if item is greater than its child, swap to maintain min heap property
			if(heap[index] < heap[minChildIndex]) {
				break;
			}
			else {
				swap(index, minChildIndex);	
			}

			index = minChildIndex;
		}
	}
	
	
	//Helper methods
	
	// prints the heap array
	public void print() {
		System.out.println("Current Min Heap: (size: " + this.size() + ")" );
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
	
	// Swap method - swaps parent node with current node for maintaining min heap property
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
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		// declare and instantiate a min heap with 10 slots.
		MinHeap minHeap = new MinHeap(10);
		
		// insert 10 items into heap
		minHeap.insert(5);
		minHeap.insert(9);
		minHeap.insert(3);
		minHeap.insert(4);
		minHeap.insert(8);
		minHeap.insert(10);
		minHeap.insert(7);
		minHeap.insert(6);
		minHeap.insert(2);
		minHeap.insert(1);
		
		
		// print heap
		minHeap.print();
		
		
		// get the min of heap
		System.out.println("What is the mininum  of heap currently? " + minHeap.peek());
		System.out.println();
		
		// remove the min of heap
		System.out.println("Removing min of heap(root): " + minHeap.poll());
		System.out.println();
	
		// print heap
		minHeap.print();
		
		// check if it heap resizes after inserting past initial capacity of 10
		minHeap.insert(22);
		minHeap.insert(1);
		
		minHeap.print();
		

	}

}

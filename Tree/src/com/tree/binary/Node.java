package com.tree.binary;

import java.util.LinkedList;
import java.util.Queue;


//Binary Tree data structure implementation in java
public class Node {

	int data; // the soul of the node, without a soul, a node is null, in the void, in darkness....
	Node left, right; // left and right child pointers
	Node parent; // pointer to current node's parent
	static int size; // number of nodes in tree
	
	Node(int data){
		this.data = data;
		size++;
	}
	
	// Insert Methods

	// inserts a node to left of current node, and increment size by 1.
	public Node insertLeft(int data) {
		if(this.left == null) {
			this.left = new Node(data);
			this.left.parent = this;
			return this.left;
		}
		else {
			System.out.println("I already have a left child!");
			return null;
		}	
	}
	
	// inserts a node to right of current node, and increment size by 1.
	public Node insertRight(int data) {
		if(this.right == null) {
			this.right = new Node(data);
			this.right.parent = this;
			return this.right;
		}
		else {
			System.out.println("I already have a right child!");
			return null;
		}	
	}
	
	
	// Search Method
	// checks to see if tree contains passed item
	public boolean contains(int data) {
		
		Boolean contains = false;
		
		// base case, checks if current node contains given data
		if(this.data == data) {
			return true;
		}
		
		// check if left sub tree contains data recursively
		if(this.left != null)
			contains = this.left.contains(data);
		
		// check if right sub tree contains data recursively
		if(this.right != null)
			contains = this.right.contains(data);
	
		return contains;
	}
	
	
	
	
	
	
	// Helper methods
	
	// check if this node is the root node
	public boolean isRoot() {
		return this.parent == null;
	}
	
	// check if this node is a leaf node(has no children)
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	
	// prints out the tree
	public void display() {
		
		// first, print current node and its children
		if(this.isLeaf())
			System.out.print(this.data + " => NILL");
		else {
			System.out.print(this.data + " => ");
			if(this.left != null) {
				System.out.print(this.left.data + ", ");
			}
			if(this.right != null) {
				System.out.print(this.right.data + "");
			}
			System.out.println();
		}
			
		if(!this.isLeaf()){
			// then, display the left subtree
			if(this.left != null) {
				this.left.display();
			}
			System.out.println();
			//finally, display the right subtree
			if(this.right != null) {
				this.right.display();

			}
		}
	}
	
	
	// returns the size of the tree
	public static int size() {
		return size;
	}
	
	
	// gets the depth level of the node
	public int getDepth() {
		if(this.isRoot())
			return 0;
		else {
			return 1 + this.parent.getDepth();
		}
	}
	
		
	// get the height level of the node
	public int getHeight() {
		
		
		
		// base case
		if(this.isLeaf()) {
			return 0;
		}
		
		// since we start counting at 0, -1 represents height as null
		int maxHeight = -1;
				
		if(this.left != null) {
			int height = this.left.getHeight();
			if(height > maxHeight)
				maxHeight = height;
		}
		if(this.right != null) {
			int height = this.right.getHeight();
			if(height > maxHeight)
				maxHeight = height;
		}
		
		return maxHeight + 1;
			
	}
	
	
	// Traversals
	
	// Depth First Traversals
	
	// InOrder (LEFT, ROOT, RIGHT):
	public static void inOrder(Node node) {
		
		// base case
		if(node == null)
			return;
		
		// (LEFT) recursively walk current node's left sub tree
		if(node.left != null)
			inOrder(node.left);
		
		// (ROOT) visit and print current node
		System.out.print(node.data + ", ");
		
		
		// (RIGHT) recursively walk current node's right sub tree
		if(node.right != null)
			inOrder(node.right);
	}
	
	
	// PreOrder (ROOT, LEFT, RIGHT):
	public static void preOrder(Node node) {
		
		// base case
		if(node == null)
			return;
		
		// (ROOT) visit and print current node
		System.out.print(node.data + ", ");
		
		// (LEFT) recursively walk current node's left sub tree
		if(node.left != null)
			preOrder(node.left);
		
		// (RIGHT) recursively walk current node's right sub tree
		if(node.right != null)
			preOrder(node.right);
	}
	
	
	
	// PostOrder (LEFT, RIGHT, ROOT):
	public static void postOrder(Node node) {
		
		// base case
		if(node == null)
			return;
		
		// (LEFT) recursively walk current node's left sub tree
		if(node.left != null)
			postOrder(node.left);
		
		// (RIGHT) recursively walk current node's right sub tree
		if(node.right != null)
			postOrder(node.right);
		
		// (ROOT) visit and print current node
		System.out.print(node.data + ", ");
	}
	
	
	
	// Breath First Traversal

	// Level Order Traversal:
	public static void levelOrder(Node root) {
		
		// check if root is null
		if(root == null)
			return;
		
		// Queue to hold nodes 
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			int queueSize = queue.size();
			
			while(queueSize > 0) {
				
				// store the head of the queue in a temp
				Node curr = queue.peek();
				
				// remove the head of queue and print
				System.out.print(queue.remove().data + ", ");
				queueSize--;
				
				// for the node just removed, add all of its children to queue
				if(curr.left != null)
					queue.add(curr.left);
				if(curr.right != null)
					queue.add(curr.right);
				
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		// Create the tree by generating the root node
		Node root = new Node(1); // root node
		
		// inserting of child nodes
		Node node2 = root.insertLeft(2);
		Node node3 = root.insertRight(3);
		
		Node node4 = node2.insertLeft(4);
		Node node5 = node2.insertRight(5);
		
		Node node6 = node5.insertLeft(6);
		Node node7 = node5.insertRight(7);
		
		Node node8 = node3.insertRight(8);
		Node node9 = node8.insertLeft(9);
		Node node10 = node9.insertLeft(10);
		
		System.out.println("The Current Tree (size: " + size()+ "):\n");
		root.display();
		
		// trying to insert another child for node5
		System.out.print("Trying to insert '33' to node5's left: ");
		node5.insertLeft(33);
		System.out.print("Trying to insert '33' to node5's right: ");
		node5.insertRight(33);
		
		System.out.println();
		
		// searching if node exists or not
		System.out.println("Does '8' exist in tree? " + root.contains(8));
		System.out.println("Does '35' exist in tree? " + root.contains(35));
		System.out.println("Does '35' exist in tree? " + root.contains(10));
		
		
		// Heights and depths
		System.out.println("\nHeights/Depths of the Nodes:\n ");
		System.out.println("Root's Height: " + root.getHeight() + ", Depth: " + root.getDepth());
		System.out.println("node2's Height: " + node2.getHeight() + ", Depth: " + node2.getDepth());
		System.out.println("node3's Height: " + node3.getHeight() + ", Depth: " + node3.getDepth());
		System.out.println("node4's Height: " + node4.getHeight() + ", Depth: " + node4.getDepth());
		System.out.println("node5's Height: " + node5.getHeight() + ", Depth: " + node5.getDepth());
		System.out.println("node6's Height: " + node6.getHeight() + ", Depth: " + node6.getDepth());
		System.out.println("node7's Height: " + node7.getHeight() + ", Depth: " + node7.getDepth());
		System.out.println("node8's Height: " + node8.getHeight() + ", Depth: " + node8.getDepth());
		System.out.println("node9's Height: " + node9.getHeight() + ", Depth: " + node9.getDepth());
		System.out.println("node10's Height: " + node10.getHeight() + ", Depth: " + node10.getDepth());
		
		
		
		//Traversals (Note: we removed DD1 node earlier)
		System.out.println();
		System.out.println("TREE TRAVERSALS:");
		
		System.out.println("Depth First Traversals:\n");
		System.out.println("In-Order(LEFT, ROOT, RIGHT): "); 
		inOrder(root);
		System.out.println();
		System.out.println();
		System.out.println("Pre-Order(ROOT, LEFT, RIGHT): "); 
		preOrder(root);
		System.out.println();
		System.out.println();
		System.out.println("Post-Order(LEFT, RIGHT, ROOT): "); 
		postOrder(root);
		
		System.out.println();
		System.out.println("Breath First Traversal:\n");
		System.out.println("Level-Order: "); 
		levelOrder(root);
		
	}
}

/* Output:
The Current Tree (size: 10):

1 => 2, 3
2 => 4, 5
4 => NILL
5 => 6, 7
6 => NILL
7 => NILL
3 => 8

8 => 9, 
9 => 10, 
10 => NILL

Trying to insert '33' to node5's left: I already have a left child!
Trying to insert '33' to node5's right: I already have a right child!

Does '8' exist in tree? true
Does '35' exist in tree? false
Does '35' exist in tree? true

Heights/Depths of the Nodes:
 
Root's Height: 4, Depth: 0
node2's Height: 2, Depth: 1
node3's Height: 3, Depth: 1
node4's Height: 0, Depth: 2
node5's Height: 1, Depth: 2
node6's Height: 0, Depth: 3
node7's Height: 0, Depth: 3
node8's Height: 2, Depth: 2
node9's Height: 1, Depth: 3
node10's Height: 0, Depth: 4

TREE TRAVERSALS:
Depth First Traversals:

In-Order(LEFT, ROOT, RIGHT): 
4, 2, 6, 5, 7, 1, 3, 10, 9, 8, 

Pre-Order(ROOT, LEFT, RIGHT): 
1, 2, 4, 5, 6, 7, 3, 8, 9, 10, 

Post-Order(LEFT, RIGHT, ROOT): 
4, 6, 7, 5, 2, 10, 9, 8, 3, 1, 
Breath First Traversal:

Level-Order: 
1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 
 */


package com.tree.binarysearch;

import java.util.LinkedList;
import java.util.Queue;

// Binary Search Tree data structure implementation in java
public class Node {

	int data; // the soul of the node, without a soul, a node is null, in the void, in darkness....
	Node left, right; // left and right child pointers
	Node parent; // pointer to current node's parent
	static int size; // number of nodes in tree
	
	Node(int data){
		this.data = data;
		size++;
	}
	
	// Insert method - inserts a node into the tree
	public void insert(int data) {
		// if data's value is <= current root's data, insert to left
		if(data <= this.data) {
			if(left == null) {
				left = new Node(data);
				left.parent = this;
			}
			else {
				left.insert(data);
			}
		// else, insert to the right
		}else {
			if(right == null) {
				right = new Node(data);
				right.parent = this;
			} 
			else {
				right.insert(data);
			}
		}	
	}
	
	// Search method - checks to see if node in tree contains the data
	public boolean contains(int data) {
		if(data == this.data) {
			return true;
		}
		else if (data < this.data) {
			if(left == null) {
				return false;
			}
			else {
				return left.contains(data);
			}
		}
		else {
			if(right == null) {
				return false;
			}
			else {
				return right.contains(data);
			}
		}
	}
	
	
	
	// Traversals
	
	// Depth First Traversals
	// InOrder Traversal(LEFT, ROOT, RIGHT)
	public static void inOrder(Node node) {
		// (LEFT) walk left, and recursively perform inOrder on left
		if(node.left != null) {
			inOrder(node.left);
		}
		
		// (ROOT) visit root and print out it's data
		System.out.print(node.data  + ", ");
		
		// (RIGHT) walk right, and recursively perform inOrder on right
		if(node.right != null) {
			inOrder(node.right);
		}	
	}
	
	
	// PreOrder Traversal(ROOT, LEFT, RIGHT)
	public static void preOrder(Node node) {
		
		// (ROOT) visit root and print out it's data
		System.out.print(node.data  + ", ");
				
		// (LEFT) walk left, and recursively perform preOrder on left
		if(node.left != null) {
			preOrder(node.left);
		}
		
		// (RIGHT) walk right, and recursively perform preOrder on right
		if(node.right != null) {
			preOrder(node.right);
		}	
	}
	
	// PostOrder Traversal(LEFT, RIGHT, ROOT)
	public static void postOrder(Node node) {
		
		// (LEFT) walk left, and recursively perform postOrder on left
		if(node.left != null) {
			postOrder(node.left);
		}
		
		// (RIGHT) walk right, and recursively perform postOrder on right
		if(node.right != null) {
			postOrder(node.right);
		}	
		
		// (ROOT) visit root and print out it's data
		System.out.print(node.data  + ", ");
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
	
	
	// Helper methods
	
	// check if this node is the root node
	public boolean isRoot() {
		return parent == null;
	}
	
	// check if this node is a leaf node(has no children)
	public boolean isLeaf() {
		return left == null && right == null;
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
			return 1 + parent.getDepth();
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
				
		if(left != null) {
			int height = left.getHeight();
			if(height > maxHeight)
				maxHeight = height;
		}
		if(right != null) {
			int height = right.getHeight();
			if(height > maxHeight)
				maxHeight = height;
		}
		
		return maxHeight + 1;
			
	}
	
	
	// prints out the tree
	public void display() {
		
		// first, print current node and its children
		if(this.isLeaf())
			System.out.print(data + " => NILL");
		else {
			System.out.print(data + " => ");
			if(left != null) {
				System.out.print(left.data + ", ");
			}
			if(right != null) {
				System.out.print(right.data + "");
			}
			System.out.println();
		}
			
		if(!this.isLeaf()){
			// then, display the left subtree
			if(left != null) {
				left.display();
			}
			System.out.println();
			//finally, display the right subtree
			if(right != null) {
				right.display();

			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		// Create the tree by generating the root node 
		Node root = new Node(4); 
		
		// inserting of child nodes
		root.insert(2);
		root.insert(1);
		root.insert(3);
		root.insert(6);
		root.insert(5);
		root.insert(7);
		
		
		System.out.println("The Current Tree (size: " + size()+ "):\n");
		root.display();
		
		
		System.out.println();
		System.out.println();
		
		// searching if node exists or not
		System.out.println("Does '3' exist in tree? " + root.contains(3));
		System.out.println("Does '8' exist in tree? " + root.contains(8));
		System.out.println("Does '1' exist in tree? " + root.contains(1));
		
		// Heights and depths
		System.out.println("\nHeights/Depths of the Nodes:\n ");
		System.out.println("Root's Height: " + root.getHeight() + ", Depth: " + root.getDepth());
		System.out.println("node2's Height: " + root.left.getHeight() + ", Depth: " + root.left.getDepth());
		System.out.println("node6's Height: " + root.right.getHeight() + ", Depth: " + root.right.getDepth());
		System.out.println("node1's Height: " + root.left.left.getHeight() + ", Depth: " + root.left.left.getDepth());
		System.out.println("node3's Height: " + root.left.right.getHeight() + ", Depth: " + root.left.right.getDepth());
		System.out.println("node5's Height: " + root.right.left.getHeight() + ", Depth: " + root.right.left.getDepth());
		System.out.println("node7's Height: " + root.right.right.getHeight() + ", Depth: " + root.right.right.getDepth());
		
		
		
		
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
		System.out.println();
		System.out.println("Breath First Traversal:\n");
		System.out.println("Level-Order: "); 
		levelOrder(root);
		
		
		

	}

}


/*Output:
The Current Tree (size: 7):

4 => 2, 6
2 => 1, 3
1 => NILL
3 => NILL
6 => 5, 7
5 => NILL
7 => NILL

Does '3' exist in tree? true
Does '8' exist in tree? false
Does '1' exist in tree? true

Heights/Depths of the Nodes:
 
Root's Height: 2, Depth: 0
node2's Height: 1, Depth: 1
node6's Height: 1, Depth: 1
node1's Height: 0, Depth: 2
node3's Height: 0, Depth: 2
node5's Height: 0, Depth: 2
node7's Height: 0, Depth: 2

TREE TRAVERSALS:
Depth First Traversals:

In-Order(LEFT, ROOT, RIGHT): 
1, 2, 3, 4, 5, 6, 7, 

Pre-Order(ROOT, LEFT, RIGHT): 
4, 2, 1, 3, 6, 5, 7, 

Post-Order(LEFT, RIGHT, ROOT): 
1, 3, 2, 5, 7, 6, 4, 

Breath First Traversal:

Level-Order: 
4, 2, 6, 1, 3, 5, 7, 
 */






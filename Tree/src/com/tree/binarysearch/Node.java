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
		// if data's value is <= current node's data, insert to left
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
	
	
	
	// Delete method - delete node that matches given value
	// There are three cases when deleting a node, if node to delete: 
	// Case 1: Is leaf, simply disconnect from tree
	// Case 2: Has 1 child, delete node, and move child up to replace it.
	// Case 3: Has 2 children, find the inorder successor of the node to delete,
	// 			and replace node to delete with that.
	
	public Node deleteNode(int data) {
		
		// if the current node is null, then it means that tree
		// is empty, so nothing to delete
		if(this == null)
			return null;
		
		// if node with data to delete is in left subtree
		else if(data < this.data) {
			this.left = this.left.deleteNode(data);
		}
		// if node with data to delete is in right subtree
		else if(data > this.data) {
			this.right = this.right.deleteNode(data);
		}
		
		// if current node's data matches data  to delete
		else if(data == this.data) {
			// Case 3: node to delete has 2 children
			if(this.left != null && this.right != null) {
				int inOrderSuccessor = getInOrderSuccessor(this.left);
				this.data = inOrderSuccessor;
				this.left = this.left.deleteNode(inOrderSuccessor);
				return this;	
			}
			
			// Case 2: one child (either left or right)
			else if(this.left !=null) {
				size--;
				return this.left;
			}
			
			else if(this.right !=null) {
				size--;
				return this.right;
			}
			
			// Case 1: leaf node, so just make it null
			else {
				size--;
				return null;
			}
			
		}
		return this;
	}
	
	// used by deleteNode() method to get the inorder successor of node being deleted
	public int getInOrderSuccessor(Node node) {
		
		if(node.right != null) {
			return getInOrderSuccessor(node.right);
		}
		else {
			// decrement size by 1
			size--;
			return node.data;
		}
	}
	
	
	// Traversals
	
	// Depth First Traversals
	// InOrder Traversal(LEFT, ROOT, RIGHT)
	public static void inOrder(Node node) {
		
		// base case
		if(node == null)
			return;
		
		// (LEFT) walk left, and recursively perform inOrder on left
		if(node.left != null) {
			inOrder(node.left);
		}
		
		// (ROOT) visit current node and print out it's data
		System.out.print(node.data  + ", ");
		
		// (RIGHT) walk right, and recursively perform inOrder on right
		if(node.right != null) {
			inOrder(node.right);
		}	
	}
	
	// PreOrder Traversal(ROOT, LEFT, RIGHT)
	public static void preOrder(Node node) {
		
		// base case
		if(node == null)
			return;
		
		// (ROOT) visit current node and print out it's data
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
		
		// base case
		if(node == null)
			return;
		
		
		// (LEFT) walk left, and recursively perform postOrder on left
		if(node.left != null) {
			postOrder(node.left);
		}
		
		// (RIGHT) walk right, and recursively perform postOrder on right
		if(node.right != null) {
			postOrder(node.right);
		}	
		
		// (ROOT) visit current node and print out it's data
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
	
	
	// Find the maximum value in the tree,
	// max in a BST will be the further's right Node
	public int findMax() {
		
		// if root node is null, then it is maximum in this tree
		if(this == null)
			return -1;
		
		//Traverse down the right sub tree till end
		Node curr = this;
		while(curr.right != null)
			curr = curr.right;
		
		return curr.data;
	}
	
	// Find the minimum value in the tree,
	// min in a BST will be the further's left Node
	public int findMin() {
	// if root node is null, then it is maximum in this tree
	if(this == null)
		return -1;
	
	//Traverse down the left sub tree till end
		Node curr = this;
		while(curr.left != null)
			curr = curr.left;
		
		return curr.data;
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
		
		
		// Deleting a Node
		System.out.println();
		System.out.println();
		
		System.out.println("The Current Tree (size: " + size()+ "):\n");
		root.display();
		System.out.println();
		System.out.println();
		System.out.println("Deleting node with value '5': ");
		root.deleteNode(5);
		System.out.println();
		System.out.println("The Current Tree (size: " + size()+ "):\n");
		root.display();
		
		
		//Finding the maximum
		System.out.println();
		System.out.println();
		System.out.println("The maximum in this tree is: " + root.findMax());
		
		//Finding the minimum
		System.out.println();
		System.out.println();
		System.out.println("The minimum in this tree is: " + root.findMin());
		
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

The Current Tree (size: 7):

4 => 2, 6
2 => 1, 3
1 => NILL
3 => NILL
6 => 5, 7
5 => NILL
7 => NILL

Deleting node with value '5': 

The Current Tree (size: 6):

4 => 2, 6
2 => 1, 3
1 => NILL
3 => NILL
6 => 7

7 => NILL

The maximum in this tree is: 7


The minimum in this tree is: 1

 */






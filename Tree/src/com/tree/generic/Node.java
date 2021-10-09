package com.tree.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Generic Tree Data Structure implementation in Java
public class Node {

	private String data;
	private Node parent = null;
	private ArrayList<Node> children;
	public static int size;
	
	
	public Node(String data) {
		this.data = data;
		children = new ArrayList<>();
		size++;
	}
	
	// add a child to a node
	public Node addChild(String data) {
		Node childNode = new Node(data);
		childNode.setParent(this);
		this.children.add(childNode);
		return childNode;
	}
	
	// removes a child of current node and decrements size by 1
	public boolean removeChild(Node child) {
		size--;
		return this.children.remove(child);
	}
	
	// returns current # of nodes in tree
	public static int size() {
		return size;
	}
	
	// returns data of the node
	public String getData() {
		return data;
	}

	// sets data to the node
	public void setData(String data) {
		this.data = data;
	}

	// gets the parent of the node
	public Node getParent() {
		return parent;
	}

	// sets the parent of the node
	public void setParent(Node parent) {
		this.parent = parent;
	}

	// returns list of Children nodes of the node
	public ArrayList<Node> getChildren() {
		return children;
	}

	// check if this node is the root node
	public boolean isRoot() {
		return this.getParent() == null;
	}
	
	// check if this node is a leaf node(has no children)
	public boolean isLeaf() {
		return this.children.size() == 0;
	}
	
	// prints out the tree
	public void display() {
		
		// for leaves it will point to null b/c no pointers to children in its list
		if(this.isLeaf())
			System.out.print(this.getData() + " => NILL");
		else
			System.out.print(this.getData() + " => ");
		
		// traverse through current node and print all children
		for(Node node : this.getChildren()) {
			System.out.print(node.getData() + ", ");
		}
		System.out.println();
		
		// recursively call on each child node as long as it isn't a left
		if(!this.isLeaf()) {
			for(Node node : this.getChildren()) {
				node.display();
			}
			
		}
	}
	
	// gets the depth level of the node
	public int getDepth() {
		if(this.isRoot())
			return 0;
		else {
			return 1 + this.getParent().getDepth();
		}
	}
	
		
	// get the height level of the node
	public int getHeight() {
		
		// since we start counting at 0, -1 represents height as null
		int maxHeight = -1;
		
		for(Node node : this.getChildren()) {
			int height = node.getHeight();
			if(height > maxHeight)
				maxHeight = height;
		}
		return maxHeight + 1;
		
		
		
	}
	
	// Depth First Traversals
	
	// InOrder (LEFT, ROOT, RIGHT): A1, A, A2, B1, B, C, ROOT, D1, D2, D, D3
	public static void inOrder(Node node) {
		
		// if node is null, then return
		if(node == null)
			return;
		
		// get the total number of children of given node
		int totalChildren = node.getChildren().size();
		
		// (LEFT) recursively perform an inOrder on all left children nodes
		for(int i = 0; i < totalChildren-1;i++) {
			if(!node.isLeaf())
				inOrder(node.getChildren().get(i));
		}
		
		// (ROOT) print current node's (current root's) data
		System.out.print(node.getData() + ", ");
		
		// (RIGHT) recursively call on right child node
		if(!node.isLeaf())
			inOrder(node.getChildren().get(totalChildren-1));
		
	}
	
	// PreOrder (ROOT, LEFT, RIGHT): ROOT, A, A1, A2, B, B1, C, D, D1, D2, D3
	public static void preOrder(Node node) {
			
		// if node is null, then return
		if(node == null)
			return;
		
		// (ROOT) print current node's (current root's) data
		System.out.print(node.getData() + ", ");
		
		// get the total number of children of given node
		int totalChildren = node.getChildren().size();
		
		// (LEFT) recursively perform a preOrder on all left children nodes
		for(int i = 0; i < totalChildren-1;i++) {
			if(!node.isLeaf())
				preOrder(node.getChildren().get(i));
		}
		
		// (RIGHT) recursively call on right child node
		if(!node.isLeaf())
			preOrder(node.getChildren().get(totalChildren-1));
	}
	
	// PostOrder (LEFT, RIGHT, ROOT): A1, A2, A, B1, B, C, D1, D2, D3, D, ROOT
	public static void postOrder(Node node) {
			
		// if node is null, then return
		if(node == null)
			return;
		
		// get the total number of children of given node
		int totalChildren = node.getChildren().size();
		
		// (LEFT) recursively perform a preOrder on all left children nodes
		for(int i = 0; i < totalChildren-1;i++) {
			if(!node.isLeaf())
				postOrder(node.getChildren().get(i));
		}
		
		// (RIGHT) recursively call on right child node
		if(!node.isLeaf())
			postOrder(node.getChildren().get(totalChildren-1));
		
		
		// (ROOT) print current node's (current root's) data
		System.out.print(node.getData() + ", ");
	}
	
	
	// Breath First Traversal
	
	// Level Order Traversal: ROOT, A, B, C, D, A1, A2, B1, D1, D2, D3
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
				System.out.print(queue.remove().getData() + ", ");
				queueSize--;
				
				// for the node just removed, add all of its children to queue
				for(int i = 0; i < curr.getChildren().size(); i++)
					queue.add(curr.getChildren().get(i));
				
			}
		}
		
		
	}
	

	// execution 
	public static void main(String[] args) {
		
		// Create the tree by generating the root node
		Node root = new Node("ROOT");
		
		
		System.out.println("The Current Tree (size: " + size()+ "):\n");
		root.display();
		
		
		// adding children
		Node nodeA = root.addChild("A");
		Node nodeB = root.addChild("B"); 
		Node nodeC = root.addChild("C");
		Node nodeD = root.addChild("D"); 
		
		System.out.println("\nThe Current Tree (size: " + size()+ "):\n");
		root.display();
		
		
		
		// adding grand children, C never had children :(
		Node nodeA1 = nodeA.addChild("A1");
		Node nodeA2 = nodeA.addChild("A2");
		
		Node nodeB1 = nodeB.addChild("B1");
		
		Node nodeD1 = nodeD.addChild("D1");
		Node nodeD2 = nodeD.addChild("D2");
		Node nodeD3 = nodeD.addChild("D3");
		
		Node nodeDD1 = nodeD3.addChild("DD1");
		
		
		System.out.println("\nThe Current Tree (size: " + size()+ "):\n");
		root.display();
		
		
		// heights and depths of nodes
		System.out.println("\nHeights/Depths of the Nodes:\n ");
		System.out.println("Root's Height: " + root.getHeight() + ", Depth: " + root.getDepth());
		System.out.println("A's Height: " + nodeA.getHeight() + ", Depth: " + nodeA.getDepth());
		System.out.println("A1's Height: " + nodeA1.getHeight() + ", Depth: " + nodeA1.getDepth());
		System.out.println("A2's Height: " + nodeA2.getHeight() + ", Depth: " + nodeA2.getDepth());
		System.out.println("B's Height: " + nodeB.getHeight() + ", Depth: " + nodeB.getDepth());
		System.out.println("B1's Height: " + nodeB1.getHeight() + ", Depth: " + nodeB1.getDepth());
		System.out.println("C's Height: " + nodeC.getHeight() + ", Depth: " + nodeC.getDepth());
		System.out.println("D's Height: " + nodeD.getHeight() + ", Depth: " + nodeD.getDepth());
		System.out.println("D1's Height: " + nodeD1.getHeight() + ", Depth: " + nodeD1.getDepth());
		System.out.println("D2's Height: " + nodeD2.getHeight() + ", Depth: " + nodeD2.getDepth());
		System.out.println("D3's Height: " + nodeD3.getHeight() + ", Depth: " + nodeD3.getDepth());
		System.out.println("DD1's Height: " + nodeDD1.getHeight() + ", Depth: " + nodeDD1.getDepth());
		
		
		// removal of children
		System.out.println();
		System.out.println("Removed Child DD1 of D3: " + nodeD3.removeChild(nodeDD1));
		
		System.out.println("\nThe Current Tree (size: " + size()+ "):\n");
		root.display();
		
		
		// heights and depths of nodes
		System.out.println("\nHeights/Depths of the Nodes:\n ");
		System.out.println("Root's Height: " + root.getHeight() + ", Depth: " + root.getDepth());
		System.out.println("A's Height: " + nodeA.getHeight() + ", Depth: " + nodeA.getDepth());
		System.out.println("A1's Height: " + nodeA1.getHeight() + ", Depth: " + nodeA1.getDepth());
		System.out.println("A2's Height: " + nodeA2.getHeight() + ", Depth: " + nodeA2.getDepth());
		System.out.println("B's Height: " + nodeB.getHeight() + ", Depth: " + nodeB.getDepth());
		System.out.println("B1's Height: " + nodeB1.getHeight() + ", Depth: " + nodeB1.getDepth());
		System.out.println("C's Height: " + nodeC.getHeight() + ", Depth: " + nodeC.getDepth());
		System.out.println("D's Height: " + nodeD.getHeight() + ", Depth: " + nodeD.getDepth());
		System.out.println("D1's Height: " + nodeD1.getHeight() + ", Depth: " + nodeD1.getDepth());
		System.out.println("D2's Height: " + nodeD2.getHeight() + ", Depth: " + nodeD2.getDepth());
		System.out.println("D3's Height: " + nodeD3.getHeight() + ", Depth: " + nodeD3.getDepth());
		
		
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
		System.out.println("Leve-Order: "); 
		levelOrder(root);
	}

}

/*Output:
The Current Tree (size: 1):

ROOT => NILL

The Current Tree (size: 5):

ROOT => A, B, C, D, 
A => NILL
B => NILL
C => NILL
D => NILL

The Current Tree (size: 12):

ROOT => A, B, C, D, 
A => A1, A2, 
A1 => NILL
A2 => NILL
B => B1, 
B1 => NILL
C => NILL
D => D1, D2, D3, 
D1 => NILL
D2 => NILL
D3 => DD1, 
DD1 => NILL

Heights/Depths of the Nodes:
 
Root's Height: 3, Depth: 0
A's Height: 1, Depth: 1
A1's Height: 0, Depth: 2
A2's Height: 0, Depth: 2
B's Height: 1, Depth: 1
B1's Height: 0, Depth: 2
C's Height: 0, Depth: 1
D's Height: 2, Depth: 1
D1's Height: 0, Depth: 2
D2's Height: 0, Depth: 2
D3's Height: 1, Depth: 2
DD1's Height: 0, Depth: 3

Removed Child DD1 of D3: true

The Current Tree (size: 11):

ROOT => A, B, C, D, 
A => A1, A2, 
A1 => NILL
A2 => NILL
B => B1, 
B1 => NILL
C => NILL
D => D1, D2, D3, 
D1 => NILL
D2 => NILL
D3 => NILL

Heights/Depths of the Nodes:
 
Root's Height: 2, Depth: 0
A's Height: 1, Depth: 1
A1's Height: 0, Depth: 2
A2's Height: 0, Depth: 2
B's Height: 1, Depth: 1
B1's Height: 0, Depth: 2
C's Height: 0, Depth: 1
D's Height: 1, Depth: 1
D1's Height: 0, Depth: 2
D2's Height: 0, Depth: 2
D3's Height: 0, Depth: 2

TREE TRAVERSALS:
Depth First Traversals:

In-Order(LEFT, ROOT, RIGHT): 
A1, A, A2, B, B1, C, ROOT, D1, D2, D, D3, 

Pre-Order(ROOT, LEFT, RIGHT): 
ROOT, A, A1, A2, B, B1, C, D, D1, D2, D3, 

Post-Order(LEFT, RIGHT, ROOT): 
A1, A2, A, B1, B, C, D1, D2, D3, D, ROOT, 
Breath First Traversal:

Leve-Order: 
ROOT, A, B, C, D, A1, A2, B1, D1, D2, D3, 
*/



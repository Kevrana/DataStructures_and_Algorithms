package com.tree.generic;

import java.util.ArrayList;

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
		
		
	}

}
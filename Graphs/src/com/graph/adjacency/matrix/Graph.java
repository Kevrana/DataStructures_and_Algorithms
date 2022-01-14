package com.graph.adjacency.matrix;


// Graph data structure implementation represented as an Adjacency Matrix
// and will be assumed as an unweighed directed graph (di-graph)
public class Graph {
	
	private int[][] graph; // the adjacency matrix
	private int size; // the number of vertices in our graph
	
	
	public Graph(int size) {
		this.size = size;
		this.graph = new int[size][size];
	}
	
	//
	private boolean isValidRange(int row, int col) {
		return (row >= 0 && col >= 0) && (row < size && col < size);
	}
	
	public void addEdge(int row, int col) {
		if(isValidRange(row, col)) {
			graph[row][col] = 1;
		}
	}
	
	public void removeEdge(int row, int col) {
		if(isValidRange(row, col)) {
			graph[row][col] = 0;
		}
	}
	
	public int containsEdge(int row, int col) {
		if(isValidRange(row, col)) {
			return graph[row][col];
		}
		return 0;
	}
	
	
	 
	public int getOutDegree(int vertex) {
		int edgeCount = 0;
		if(isValidRange(vertex, vertex)) {
			for(int i = 0; i < size; i++) {
				if(graph[vertex][i] == 1)
					edgeCount += 1;
			}
			return edgeCount;
		}
		return 0;
	}
	
	
	public int getInDegree(int vertex) {
		int edgeCount = 0;
		if(isValidRange(vertex, vertex)) {
			for(int i = 0; i < size; i++) {
				if(graph[i][vertex] == 1)
					edgeCount += 1;
			}
			return edgeCount;
		}
		return 0;
	}
	
	
	
	
	public void printGraph() {
		
		System.out.println("Adjacency graph of size: " + size + "\n");
		
		// prints graph matrix
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(graph[i][j] + " | ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("The vertices and their connections: ");
		// prints connections for each of the vertices
		for(int i = 0; i < size; i++) {
			System.out.print("Vertex '" + i + "' connects to => ");
			for(int j = 0; j < size; j++) {
				if(graph[i][j] == 1)
					System.out.print(j + ", ");
			}
			System.out.println();
		}
		
		
		
	}
	

	public static void main(String[] args) {
		
		// creates and instantiates an adjacency matrix of size 5 (meaning 5 vertices)
		Graph graph = new Graph(5);
		
		// add edges with the source and destination vertices 
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 0);
		graph.addEdge(3, 1);
		graph.addEdge(4, 2);
		
		// print graph
		graph.printGraph();
		
		System.out.println();
		
		// getOutDegree and getInDegree for each of the vertices
		System.out.println("The out-degree for vertex '" + 0 +  "' is: " +  graph.getOutDegree(0));
		System.out.println("The in-degree  for vertex '"  + 0 +  "' is: " +  graph.getInDegree(0));
		System.out.println("The out-degree for vertex '" + 1 +  "' is: " +  graph.getOutDegree(1));
		System.out.println("The in-degree  for vertex '"  + 1 +  "' is: " +  graph.getInDegree(1));
		System.out.println("The out-degree for vertex '" + 2 +  "' is: " +  graph.getOutDegree(2));
		System.out.println("The in-degree  for vertex '"  + 2 +  "' is: " +  graph.getInDegree(2));
		System.out.println("The out-degree for vertex '" + 3 +  "' is: " +  graph.getOutDegree(3));
		System.out.println("The in-degree  for vertex '"  + 3 +  "' is: " +  graph.getInDegree(3));
		System.out.println("The out-degree for vertex '" + 4 +  "' is: " +  graph.getOutDegree(4));
		System.out.println("The in-degree  for vertex '"  + 4 +  "' is: " +  graph.getInDegree(4));
		
		System.out.println();
		// removing edge
		graph.removeEdge(3, 1);
		graph.printGraph();
		
		System.out.println();
		
		System.out.println("The out-degree for vertex '" + 3 +  "' is: " +  graph.getOutDegree(3));
		System.out.println("The in-degree  for vertex '"  + 3 +  "' is: " +  graph.getOutDegree(3));
	}
}


/*
Adjacency graph of size: 5

0 | 1 | 0 | 1 | 1 | 
0 | 0 | 1 | 0 | 1 | 
1 | 0 | 0 | 1 | 0 | 
0 | 1 | 0 | 0 | 0 | 
0 | 0 | 1 | 0 | 0 | 

The vertices and their connections: 
Vertex '0' connects to => 1, 3, 4, 
Vertex '1' connects to => 2, 4, 
Vertex '2' connects to => 0, 3, 
Vertex '3' connects to => 1, 
Vertex '4' connects to => 2, 

The out-degree for vertex '0' is: 3
The in-degree  for vertex '0' is: 1
The out-degree for vertex '1' is: 2
The in-degree  for vertex '1' is: 2
The out-degree for vertex '2' is: 2
The in-degree  for vertex '2' is: 2
The out-degree for vertex '3' is: 1
The in-degree  for vertex '3' is: 2
The out-degree for vertex '4' is: 1
The in-degree  for vertex '4' is: 2

Adjacency graph of size: 5

0 | 1 | 0 | 1 | 1 | 
0 | 0 | 1 | 0 | 1 | 
1 | 0 | 0 | 1 | 0 | 
0 | 0 | 0 | 0 | 0 | 
0 | 0 | 1 | 0 | 0 | 

The vertices and their connections: 
Vertex '0' connects to => 1, 3, 4, 
Vertex '1' connects to => 2, 4, 
Vertex '2' connects to => 0, 3, 
Vertex '3' connects to => 
Vertex '4' connects to => 2, 

The out-degree for vertex '3' is: 0
The in-degree  for vertex '3' is: 0


 */
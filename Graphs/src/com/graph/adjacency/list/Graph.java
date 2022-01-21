package com.graph.adjacency.list;

import java.util.*;


//Graph data structure implementation represented as an Adjacency List
//and will be assumed as an unweighed directed/undirected graph

public class Graph {
	
	Map<String, List<String>> graph; // adjacency list of "string 'vertex' ,list of string vertices" pairs
	
	public Graph() {
		this.graph = new HashMap<>();
	}
	
	// add Node/Vertex method - adds vertex to the adjacency list if it doesn't exist yet
	public void addVertex(String name) {
		graph.put(name, new LinkedList<>());
	}
	
	// remove Vertex/Node method - removes vertex from the adjacency lists of each vertex and 
	// from the graph
	public void removeVertex(String name) {
		
		// remove first from the adjacencyLists of the vertices connecting to this vertex
		for(List<String> adjVertices : graph.values()) {
			if(adjVertices.contains(name)) {
				adjVertices.remove(name);
			}
		}
		
		// then, remove the vertex from the graph
		graph.remove(name);
	}
	
	// checks to see if graph contains the vertex with given name
	public void hasVertex(String name) {
		if(graph.containsKey(name))
			System.out.println("Graph contains '" + name +"' as a vertex");
		else
			System.out.println("Graph doesn't contains '" + name +"' as a vertex");
	}
	
	// get count of vertices of graph
	public void getVertexCount() {
		System.out.println("The # of vertices in this graph are: " + graph.keySet().size());
	}
	
	// adds an edge between two adjacents/vertices
	public void addEdge(String source, String destination, boolean biDirectional) {
	
		if(!graph.containsKey(source))
			addVertex(source);
		
		if(!graph.containsKey(destination))
			addVertex(destination);
		
		graph.get(source).add(destination);
		if(biDirectional)
			graph.get(destination).add(source);
	}
	
	// removes an edge between two adjacents/vertices
	public void removeEdge(String source, String destination) {
		
		List<String> srcToDst = graph.get(source);
		List<String> dstToSrc = graph.get(destination);
		
		if(srcToDst != null)
			srcToDst.remove(destination);
		if(dstToSrc != null)
			dstToSrc.remove(source);
	}
	
	// checks to see if the graphs has an edge between given src and dest in either direction
	public void hasEdge(String src, String dest) {
		if(graph.get(src).contains(dest))
			System.out.println("Graph has an edge between '" + src +"' and '" + dest + "'");
		else if(graph.get(dest).contains(src))
			System.out.println("Graph has an edge between '" + dest +"' and '" + src + "'");
		else
			System.out.println("Graph doesn't have an edge between '" + src +"' and '" + dest +"'");
	}
	
	// get count of vertices of graph
	public void getEdgeCount(boolean biDirectional) {
		int edgeCount = 0;
		
		for(String vertex : graph.keySet()) {
			edgeCount += graph.get(vertex).size();
		}
		
		// if undirected graph
		edgeCount = (biDirectional) ? edgeCount/2 : edgeCount;
		
		System.out.println("The # of edges in this graph are: " + edgeCount);
	}
	
	// returns the adjacency list of a particular vertex with given name
	public List<String> getAdjVertices(String name){
		return graph.get(name);
	}
	
	// print graph
	public void printGraph() {
		
		System.out.println("Graph as Adjacency List of Cast of 'FireFly':\n");
		
		System.out.println("Vertex | Adjacency List");
		for(String vertex : graph.keySet()) {
			System.out.print(vertex + " => ");
			
			for(String adjVertices : graph.get(vertex)) {
				
				System.out.print(adjVertices + ", ");
				
			}
			System.out.println();
		}
		
	}
	

	public static void main(String[] args) {
		
		// create and instantiate a graph
		Graph graph = new Graph();
		
		// add the vertices to the graph - names of Firefly cast
		graph.addVertex("Malcolm");
		graph.addVertex("Wash");
		graph.addVertex("Kaylee");
		graph.addVertex("Inara");
		graph.addVertex("Shepherd");
		graph.addVertex("Simon");
		graph.addVertex("Zoe");
		graph.addVertex("River");
		graph.addVertex("Jayne");
		
		// add edges between characters
		graph.addEdge("Malcolm", "Inara", true);
		graph.addEdge("Inara", "Shepherd", true);
		graph.addEdge("Wash", "Zoe", true);
		graph.addEdge("Wash", "Malcolm", true);
		graph.addEdge("Zoe", "Malcolm", true);
		graph.addEdge("Kaylee", "Simon", true);
		graph.addEdge("Shepherd", "River", true);
		graph.addEdge("Shepherd", "Simon", true);
		graph.addEdge("Shepherd", "Kaylee", true);
		graph.addEdge("Simon", "River", true);
		graph.addEdge("Jayne", "Malcolm", true);
		graph.addEdge("Jayne", "Kaylee", true);
		
		
		// print graph
		graph.printGraph();
		
		System.out.println();
		// get vertex and edge counts
		graph.getVertexCount();
		graph.getEdgeCount(true);
		
		
		// checks to see if vertex exists
		System.out.println();
		graph.hasVertex("Shepherd");
		
		
		// checks to see if vertex exists
		System.out.println();
		graph.hasEdge("Zoe","Wash");
		
		System.out.println();
		System.out.println("Removing Shepherd Brooks....");
		// remove vertex - spoiler of the movie
		graph.removeVertex("Shepherd");
		// print graph
		graph.printGraph();
		
		System.out.println();
		// get vertex and edge counts
		graph.getVertexCount();
		graph.getEdgeCount(true);
		
		// checks to see if vertex exists
		System.out.println();
		graph.hasVertex("Shepherd");
		
		
		// remove edge - spoiler of the movie again
		graph.removeEdge("Zoe","Wash");
		
		System.out.println();
		System.out.println("Removing connection between Zoe and Wash....");
		// print graph
		graph.printGraph();
	
		
		System.out.println();
		// get vertex and edge counts
		graph.getVertexCount();
		graph.getEdgeCount(true);
		
		// checks to see if vertex exists
		System.out.println();
		graph.hasEdge("Zoe","Wash");
		
	}


}

/*
Graph as Adjacency List of Cast of 'FireFly':

Vertex | Adjacency List
Shepherd => Inara, River, Simon, Kaylee, 
Zoe => Wash, Malcolm, 
Kaylee => Simon, Shepherd, Jayne, 
Malcolm => Inara, Wash, Zoe, Jayne, 
Inara => Malcolm, Shepherd, 
Simon => Kaylee, Shepherd, River, 
Wash => Zoe, Malcolm, 
River => Shepherd, Simon, 
Jayne => Malcolm, Kaylee, 

The # of vertices in this graph are: 9
The # of edges in this graph are: 12

Graph contains 'Shepherd' as a vertex

Graph has an edge between 'Zoe' and 'Wash'

Removing Shepherd Brooks....
Graph as Adjacency List of Cast of 'FireFly':

Vertex | Adjacency List
Zoe => Wash, Malcolm, 
Kaylee => Simon, Jayne, 
Malcolm => Inara, Wash, Zoe, Jayne, 
Inara => Malcolm, 
Simon => Kaylee, River, 
Wash => Zoe, Malcolm, 
River => Simon, 
Jayne => Malcolm, Kaylee, 

The # of vertices in this graph are: 8
The # of edges in this graph are: 8

Graph doesn't contains 'Shepherd' as a vertex

Removing connection between Zoe and Wash....
Graph as Adjacency List of Cast of 'FireFly':

Vertex | Adjacency List
Zoe => Malcolm, 
Kaylee => Simon, Jayne, 
Malcolm => Inara, Wash, Zoe, Jayne, 
Inara => Malcolm, 
Simon => Kaylee, River, 
Wash => Malcolm, 
River => Simon, 
Jayne => Malcolm, Kaylee, 

The # of vertices in this graph are: 8
The # of edges in this graph are: 7

Graph doesn't have an edge between 'Zoe' and 'Wash'

 */

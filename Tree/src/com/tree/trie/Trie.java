package com.tree.trie;

import java.util.HashMap;

public class Trie {

	// Internal Trie Node class
	class Node{
		HashMap<Character,Node> children; // links to the children which are char, node pairs
		boolean isCompleteWord; // used to flag an end of a word
		
		Node(){
			children = new HashMap<>();
		}
	}
	
	// Trie instance variable 
	private Node root; 
	
	public Trie() {
		root = new Node();
	}
	
	// Trie Methods
	
	// Insert method - inserts word into the Trie
	public void insert(String word) {
		
		//starting at root
		Node curr = root;
		
		// traverse through each character of given word, 
		// and if not a child of curr, add the char in a new node,
		// and set car to this and continue until end of word
		for(int i = 0; i < word.length(); i++) {
			if(!curr.children.containsKey(word.charAt(i))) {
				curr.children.put(word.charAt(i), new Node());
			}
			curr = curr.children.get(word.charAt(i));
		}
		
		// flag the end of word
		curr.isCompleteWord = true;
		
	}
	
	// Search method - checks to see if a full word exists in trie
	public boolean search(String word) {
		
		// starting at the root
		Node curr = root;
		
		// traverse through each character of given word,
		// and check if that char is a child of curr,
		// if it is, set curr to that char node, and continue until end of word
		// else the char doesn't exist and word isn't in trie
		for(int i = 0; i < word.length(); i++) {
			if(curr.children.containsKey(word.charAt(i))) {
				curr = curr.children.get(word.charAt(i));
			}
			else {
				return false;
			}
		}
		
		// if all characters in word are traversed and now at end of word
		// return true
		if(curr.isCompleteWord)
			return true;
		
		// otherwise that word doesn't exist
		return false;
	}
	
	// Prefix search method - checks to see if a word in the trie starts with given prefix
	public boolean startsWith(String prefix) {
		
		// starting at root
		Node curr = root;
		
		// traverse through each character of given prefix
		// and if it is a child of the curr, set curr to that node
		// and continue until end of prefix
		// else, the prefix doesn't exist in trie
		for(int i = 0; i < prefix.length(); i++) {
			if(curr.children.containsKey(prefix.charAt(i))) {
				curr = curr.children.get(prefix.charAt(i));
			}
			else {
				return false;
			}
		}
		
		// after traversing characters in prefix and they all exist, or empty prefix
		return true;
		
	}
	
	
	// execution
	public static void main(String[] args) {
		
		// declare and instantiate a trie
		Trie trie = new Trie();
		
		// insert
		trie.insert("app");
		trie.insert("apple");
		trie.insert("applet");
		trie.insert("google");
		trie.insert("computer");
		trie.insert("larry");
		trie.insert("mutton");
		trie.insert("cat");
		trie.insert("elephant");
		trie.insert("quick");
		trie.insert("brown");
		trie.insert("fox");
		
		
		// search 
		System.out.println("Does trie contain word 'app':" + trie.search("app"));
		System.out.println("Does trie contain word 'apple':" + trie.search("apple"));
		System.out.println("Does trie contain word 'applet':" + trie.search("applet"));
		System.out.println("Does trie contain word 'appl':" + trie.search("appl"));
		
		
		// search 
		System.out.println("Does trie contain words with prefix 'app':" + trie.startsWith("app"));
		System.out.println("Does trie contain words with prefix 'appl':" + trie.startsWith("appl"));
		System.out.println("Does trie contain words with prefix 'apple':" + trie.startsWith("apple"));
		System.out.println("Does trie contain words with prefix 'applet':" + trie.startsWith("applet"));
		System.out.println("Does trie contain words with prefix 'e':" + trie.startsWith("e"));
		System.out.println("Does trie contain words with empty prefix '':" + trie.startsWith(""));
		System.out.println("Does trie contain words with empty prefix 'fa':" + trie.startsWith("fa"));
		
	}

}

package com.ArrayList;

public class Main {

	public static void main(String[] args) {
	
		ArrayListImp list = new ArrayListImp(3);
		
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		
		
		list.removeAt(3);
		
		
		list.print();
		
		System.out.println(list.indexOf(50));

	}

}

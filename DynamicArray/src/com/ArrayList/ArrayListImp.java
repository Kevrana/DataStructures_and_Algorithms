package com.ArrayList;

public class ArrayListImp {
	
	int[] items;
	int count;
	
	public ArrayListImp(int size) {
		items = new int[size];
		count = 0;
	}
	
	
	// insert method
	public void insert(int item) {
		
		if(count == items.length) {
			
			int[] newArr = new int[count*2];
			
			for(int i = 0; i < count; i++) {
				newArr[i] = items[i];
			}
			
			items = newArr;
		}
		items[count++] = item;
	}
	
	
	
	
	//removeAt method
	public void removeAt(int index) {
		if(index < 0 || index > count) {
			throw new IllegalArgumentException();
		}
		
		for(int i = index; i < count; i++) {
			items[i] = items[i+1];
		}
		count--;

	}
	
	
	
	
	
	
	// indexOf method
	public int indexOf(int item) {
	
		
		for(int i = 0 ; i < count; i++){
			
			if(items[i] == item) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	
	// print method
	public void print() {
		for(int i = 0 ; i < count;i++) {
			System.out.println( items[i] + ", ");
		}
	}
	

}

package com.kevin.Array;

public class Array {
	
	private int[] items;
	private int count; // the current index aka the total number of items in the array currently, not the size
	
	public Array(int size) {
		items = new int[size];
	}
	
	
	public void print() {
		for(int i = 0; i < count; i++) {
			System.out.println(items[i]);
		}
	}
	
	public void insert(int item) {
		
		if(items.length == count) {
			
			int[] newItems = new int[count*2];
			
			for(int i = 0; i < count; i++) {
				newItems[i] = items[i];
			}	
			items = newItems;
		}
		items[count++] = item;	
	}
	
	public void removeAt(int index) {
		
		if(index < 0 || index >= count)
			throw new IllegalArgumentException();
//		//one way
//		int[] newItems = new int[count-1];
//		
//		for(int i = 0, k = 0; i < count; i++) {
//			if(i == index)
//				continue;
//			newItems[k++] = items[i];
//		}
//		
//		items = newItems;
//		count--;
		
		// quicker way, shifting items to left one starting with index being removed.
		for(int i = index; i < count; i++) {
			items[i] = items[i+1];
		}
		count--;
	}

	public int indexOf(int item) {
		
		for(int i = 0; i < count; i++) {
			if( items[i] == item) {
				return i;
			}
		}
		return -1;
	}
	
	
}

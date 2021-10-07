package com.hashtable.openaddressing;


/* HashTable(HashMap) data structure implementation...
 using the following Open-Addressing collision resolution technique: 
 - Linear probing
*/
public class HashTable {

	private Entry[] hashTable; // Hashtable array of type Entry( a string key,value pair)
	private int size; // number of  hashtable buckets/slots/array elements.
	private int itemCount; // number of items currently in the hashtable
	private double loadFactor; // load factor of 0.75 
	
	public HashTable(int initialSize) {
		this.size = initialSize;
		this.hashTable = new Entry[initialSize];
		this.itemCount = 0;
		this.loadFactor = 0.75;
	}
	
	
	// Nested inner class for creating Entries (key,value pairs) for the hash table.
	// Our entries will pair a Person's name with their job title
	public static class Entry {
		String key;
		String value;
		
		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
	
	
	
	
	// ******** Hash Table(Hash Map Methods)**************
	
	// hash function method  - returns the index of the given key based on it's
	// hashCode that is passed in the function to calculate the index.
	public int hashFunction(String key) {
		int hashCode = key.hashCode();
		return Math.abs(hashCode) % hashTable.length;
	}
	
	
	// insert method - adds entry into hash table or if key already exists, 
	// update its value
	public void put(String key, String value) {
		
		if(key == null) {
			System.out.println("Cannot insert entry: (' NULL , " + value + "')... Nulls not allowed in HashTable!");
			return;
		}

		int index = hashFunction(key);
		int startingIndex = index;
		
		
		// if the bucket at index already has data 
		while(hashTable[index] != null) {
			


			// if passed key matches existing key,
			// then we just update it's value with the new value.
			if(hashTable[index].getKey().equals(key)){
				hashTable[index].setValue(value);
				System.out.println("Updated entry: ('" + key + ", " + value + "') @ index: " + index);
				return;
			}
		
			// Otherwise, we have a collision
			System.out.println("Collision! @index: " + index +
					" for Entry('" + key + "', '"+ value + 
					"')! Searching for new location to insert at.....");
			System.out.println();
			
			// apply linear probing technique 
			index = linearProbing(index);
			
			// if Table Full - resize, rehash index, and reset the startingIndex
			if(index == startingIndex) {
				resize();
				index = hashFunction(key);
				startingIndex = index;	
			}
		}
		
		
		
		
		// otherwise, if the bucket at index is null, then insert new Entry
		if(hashTable[index] == null) {
			Entry newEntry = new Entry(key, value);
			hashTable[index] = newEntry;
			System.out.println("Insert entry: ('" + key + ", " + value + "') @ index: " + index);
			itemCount++;
			
			// auto resize if table is 3/4 full
			if(itemCount >= hashTable.length * loadFactor)
				resize();
			
			return;
		}

	}
	
	
	// Access method - returns the value of the given key if it exists in the table
	public String get(String key) {
		
		if(key == null)
			return null;
		
		int index = hashFunction(key);
		int startingIndex = index;
		
		while(hashTable[index] != null) {
			if(hashTable[index].getKey().equals(key)) {
				return hashTable[index].getValue();
			}
			
			// gets next index to try
			index = linearProbing(index);
			
			if(index == startingIndex) {
				return null;
			}
		}
		return null;
	}
	
	
	// Delete method - remove(key) - returns the Entry of given key
	// and set's the element of the index to null again.
	public Entry remove(String key) {
		
		Entry toDelete = null;
		
		if(key == null)
			return toDelete;
				
		int index = hashFunction(key);
		int startingIndex = index;
		
		
		if(!isEmpty()) {
			while(hashTable[index] != null) {
				if(hashTable[index].getKey().equals(key)) {
					toDelete = hashTable[index];
					hashTable[index] = null;
					itemCount--;
				}
				
				index = linearProbing(index);
				
				if(index == startingIndex) {
					return null;
				}
			}
		}
			
		return toDelete;
	}
	
	
	// Search method - contains(key) - 
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	
	
	// ********** Helper Methods ***************************
	
	// empty method - returns true if table is empty
	public boolean isEmpty() {
		return itemCount == 0;
	}
	
	// full method - returns true if table is full
	public boolean isFull() {
		return itemCount == hashTable.length;
	}
	
	// print method-   displays the hash table visually.
	public void print() {
		System.out.println();
		System.out.println("HashTable is: ");
		System.out.println("INDEX | ENTRY ");
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != null)
				System.out.printf("%02d | ('%s', ' %s')\n",
						i, hashTable[i].getKey(), hashTable[i].getValue());
			else {
				System.out.printf("%02d | nil\n", i);
			}
		}
		System.out.println();
		System.out.println();
	}
	
	// size method - returns the number of Entries in the hashtable
	public int size() {
		return itemCount;
	}
	
	// resize method - increases the capacity of the Hash Table
	public void resize() {
		
		System.out.println();
		System.out.println("Resizing...........");
		System.out.println();
		
		int newCapacity = hashTable.length*2;
		Entry[] tempArr = hashTable;
		hashTable = new Entry[newCapacity];
		itemCount = 0;
		
		for(Entry entry: tempArr) {
			if(entry != null)
				put(entry.getKey(), entry.getValue());
		}
	}
	
	// ******* Open Addressing - Collision Resolution Method*******
	
	// Linear Probing Technique
	public int linearProbing(int index) {
		return (index + 1) % hashTable.length;
	}
	
	
	
	// execution
	public static void main(String[] args) {
		
		HashTable ht = new HashTable(7);
		
		System.out.println("********Initial HashTable********");
		ht.print();
		
		System.out.println("********Inserting Entries********\n");
		
		ht.put("Kevin", "Software Engineer");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		ht.put("Glen", "Gardener");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		ht.put("Thomas", "Cashier");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		ht.put("Scully", "Doctor");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		ht.put("Fox", "FBI agent");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		ht.put("Alexandra", "Lawyer");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		ht.put("Lincoln", "Lawyer");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		ht.put("Gandolf", "Wizard");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		
		// insert duplicate key - table should update with new value
		ht.put("Thomas", "Cashier's Manager");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		// try inserting a null
		// insert duplicate key - table should update with new value
		ht.put(null, "unemployed");
		ht.print();
		System.out.println("Current size: " + ht.size());
		
		System.out.println("\n********Accessing Entries********\n");
		
		// this one exists in the table
		System.out.println("Get the job(value) of 'Gandolf': " + ht.get("Gandolf"));
		
		// try to access a name that isn't in the table... "ACCESS DENIED 007!"
		System.out.println("Get the job(value) of 'Bond': " + ht.get("Bond"));
		
	
		System.out.println("\n********Searching Entries********\n");
		
		// this doesn't exist in the table, James Bond is a mystery!
		System.out.println("Does 'Bond' exist in table? " + ht.contains("Bond"));
		
		
		
		// this one does exist in the table
		System.out.println("Does 'Glen' exist in table? " + ht.contains("Glen"));
		
		System.out.println("\n********Deleting Entries********\n");
		
		System.out.println("Current size: " + ht.size());
		System.out.println("Removed entry's value of 'Thomas' from the table: " + ht.remove("Thomas").getValue());
		ht.print();
		System.out.println("Current size: " + ht.size());
	}

}

/*Output:
********Initial HashTable********

HashTable is: 
INDEX | ENTRY 
00 | nil
01 | nil
02 | nil
03 | nil
04 | nil
05 | nil
06 | nil


********Inserting Entries********

Insert entry: ('Kevin, Software Engineer') @ index: 6

HashTable is: 
INDEX | ENTRY 
00 | nil
01 | nil
02 | nil
03 | nil
04 | nil
05 | nil
06 | ('Kevin', ' Software Engineer')


Current size: 1
Insert entry: ('Glen, Gardener') @ index: 5

HashTable is: 
INDEX | ENTRY 
00 | nil
01 | nil
02 | nil
03 | nil
04 | nil
05 | ('Glen', ' Gardener')
06 | ('Kevin', ' Software Engineer')


Current size: 2
Collision! @index: 6 for Entry('Thomas', 'Cashier')! Searching for new location to insert at.....

Insert entry: ('Thomas, Cashier') @ index: 0

HashTable is: 
INDEX | ENTRY 
00 | ('Thomas', ' Cashier')
01 | nil
02 | nil
03 | nil
04 | nil
05 | ('Glen', ' Gardener')
06 | ('Kevin', ' Software Engineer')


Current size: 3
Collision! @index: 0 for Entry('Scully', 'Doctor')! Searching for new location to insert at.....

Insert entry: ('Scully, Doctor') @ index: 1

HashTable is: 
INDEX | ENTRY 
00 | ('Thomas', ' Cashier')
01 | ('Scully', ' Doctor')
02 | nil
03 | nil
04 | nil
05 | ('Glen', ' Gardener')
06 | ('Kevin', ' Software Engineer')


Current size: 4
Collision! @index: 5 for Entry('Fox', 'FBI agent')! Searching for new location to insert at.....

Collision! @index: 6 for Entry('Fox', 'FBI agent')! Searching for new location to insert at.....

Collision! @index: 0 for Entry('Fox', 'FBI agent')! Searching for new location to insert at.....

Collision! @index: 1 for Entry('Fox', 'FBI agent')! Searching for new location to insert at.....

Insert entry: ('Fox, FBI agent') @ index: 2

HashTable is: 
INDEX | ENTRY 
00 | ('Thomas', ' Cashier')
01 | ('Scully', ' Doctor')
02 | ('Fox', ' FBI agent')
03 | nil
04 | nil
05 | ('Glen', ' Gardener')
06 | ('Kevin', ' Software Engineer')


Current size: 5
Insert entry: ('Alexandra, Lawyer') @ index: 4

Resizing...........

Insert entry: ('Thomas, Cashier') @ index: 6
Insert entry: ('Scully, Doctor') @ index: 0
Insert entry: ('Fox, FBI agent') @ index: 5
Insert entry: ('Alexandra, Lawyer') @ index: 4
Insert entry: ('Glen, Gardener') @ index: 12
Insert entry: ('Kevin, Software Engineer') @ index: 13

HashTable is: 
INDEX | ENTRY 
00 | ('Scully', ' Doctor')
01 | nil
02 | nil
03 | nil
04 | ('Alexandra', ' Lawyer')
05 | ('Fox', ' FBI agent')
06 | ('Thomas', ' Cashier')
07 | nil
08 | nil
09 | nil
10 | nil
11 | nil
12 | ('Glen', ' Gardener')
13 | ('Kevin', ' Software Engineer')


Current size: 6
Insert entry: ('Lincoln, Lawyer') @ index: 1

HashTable is: 
INDEX | ENTRY 
00 | ('Scully', ' Doctor')
01 | ('Lincoln', ' Lawyer')
02 | nil
03 | nil
04 | ('Alexandra', ' Lawyer')
05 | ('Fox', ' FBI agent')
06 | ('Thomas', ' Cashier')
07 | nil
08 | nil
09 | nil
10 | nil
11 | nil
12 | ('Glen', ' Gardener')
13 | ('Kevin', ' Software Engineer')


Current size: 7
Insert entry: ('Gandolf, Wizard') @ index: 7

HashTable is: 
INDEX | ENTRY 
00 | ('Scully', ' Doctor')
01 | ('Lincoln', ' Lawyer')
02 | nil
03 | nil
04 | ('Alexandra', ' Lawyer')
05 | ('Fox', ' FBI agent')
06 | ('Thomas', ' Cashier')
07 | ('Gandolf', ' Wizard')
08 | nil
09 | nil
10 | nil
11 | nil
12 | ('Glen', ' Gardener')
13 | ('Kevin', ' Software Engineer')


Current size: 8
Updated entry: ('Thomas, Cashier's Manager') @ index: 6

HashTable is: 
INDEX | ENTRY 
00 | ('Scully', ' Doctor')
01 | ('Lincoln', ' Lawyer')
02 | nil
03 | nil
04 | ('Alexandra', ' Lawyer')
05 | ('Fox', ' FBI agent')
06 | ('Thomas', ' Cashier's Manager')
07 | ('Gandolf', ' Wizard')
08 | nil
09 | nil
10 | nil
11 | nil
12 | ('Glen', ' Gardener')
13 | ('Kevin', ' Software Engineer')


Current size: 8
Cannot insert entry: (' NULL , unemployed')... Nulls not allowed in HashTable!

HashTable is: 
INDEX | ENTRY 
00 | ('Scully', ' Doctor')
01 | ('Lincoln', ' Lawyer')
02 | nil
03 | nil
04 | ('Alexandra', ' Lawyer')
05 | ('Fox', ' FBI agent')
06 | ('Thomas', ' Cashier's Manager')
07 | ('Gandolf', ' Wizard')
08 | nil
09 | nil
10 | nil
11 | nil
12 | ('Glen', ' Gardener')
13 | ('Kevin', ' Software Engineer')


Current size: 8

********Accessing Entries********

Get the job(value) of 'Gandolf': Wizard
Get the job(value) of 'Bond': null

********Searching Entries********

Does 'Bond' exist in table? false
Does 'Glen' exist in table? true

********Deleting Entries********

Current size: 8
Removed entry's value of 'Thomas' from the table: Cashier's Manager

HashTable is: 
INDEX | ENTRY 
00 | ('Scully', ' Doctor')
01 | ('Lincoln', ' Lawyer')
02 | nil
03 | nil
04 | ('Alexandra', ' Lawyer')
05 | ('Fox', ' FBI agent')
06 | nil
07 | ('Gandolf', ' Wizard')
08 | nil
09 | nil
10 | nil
11 | nil
12 | ('Glen', ' Gardener')
13 | ('Kevin', ' Software Engineer')


Current size: 7
*/
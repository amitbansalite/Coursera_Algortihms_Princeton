package SymbolTables;

// API for implementing key-value pairs
	// 1) using unordered link list
	// 2) using ordered array and binary search
	// 3) using binary tree



// associative array abstraction : one value with each array entry

//Conventions:
	//	value are not null
	//  method get() returns null if key is not present
	//	method put() overrides old with new
		
		

public class ST_API<Key extends Comparable<Key>, Value> {
	
	public ST_API(){}
	
	public void put(Key key, Value val){
		
	}
	
	public Value get(Key key){
		return null;
	}
	
	public void delete(Key key){
		// lazy delete : put(key,null);
		
	}
	
	public boolean contains(Key key){
		return get(key)!= null;
	}
	
	public boolean isEmpty(){
		return false;
	}
	
	public int size(){
		return 0;
	}

	Key min(){
		return null;
	}
	
	Key max(){
		return null;
	}
	
	Key floor(Key key){
		return null;
	}
	
	Key ceiling(Key key){
		return null;
	}
	
	void deleteMin(){
		
	}
	
	void deleteMax(){
		
	}
	
	// num of keys less than given key
	int rank(Key key){
		return 0;
	}
	
	Key selecy(int k){
		return null;
	}
	
	
	
	public Iterable<Key> keys(){
		return null;
	}
	
	public Iterable<Key> keys(Key a, Key b){
		return null;
	}
}

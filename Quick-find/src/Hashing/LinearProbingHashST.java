package Hashing;

// Array size M must be greater than number of key-value pairs N
	// will need to implement resizing and good to maintain at least HALF EMPTY


public class LinearProbingHashST<Key, Value> {

	private int M = 30001;
	private Value[] vals = (Value[]) new Object[M];
	private Key[] keys = (Key[]) new Object[M];
	
	//TODO : implement resizing array in get and put
	
	private int hash(Key key){
		return (key.hashCode() & 0xfffffff) % M;
	}
	
	public void put(Key key, Value val){
		int i;
		
		for ( i = hash(key); keys[i] != null; i = (i+1) % M){
			if (keys[i].equals(key))
				break;		
		}
		keys[i] = key;
		vals[i] = val;
	}
	
	public Value get(Key key){
			
		for ( int i = hash(key); keys[i] != null; i = (i+1) % M ){
			if (key.equals(keys[i]))
				return vals[i];
		}
		return null;		
	}
	
	
}

package Hashing;

// typical choice M ~ N/5;


public class SeparateChainingHashST<Key, Value> {
	
	private int M = 97;
	private Node[] st = new Node[M];
	
	private static class Node{
		private Object key;				// as no generic array creation
		private Object val;				// declare key and value of type objects
		private Node next;		
		
		public Node(Object key, Object val, Node x){
			this.key = key;
			this.val = val;
			this.next = x;
		}
	}
	
	private int hashcode(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(Key key, Value val){
		int i = hashcode(key);
		for (Node x = st[i]; x!=null; x = x.next){
			if (key.equals(x.key)){
				x.val = val;
				return;
			}
		}
		st[i] = new Node(key, val, st[i]); 	// put the new node at beginning of st[i]
	}
	
	public Value get(Key key){
		int i = hashcode(key);
		for (Node x = st[i]; x != null; x = x.next){
			if (x.key == key)
				return (Value) x.val;
		}
		return null;
	}
}

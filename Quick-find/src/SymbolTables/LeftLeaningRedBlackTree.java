package SymbolTables;

public class LeftLeaningRedBlackTree<Key extends Comparable<Key>, Value> {
	
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		Key key;
		Value value;
		Node left, right;
		boolean color;		
		int N;             // subtree count
		
		public Node(Key key, Value value, boolean color, int N){
			this.key = key;
			this.value = value;
			this.color = color;
			this.N = N;
		}
	}
	
	private boolean isRed(Node x){
		if (x == null) return false;
		return x.color == RED;
	}
	
	private int size(Node x){
		if (x == null)	return 0;
		return x.N;
	}
	
	public Value get(Key key){		
		Node x = root;
		while(x != null){
			int cmp = key.compareTo(x.key);
			if      (cmp < 0)	x = x.left;
			else if (cmp > 0)	x = x.right;
			else if ( cmp == 0)	return x.value;
		}		
		return null;
	}
	
	// Orient a (temporarily) right leaning red link to lean left
	// maintains symmetric order and perfect black balance
	private Node rotateLeft(Node h){
		assert isRed(h.right);
		
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;		
	}
	
	// Orient a left leaning link to (temporarily) lean right
	// maintains symmetric order and perfect black balance
	private Node rotateRight(Node h){
		assert isRed(h.left);
		
		Node x = h.left;
		h.left = x;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;		
	}
	
	// Recolor to split a (temporary) 4-node
	// maintains symmetric order and perfect black balance
	private void flipColors(Node h){
		assert !isRed(h);
		assert isRed(h.left);
		assert isRed(h.right);
		
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;		
	}

	public void put(Key key, Value val){
		root = put(root, key, val);
		root.color = BLACK;
	}	
	
	private Node put(Node h, Key key, Value val){

		if (h == null) return new Node(key, val, RED, 1);
		
		int cmp = key.compareTo(h.key);
		if 		(cmp < 0) h.left = put(h.left, key, val);
		else if (cmp > 0) h.right = put(h.right, key, val);
		else if (cmp ==0) h.value = val;
		
		if (isRed(h.right) && !isRed(h.left))	 h = rotateLeft(h);
		
		if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))	 flipColors(h);
		
		h.N = size(h.left) + size(h.right) + 1;
		
		return h;
	}
	
	public void deleteMin(){
		if (root == null) return;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

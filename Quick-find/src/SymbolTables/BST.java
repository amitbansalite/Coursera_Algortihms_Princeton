package SymbolTables;

import edu.princeton.cs.algs4.Queue;

// num of compares depends on how the keys are inserted as that determines the shape of the BST

// for the same set of the keys, many different BST can be created 

// IMP : there is correspondence between BSTs and quicksort partitioning


public class BST<Key extends Comparable<Key>, Value>{

	private Node root;

	private class Node {

		private Key key;
		private Value value;
		private Node left, right;		
		private int count;

		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
		}
	}
	
	public void put(Key key, Value val){
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val){
		
		if(x == null) return new Node(key, val);
		int cmp = key.compareTo(x.key);
		
		if 		(cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else if (cmp == 0)
			x.value = val;
		
		// maintain the size of subtree in every node
		x.count = 1 + size(x.left) + size(x.right);
		
		return x;
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
		
	// using Queue data structure and the proof is by induction 
	public Iterable<Key> iterator(){
		Queue<Key> q = new Queue<Key>();
		inorder(root, q);
		return q;
	}
	
	// inorder traversal of a BST yields keys in ascending order
	private void inorder(Node x, Queue<Key> q){
		if ( x ==null ) return;
		
		inorder(x.left, q);
		q.enqueue(x.key);
		inorder(x.right, q);		
	}
	
	// inorder traversal : without using recursion
	private void inorder_constantSpace(Node x, Queue<Key> q){
			if ( x ==null ) return;
			
			inorder(x.left, q);
			q.enqueue(x.key);
			inorder(x.right, q);		
	}
		
	public int size(){
		return size(root);		
	}
	
	private int size(Node x){
		if (x==null)	return 0;
		return x.count;
	}
	
	// balance goes bad in BST because of this 'Hibbard' deletion which  favors the successor
	// takes care of : (a) no right child (b) right child using a deleteMin(Node x) method  
	public void delete(Key key){
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key){
		if (x == null) return null;
		
		int cmp = key.compareTo(x.key);
		
		if (cmp < 0) 
			x.left = delete(x.left, key);
		else if( cmp > 0)
			x.right = delete(x.right, key);
		else{
			if(x.right == null)
				return x.left;
			
			// if right child exists then find the successor and replace with it 
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;			
		}
		x.count = size(x.left) + size(x.right) + 1;
		return x;		
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x){
		if (x == null) return null;
		
		if (x.left == null) return x.right;		
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;		
	}
		
	public Key floor(Key key){
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
				
	}
	
	private Node floor(Node x, Key key){
		if ( x == null)
			return null;
		int cmp = key.compareTo(x.key);
		
		if (cmp < 0)
			return floor(x.left, key);
		
		Node t = floor(x.right, key);
		if(t != null)
			return t;
		else
			return x;					
	}	
	
	// how many keys < k ?
	public int rank(Key key){
		return rank(key, root);
	}
	
	private int rank(Key key, Node x){
		if (x == null)	return 0;
		
		int cmp = key.compareTo(x.key);
		
		if (cmp < 0)
			return rank(key, x.left);		
		else if (cmp > 0)
			return 1 + size(x.left) + rank(key, x.right);		
		else if (cmp ==0)
			return size(x.left);
		
		return 0;
	}
	
	// range search : how many elements between x and y
	public int size(Key lo, Key hi){
		if(contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo); 
	}
	
	
	public boolean contains(Key key){
		return false;
	}
	
	public Node min(){
		return min(root);
	}	
	
	private Node min(Node x){
		if( x == null) return null;
		
		Node t = x;
		while(t.left != null){
			t = t.left;
		}		
		return t;
	}
}

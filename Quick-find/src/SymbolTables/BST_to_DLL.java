package SymbolTables;

public class BST_to_DLL {

	private class Node{
		int data;
		Node left, right;
	} 		
	
	// Attach node b after Node a
	public void Add(Node a, Node b){
		a.right = b;
		b.left = a;
	}
	
	// a and b are circular dll, join them and return new list
	public Node Join(Node a, Node b){
		
		if ( a == null) return b;
		if ( b == null) return a;
		
		Node aLastNode = a.left;
		Node bLastNode = b.left;
		
		Add(aLastNode, b);
		Add(bLastNode, a);
		
		return a;		
	}	
	
	// divide n conquer mechanism
	public Node treeToDll(Node node){
		
		if ( node == null) return null;
		
		Node aList = treeToDll(node.left);
		Node bList = treeToDll(node.right);
		
		node.left = node;
		node.right = node;
		
		aList = Join(aList, node);
		aList = Join(aList, bList);		
		
		return aList;
	}
	
	
	// Easier to follow : InOrder traversal mechanism
	// invoked as (root, null, null)
	public void treeToDll_Inorder(Node current, Node prev, Node head){		
		if ( current == null)
			return;
		
		// explore left side as InOrder
		treeToDll_Inorder(current.left, prev, head);
		
		current.left = prev;
		
		if ( prev == null){
			head = current;			
		}
		else{
			prev.right = current;			
		}
			
		// following 3 lines of code is only required if : required to make double LL circular
		Node right = current.right;
		head.left = current;
		current.right = head;
		
		// explore right side as InOrder
		prev = current;
		treeToDll_Inorder(right, prev, head);		
	}	
}

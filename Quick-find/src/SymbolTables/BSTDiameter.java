package SymbolTables;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.algs4.BST;

public class BSTDiameter {

	/* Write your custom functions here */
	static int diameterOfTree(Node root) {
	   
	    if (root == null)
	        return 0;

			int lHeight = height(root.left);
			int rHeight = height(root.right);
			
	        int lDiameter = diameterOfTree(root.left);
	        int rDiameter = diameterOfTree(root.right);
	    
	    	return max(1+lHeight+rHeight, max(lDiameter,rDiameter));   
	}


	public static int height(Node root){

	    if (root == null)
	        return 0;
	    
	    return 1 + max(height(root.left), height(root.right));
	}

	public static int max(int a, int b){

	    return a >= b ? a : b;
	}

	
}

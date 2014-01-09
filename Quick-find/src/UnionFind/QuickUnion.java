package UnionFind;

import edu.princeton.cs.introcs.StdOut;

// also equally slow as QuickFindUF though easy to implement
//all operations takes O(N) time

public class QuickUnion {
	
	private int[] id;
	
	QuickUnion(int n){
		id = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
		}		
	}
	
	void display(){
		for(int i=0; i< id.length; i++){
			StdOut.println(id[i] + " ");
		}
	}
	
	private int root(int i){
		while( i != id[i])
			 i = id[i];
		return i;		
	}
	
	void union(int p, int q){
		int i = root(p);
		int j = root(q);
		
		id[i] = j;
	}
	
	boolean connected(int p, int q){	
		return root(p) == root(q);
	}
}

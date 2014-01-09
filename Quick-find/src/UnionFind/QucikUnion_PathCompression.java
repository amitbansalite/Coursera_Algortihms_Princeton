package UnionFind;

import edu.princeton.cs.introcs.StdOut;

// only finding root code changes as we can point each node to its grand father
// and keep shortening the tree height

// 

public class QucikUnion_PathCompression {
	private int[] id;
	private int[] sz;
	
	QucikUnion_PathCompression(int n){
		id = new int[n];
		sz = new int[n];
		
		for(int i = 0; i < n; i++){
			id[i] = i;
			sz[i] = 1;
		}		
	}
	
	void display(){
		StdOut.println("\n element : root : # of elements");
		for(int i=0; i< id.length; i++){
			StdOut.println(i + " : " + id[i] + " : " + sz[i]);
		}
	}
	
	private int root(int i){
		while( i != id[i]){
			id[i] = id[id[i]];
			i = id[i];	
		}			
		return i;		
	}
	
	void union(int p, int q){
		int i = root(p);
		int j = root(q);
		
		if(sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}else{
			id[j] = i;	
			sz[i] += sz[j];
		}		
	}
	
	boolean connected(int p, int q){	
		return root(p) == root(q);
	}
}

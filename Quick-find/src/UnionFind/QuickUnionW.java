package UnionFind;

import edu.princeton.cs.introcs.StdOut;

// uses more space to store the size of each tree, 
// so that tree is more balanced and root of smaller tree changes 

// union logic is important,
	// 1. find root of both vertex to be connected
	// 2. find size of which one is smaller
	// 3. change root of smaller to higher
	// 4. increment size(larger_root) += size(smaller_root)

// find and union will take lg(N) time

public class QuickUnionW {
	private int[] id;
	private int[] sz;
	
	QuickUnionW(int n){
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
		while( i != id[i])
			 i = id[i];
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

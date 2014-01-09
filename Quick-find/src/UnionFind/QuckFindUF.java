package UnionFind;

import edu.princeton.cs.introcs.StdOut;

// most basic implementation, very simple but slow
// all operations takes O(N) time


public class QuckFindUF {
	
	private int[] id;
	
	QuckFindUF(int n){
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
	
	
	void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		
		for(int i=0; i< id.length; i++){
			if(id[i] == pid)
				id[i] = qid;
		}
	}
	
	boolean connected(int p, int q){	
		return id[p] == id[q];
	}
}

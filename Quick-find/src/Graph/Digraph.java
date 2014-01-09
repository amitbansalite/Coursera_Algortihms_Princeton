package Graph;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.introcs.StdOut;

//API for directed graphs with Adjacency-list representation

public class Digraph {

	private final int v;
	private Bag<Integer>[] adj; 
	
	public Digraph(int v){
		this.v = v;
		adj = (Bag<Integer>[]) new Bag[v];
		for ( int i=0; i < v; i++)
			adj[i] = new Bag<Integer>();
	}
	
	
	// adj[v] list stores all edges going from v 
	// to find the edges coming into v, one would need to scan through all the lists in adj[i]
	public void addEdge(int v, int w){
		adj[v].add(w);						
	}										 
	
	Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V(){ 
		return v;
	}
	
	public int E(){ 		
		int count = 0;
		for ( int w = 0 ; w < V(); w++){
			count += adj[w].size();
		}
		return count;
	}
	
	public Digraph reverse(){ return null;}
	
	public String toString(){
		return "";
	}
	
	public void main(String[] args){
		
		Digraph G = new Digraph(10);
		
		for (int v=0; v < G.V(); v++){
			for ( int w : G.adj(v))
				StdOut.println(v + "->" + w);
		}		
	}
}

package Graph;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.introcs.*;

// API for graphs with Adjacency-list representation

//every vertex is maintaining a list of every other vertex it is connected to
	//since undirected, each edge appears twice

public class Graph {

	private final int V;
	private Bag<Integer>[] adj;
	
	// create an empty graph with N vertices
	public Graph(int V){
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v< V; v++){
			adj[v] = new Bag<Integer>();
		}
	}
	
	void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	// number of vertices
	public int V(){		
		return V;
	}
	
	// number of edges
	public int E(){
		int count = 0;
		for ( int v=0; v< V; v++){
			count += adj[v].size();
		}
		return count/2;				// each edge will be counted twice
	}
	
	// vertices adjacent to V
	public Iterable<Integer> adj(int v){		
		return adj[v];
	}
	
	// number of vertices a vertex is connected to
	public int degree(int v){
		int degree = 0;
		for ( int w : adj(v))
			degree++;
		return degree;
	}
	
	public int maxDegree(){
		int max = 0;
		
		for(int v=0; v < V(); v++){
			if ( degree(v) > max)
				max = degree(v);
		}
		return max;		
	}
	
	public double averageDegree(){
		return 2.0* E()/V();
	}
	
	public int numOfSelfLoops(){
		int count=0;
		
		for ( int i=0; i< V(); i++){
			for ( int w : adj(i)){
				if ( w == i)
					count++;
			}
		}
		return count/2;			// each edge will be counted twice
	}
	
	public void main(String[] args){
		In in = new In(args[0]);
		Graph G = new Graph(10);
		
		for (int v = 0; v < G.V(); v++)
			for (int w : G.adj(v))
				StdOut.println(v + "-" + w);
		
	}
	
}

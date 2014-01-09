package Graph_MST;

import edu.princeton.cs.algs4.*;
// every vertex is maintaining a list of every other vertex it is connected to
	// since undirected, each edge appears twice

public class EdgeWeightedGraph {

	private final int V;
	private int E;
	private Bag<Edge>[] adj; 
	
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for ( int i=0; i<V; i++)
			adj[i] = new Bag<Edge>();
	}
	
	void addEdge(Edge e){
		int v = e.either();
		int w = e.other(v);
		
		adj[v].add(e);
		adj[w].add(e);		
	}
	
	public int V(){		
		return V;
	}
	
	public int E(){
		int count = 0;
		for ( int v=0; v< V; v++){
			count += adj[v].size();
		}
		return count/2;				// each edge will be counted twice
	}
	
	// vertices adjacent to V
	public Iterable<Edge> adj(int v){		
		return adj[v];
	}
	
	
	// returning all edges in the graph only once
	// parallel edges and self loops are permitted in the graph	
	public Iterable<Edge> edges(){
		Bag<Edge> list = new Bag<Edge>();
		
		for ( int i=0; i<V; i++){
			int selfLoops = 0;
			
			for ( Edge e : adj(i)){
				if ( e.other(i) > i)
					list.add(e);
				// only add one copy of each self loop
				else if ( e.other(i) == i){
					if ( selfLoops % 2 == 0)
						list.add(e);
					selfLoops++;
				}				
			}		
		}
		return list;
	}
}

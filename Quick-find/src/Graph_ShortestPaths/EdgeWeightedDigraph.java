package Graph_ShortestPaths;

import edu.princeton.cs.algs4.Bag;

// allow self loops and parallel edges
// adjacency list representation

public class EdgeWeightedDigraph {

	public final int V;
	public int E;
	public Bag<DirectedEdge>[] adj;
	
	
	public EdgeWeightedDigraph(int V){
		this.E = 0;
		this.V = V;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for ( int i=0; i<V; i++)
			adj[i] = new Bag<DirectedEdge>();		
	}
	
	public int V(){
		return V;
	}
	
	public void addEdge(DirectedEdge edge){
		int v = edge.from();
		adj[v].add(edge);		
	}
	
	public int E(){
		int count = 0;
		
		for ( int i=0; i<V; i++ ){
			for( DirectedEdge e : adj[i]){
				count++;
			}
		}
		return count;
	}
	
	public Iterable<DirectedEdge> adj(int i){
		return adj[i];
	}
	
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> list = new Bag<DirectedEdge>();
		
		for ( int i=0; i<V; i++){
			for ( DirectedEdge edge : adj[i]){
				list.add(edge);				
			}
		}
		return list;
	}
	
	public String toString(){
		return null;
	}	
}

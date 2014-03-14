package Graph_ShortestPaths;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

// shortest path from given vertex to all other vertices in directed edge weighted graph
// no non-negative weights in the directed graph

// points to note:

	// 1. I am using a normal PQ and reinserting many vertices more than once in the relax() method
		// hence length of PQ while initializing is G.E() and NOT G.V()

	// 2. to avoid the above, one should use PQ_with_Key_Update capability so that 
		// if a vertex already exists then just update the key instead of inserting a new entry
		// then while initializing PQ one can use G.V() as length
			

	// 3. if using binary heap implementation for PQ, not much difference in timings in above 2 cases 

public class DijkstraSP {

	private class Vertex{
		private int v;
		private double minDist;
				
		public Vertex(int v, double weight){
			this.v = v;
			this.minDist = weight;
		}
		
		public int vertex(){
			return v;
		}
		
		public double minDist(){
			return minDist;
		}
	}
	
	public double[] distTo;
	public DirectedEdge[] edgeTo;
	public MinPQ<Vertex> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s){
		edgeTo = new DirectedEdge[G.V()];
		edgeTo[s] = null;
		
		distTo = new double[G.V()];
		for(int i=0; i<G.V(); i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		
		pq = new MinPQ<Vertex>(G.E());
		pq.insert(new Vertex(s,0.0));
		
		while( !pq.isEmpty()){			
			int v = pq.delMin().vertex();			
			for (DirectedEdge e : G.adj(v))
				relax(e);
		}	
	}
	
	public void relax(DirectedEdge e){
		int v = e.from(), w = e.to();
		
		if ( distTo[w] > distTo[v] + e.weight()){
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			
			pq.insert(new Vertex( w, distTo[w] ));
		}
	}	
	
	public double distTo(int v){
		return distTo[v];
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		
		for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
			path.push(e);
		}
		return path;
	}
}

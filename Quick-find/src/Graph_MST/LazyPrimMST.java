package Graph_MST;

import edu.princeton.cs.algs4.*;

// A lot easier to understand than Kruskal' algo.
  
//Basic Algorithm
//1. Start with vertex 0 and greedily grow tree T
//2. Add to T the min weight edge with exactly one end point in T
//3. Repeat until V-1 edges

//lazy approach : we allow edge to be on the PQ even though we know it is obsolete 

//ElogE execution time and extra space proportional to E (because all edges could be on PQ)

public class LazyPrimMST {
	
	private boolean[] marked;		// will be used to remember which vertices are already on MST
	private Queue<Edge> mst;		// resulting MST will reside in the form of a Queue
	private MinPQ<Edge> pq;
	
	public LazyPrimMST(EdgeWeightedGraph G ){
		
		pq = new MinPQ<Edge>();
		mst = new Queue<Edge>();
		marked = new boolean[G.V()];
		visit(G,0);
		
		while( !pq.isEmpty() && mst.size() < G.V() -1){
			
			Edge e = pq.delMin();
			int v = e.either(); 
			int w = e.other(v);
			
			if (marked[v] && marked[w])			// ignore if both edges of the min edge is already on MST
				continue;
			
			mst.enqueue(e);						
			
			if (!marked[v])
				visit(G,v);
			if (!marked[w])
				visit(G,w);			
		}				
	}
	
	public void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		
		for ( Edge e : G.adj(v)){
			if ( !marked[e.other(v)])
				pq.insert(e);
		}
	}
	
	public Iterable<Edge> mst(){
		return mst;
	}	
}

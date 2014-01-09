package Graph;

import edu.princeton.cs.algs4.*;

// Start with vertex 0 and grow tree T greedily
// Add to T the min weight edge with exactly one endpoint in T
// Repeat until V-1 edges


// LAZY approach : edges which has both vertex already in the mst are still on the PQ and not removed
	// time proportional to ELogE and takes space proportional to E


// EAGER approach : For each non-tree vertex v, at most one entry in PQ 
				// (with key equal to the weight of the cheapest edge from v to the tree).
	// figure out the algorithm

public class PrimsMST {

	private boolean[] marked;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;
	
	public void LazyPrimsMst(EdgeWeightedGraph G){
		
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		Visit(G, 0);
		
		while(!pq.isEmpty()) {
			Edge e = pq.delMin();
			int v = e.either(); 
			int w = e.other(v);
			
			if (marked[v] && marked[w])
				continue;
			mst.enqueue(e);
			if ( !marked[v])
				Visit(G, v);
			if ( !marked[w])
				Visit(G, w);
		}		
	}
	
	private void Visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		
		for ( Edge e : G.adj(v)){
			if (! marked[e.other(v)] )
				pq.insert(e);
		}
	}
	
	public Iterable<Edge> mst(){
		return mst;
	}
}

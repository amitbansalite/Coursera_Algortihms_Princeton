package Graph_MST;

import edu.princeton.cs.algs4.*;

// sort the edges by weight in ascending order
// take the next edge and add it to the tree T unless doing so would create a cycle

// ElogE execution time


public class KruskalMST {

	private Queue<Edge> mst = new Queue<Edge>();
	
	public KruskalMST(EdgeWeightedGraph G){
		
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for ( Edge e : G.edges()){
			pq.insert(e);
		}
		
		UF uf = new UF(G.V());
		
		while ( !pq.isEmpty() && mst.size() < G.V() -1){
			
			Edge e = pq.delMin();
			int v = e.either(); 
			int w = e.other(v);
			
			if ( !uf.connected(v, w)) {
				uf.union(v, w);
				mst.enqueue(e);
			}			
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
}

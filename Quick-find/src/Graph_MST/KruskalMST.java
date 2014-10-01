package Graph_MST;

import edu.princeton.cs.algs4.*;


/*Given a connected, undirected graph, a spanning tree of that graph is a subgraph that is a tree and 
 * connects all the vertices together. 
 * We can also assign a weight to each edge, and use this to assign a weight to a spanning tree by 
 * computing the sum of the weights of the edges in that spanning tree. 
 * 
 * A minimum spanning tree is with weight less than or equal to the weight of every other spanning tree. 
*/

// 1. sort the edges by weight in ascending order
// 2. take the next edge from MinPQ  (in ascending order of edge weight)
// 3. add it to the tree T unless doing so would create a cycle

// How to check for cycle?
	// use UF data structure as it is easy to determine if 2 vertices are already connected or not
	// if not connected, no cycle , hence add it to the resulting Queue

// when to stop the loop?
	// when we have a V-1 edges, hence all points are accounted for once.

// ElogE execution time


public class KruskalMST {

	private Queue<Edge> mst = new Queue<Edge>();
	
	public KruskalMST(EdgeWeightedGraph G){
		
		// since <Edge> is comparable (look at the implementation), it can used in MinPQ
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

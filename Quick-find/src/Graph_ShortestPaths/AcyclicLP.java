package Graph_ShortestPaths;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Topological;


// same as AcyclicSP 
// only difference is start with -ve infinity and update distTo[] when even longer path is found


public class AcyclicLP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
						 
	public AcyclicLP(EdgeWeightedDigraph G, int s){
		edgeTo = new DirectedEdge[G.V()];
		edgeTo[s] = null;
		
		distTo = new double[G.V()];
		for(int i=0; i<G.V(); i++)
			distTo[i] = Double.NEGATIVE_INFINITY;
		distTo[s] = 0.0;
		
		Topological topological = new Topological(G);
		for ( int v : topological.order())
			for ( DirectedEdge e : G.adj(v))
				relax(e);		
	}
	
	private void relax(DirectedEdge e){
		int v = e.from(), w = e.to();
		
		if ( distTo[w] < distTo[v] + e.weight()){
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}		
	}
}

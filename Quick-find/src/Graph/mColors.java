package Graph;

import edu.princeton.cs.algs4.Queue;

// Given an undirected graph and a number m, 
	//determine if the graph can be colored with at most m colors such that 
		// no two adjacent vertices of the graph are colored with same color.


public class mColors {
	private int[] color;
	private int n;
	
	public mColors(Graph G, int n){
		color = new int[G.V()];
		
		for ( int i=0; i<G.V(); i++)
			color[i] = 0;
		
		this.n = n;
		graphColoringUtil(G, 0);
	}
	
	private void PrintColors(){
		
	}
	
	private boolean isSafe(Graph G, int vertex, int colorToPut){
		
		for( int x : G.adj(vertex)){
			if (color[x] == colorToPut)
				return false;
		}		
		return true;
	}
	
	private void graphColoringUtil(Graph G, int vertex){
		for ( int i=1; i <= n; i ++)
		{	
			if ( isSafe(G, vertex, i))
			{
				color[vertex] = i;

				if ( vertex == G.V())
				{
					PrintColors();
					return;
				}

				graphColoringUtil(G, vertex+1);
				color[vertex] = 0;			
			}
		}
	}
}

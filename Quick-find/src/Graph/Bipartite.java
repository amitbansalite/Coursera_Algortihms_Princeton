package Graph;

// again can be done using dfs

public class Bipartite {

	private boolean[] marked;
	private boolean[] color;
	private int s;	
	
	public Bipartite(Graph G, int s){
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		
		this.s = s;	
		isBipartite(G, s);
	}
	
	private boolean isBipartite(Graph G, int s){
		marked[s] = true;
		color[s] = true;
		return isBipartite(G, s, false);
	}
	
	private boolean isBipartite(Graph G, int s, boolean col){	
		
		for ( int w : G.adj(s)){
			
			if (!marked[w]){
				color[w] = col;
				isBipartite(G, w, !col);			
			}	

			if ( color[w] == color[s] )
				return false;
		}
		
		return true;		
	}
	
}

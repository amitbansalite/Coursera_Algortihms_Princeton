package Graph;

import edu.princeton.cs.algs4.*;

// put unvisited vertices on a stack
// works for both undirected and directed graph

public class DepthFirstPaths {

	private boolean[] marked;			// marked[v] = true , if v is connected to s
	private int[] edgeTo;				// edgeTo[v] = previous vertex on path from s to v
	private int s;
	
	public DepthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		dfs(G,s);
	}
	
	private void dfs(Graph G, int v){		
		marked[v] = true;		
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
				edgeTo[w] = v;
			}
		}		
	}
	
	private void nonRecursiveDFS_Algo(Graph G, int v){
		/*list node_to_visit = root;
		while( node_to_visit is not empty)
			currentNode = node_to_visit.first()
			node_to_visit.prepend( currentNode.children )
			do something*/
	}
	
	
	// is there a path from vertex s to vertex v
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	// print the path from vertex s to vertex v
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;		
	}
}

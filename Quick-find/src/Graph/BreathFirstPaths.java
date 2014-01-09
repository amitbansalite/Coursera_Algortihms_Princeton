package Graph;

import edu.princeton.cs.algs4.*;

// put unvisited vertices on a queue
// works for both undirected and directed graph
// bfs also finds the Shortest path to all vertices from s in time proportional to E + V

public class BreathFirstPaths {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private int s;
	
	public BreathFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s){
		int distance = 0;
		Queue<Integer> q = new Queue<Integer>();
		
		q.enqueue(s);
		edgeTo[s] = s;
		marked[s] = true;
		distTo[s] = distance;
		
		while(!q.isEmpty()){
			int x = q.dequeue();
			for (int v : G.adj(x)){
				if (!marked[v]){
					q.enqueue(v);
					marked[v] = true;
					edgeTo[v] = x;
					distTo[v] = distTo[x] + 1;
				}				
			}			
		}
	}
	
	private void nonRecursiveBFS_Algo(Graph G, int v){
		/*list node_to_visit = root;
		while( node_to_visit is not empty)
			currentNode = node_to_visit.first()
			node_to_visit.append( currentNode.children )
			do something*/
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]){
			path.push(edgeTo[x]);
		}
		path.push(s);
		return path;		
	}

}

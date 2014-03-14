package Graph;

import edu.princeton.cs.algs4.*;


// works only on DAG : directed acyclic graph

// topological sort : redraw a DAG so that all edges point upwards
// how it works : run dfs and put every vertex which is done on stack

//many applications like finding in which order to take courses, given many courses and the inter-dependencies among them
	// given many tasks to be completed with precedence constraints, determine in which order to execute tasks 

public class TopologicalSort {

	private boolean[] marked;
	private Stack<Integer> reversePost;

	public TopologicalSort(Digraph G) {
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for (int w = 0; w < G.V(); w++) {
			if (!marked[w])
				dfs(G, w);
		}

	}

	private void dfs(Digraph G, int s){
		marked[s] = true;
		for ( int w : G.adj(s)){
			if (!marked[w])
				dfs(G,w);			
		}
		reversePost.push(s);
	}

	public Iterable<Integer> reversePost(){
		return reversePost;
	}	
}


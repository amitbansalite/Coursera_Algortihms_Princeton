package Graph;

// figure out if graph is DAG or not
// use stack

public class DirectedCycle {

	private boolean[] marked;
	private boolean[] onStack;
	private boolean hasCycle;

	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		onStack = new boolean[G.V()];
		hasCycle = false;
		
		for (int w = 0; w < G.V(); w++) {
			if (!marked[w])
				dfs(G, w);
		}

	}
	
	private void dfs(Digraph G, int s){
		marked[s] = true;
		onStack[s] = true;
		
		for ( int w : G.adj(s)){
			if (!marked[w]){
				dfs(G,w);
			}
			if ( onStack[w]){
				hasCycle = true;
				return;
			}
		}		
		onStack[s] = false;
	}
	
	public boolean containsCycle(){
		return hasCycle;
	}
}

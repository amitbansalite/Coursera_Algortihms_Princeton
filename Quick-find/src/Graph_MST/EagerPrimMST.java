package Graph_MST;

//Basic Algorithm
//1. Start with vertex 0 and greedily grow tree T
//2. Add to T the min weight edge with exactly one end point in T
//3. Repeat until V-1 edges


// Eager approach : For each non-tree vertex v, at most one entry is present in the PQ 
					// (with key equal to the weight if the cheapest edge from v to the tree.) 

//ElogV execution time and extra space proportional to E (because all edges could be on PQ) : one of the best algorithm for MST

public class EagerPrimMST {
		// ????
		// need to understand the index based PQ which allows to alter the priority of Key
}

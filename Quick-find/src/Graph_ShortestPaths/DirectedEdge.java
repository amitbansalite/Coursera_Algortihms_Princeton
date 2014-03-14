package Graph_ShortestPaths;

public class DirectedEdge {

	public final int v, w;
	public final double weight;
	
	public DirectedEdge(int from, int to, double weight){
		this.v = from;
		this.w = to;
		this.weight = weight;		
	}
	
	public int from(){
		return v;		
	}
	
	public int to(){
		return w;
	}
	
	public double weight(){
		return weight;
	}	
}

import java.util.Comparator;

//find a solution to the initial board (using the A* algorithm)
// use Manhattan priority
public class Solver {	
	private Board initial;	
	private int totalMoves;
	private Node finalNode;

	private class Node{
		private Board board;
		private int moves;
		private int priority;	
		private Node previous;		
		public final Comparator<Node> ORDER = new Compare2Nodes();				    
	}	

	private class Compare2Nodes implements Comparator<Node> {	
		public int compare(Node node1, Node node2) {
			if (node1.priority - node2.priority < 0)
				return -1;
			if (node1.priority - node2.priority > 0)
				return +1;
			else{
				if ( node1.moves - node2.moves < 0) {
					return +1;
				}
				if ( node1.moves - node2.moves > 0) {
					return -1;
				}
			}
			return 0;
		}
	};	

	public Solver(Board initial){    	
		this.initial = initial; 
		totalMoves=0;
		finalNode = null;
	}

	// is the initial board solvable : use 2 priority queues
	public boolean isSolvable() {
		return (isSolvable(initial));		
		/*if(!flag)
			return isSolvable(initial.twin());
		return flag;*/
	}

	private boolean isSolvable(Board board){
		MinPQ<Node> minPQ = new MinPQ<Node>(new Compare2Nodes());    	
		
		// enter the initial board onto the minPQ and gameTree
		Node rootNode = new Node();
		rootNode.board = board;
		rootNode.moves = 0;
		rootNode.priority = rootNode.board.manhattan() + rootNode.moves;    	 
		rootNode.previous = null;
		minPQ.insert(rootNode);
		
		while (!minPQ.isEmpty()) {
			
			Node searchNode = minPQ.delMin();
			if (searchNode.board.isGoal()){
				finalNode = searchNode;
				totalMoves = searchNode.moves;
				return true;
			}
			for (Board b : searchNode.board.neighbors()) {
				Node neighborNode = new Node();
				neighborNode.board = b;
				neighborNode.moves = searchNode.moves + 1;
				neighborNode.priority = neighborNode.board.manhattan() + neighborNode.moves;
				neighborNode.previous = searchNode;

				if (! neighborNode.board.equals(searchNode.previous) )
					minPQ.insert(neighborNode);
			}
		}	
		totalMoves = -1;
		return false;
	}

	// min number of moves to solve initial board; -1 if no solution
	public int moves() {  	
		return totalMoves;
	}

	// sequence of boards in a shortest solution; null if no solution
	public Iterable<Board> solution() {    	
		if(totalMoves == -1)
			return null;

		Stack<Board> st = new Stack<Board>();    	
		Node node = finalNode;    	
		while(node != null){
			st.push(node.board);    		
			node = node.previous;    		
		}
		return st;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		int N = in.readInt();
		int[][] blocks = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				blocks[i][j] = in.readInt();
		Board initial = new Board(blocks);

		// solve the puzzle
		Solver solver = new Solver(initial);

		// print solution to standard output
		if (!solver.isSolvable())
			StdOut.println("No solution possible");
		else {
			StdOut.println("Minimum number of moves = " + solver.moves());
			for (Board board : solver.solution())
				StdOut.println(board);
		}
	}    
}


public class Board {
	
	private int dimension;
	private int[][] tiles;
	private int blankRow;
	private int blankColumn;
	//private int manhattanValue;

	 public Board(int[][] blocks){
	
		 dimension = blocks.length;
		 tiles = new int[dimension][dimension];
		 
		 for (int i = 0; i < dimension; i++)
		        for (int j = 0; j < dimension; j++){
		            tiles[i][j] = blocks[i][j];
		            if(blocks[i][j] == 0){
		            	blankRow = i;
		            	blankColumn = j;
		            }
		        }
	 }
	 
	 /*private Board(int[][] blocks, int manhattanValue){
		 this(blocks);
		 this.manhattanValue = manhattanValue;		 
	 }*/
	 
	 public int dimension(){
		 return dimension; 
	 }
	 
	// number of blocks out of place
	 public int hamming() {
		 
		 int count = 0;
		 
		 for (int i = 0; i < dimension; i++)
		        for (int j = 0; j < dimension; j++)
		        {
		        	if(tiles[i][j] != 0){
		        		if ( (i*dimension + j + 1) != tiles[i][j])
		        			count++;
		        	}
		        }
		 return count;
	 }

	 // sum of Manhattan distances between blocks and goal
	 public int manhattan() {

		 int count = 0;

		 for (int i = 0; i < dimension; i++)
			 for (int j = 0; j < dimension; j++)
			 {
				 if(tiles[i][j] != 0){
					 int actualValue = i*dimension + j + 1;
					 int currentValue = tiles[i][j];

					 if ( actualValue != currentValue)
					 {
						 // where should the currentValue be located : row(m), column(n)
						 int m = currentValue / dimension;
						 int n = currentValue % dimension;
						 if (n == 0){
							 m--;
							 n = dimension-1;
						 }
						 else
							 n--;
						 
						 // add the distance of (m,n) from (i,j) to the count
						 count += Math.abs(m-i) + Math.abs(n-j);
					 }
				 }
			 }
		 return count;
	 }
	 
	 private int getManhattanValueForGivenCell(int row, int col, int val){
		 
		 return 0;
	 }
	 
	// is this board the goal board?
	 public boolean isGoal() {
		 
		 for (int i = 0; i < dimension; i++)
		        for (int j = 0; j < dimension; j++)
		        {
		        	if(tiles[i][j] != 0){
		        		if ( (i*dimension + j + 1) != tiles[i][j])
		        			return false;
		        	}
		        }
		 
		 return true;
	 }
	 
	 private int[][] getDuplicate(int[][] input){
		 
		 int[][] copy = new int[dimension][dimension];
		 
		 for (int i = 0; i < dimension; i++)
		        for (int j = 0; j < dimension; j++)
		            copy[i][j] = tiles[i][j];
		 
		 return copy;
	 }
	 
    //  a board obtained by exchanging two adjacent blocks in the same row
	 public Board twin() {
		 int[][] twinTiles = getDuplicate(this.tiles);
		 Board twin = new Board(twinTiles);
		 
		 if (blankRow == 0){
			 int tmp = twin.tiles[1][0];
			 twin.tiles[1][0] = twin.tiles[1][1];
			 twin.tiles[1][1] = tmp;			  
		 }
		 else{
			 int tmp = twin.tiles[0][0];
			 twin.tiles[0][0] = twin.tiles[0][1];
			 twin.tiles[0][1] = tmp;			
		 }
		 return twin;
	 }
	 
	 public boolean equals(Object other) {
		 if (other == this) return true;
		 if (other == null) return false;
	     if (other.getClass() != this.getClass()) return false;
	     
	     Board otherBoard = (Board) other;
	     
	     if(otherBoard.blankRow != this.blankRow) return false;
	     if(otherBoard.blankColumn != this.blankColumn) return false;	 
	     
	     for (int i = 0; i < dimension; i++) 
		        for (int j = 0; j < dimension; j++) 
		        {		        	
		        	if (otherBoard.tiles[i][j] != this.tiles[i][j])
		        		return false;
		        }	        
	     return true;
	 }
	 
	// all neighboring boards
	 public Iterable<Board> neighbors() {	 
		 
		 Queue<Board> q = new Queue<Board>();
		 //int manhattanValue = this.manhattan();
		 
		 if (blankRow-1 >= 0){
			 int[][] n = getDuplicate(this.tiles);
			 //int neighborManhattanValue = manhattanValue - getManhattanValueForGivenCell(blankRow-1, blankColumn, n[blankRow-1][blankColumn]);
			 
			 n[blankRow][blankColumn] = n[blankRow-1][blankColumn];
			 n[blankRow-1][blankColumn] = 0;
			 
			 //neighborManhattanValue = manhattanValue + getManhattanValueForGivenCell(blankRow, blankColumn, n[blankRow][blankColumn]);			 
			 Board neighbor = new Board(n);			 
			 q.enqueue(neighbor);
		 }
		 
		 if (blankRow+1 < dimension){
			 int[][] n = getDuplicate(this.tiles);
			 n[blankRow][blankColumn] = n[blankRow+1][blankColumn];
			 n[blankRow+1][blankColumn] = 0;
			 
			 Board neighbor = new Board(n);			 
			 q.enqueue(neighbor);
		 }
		 
		 if (blankColumn-1 >= 0){
			 int[][] n = getDuplicate(this.tiles);
			 n[blankRow][blankColumn] = n[blankRow][blankColumn-1];
			 n[blankRow][blankColumn-1] = 0;

			 Board neighbor = new Board(n);			 
			 q.enqueue(neighbor);
		 }
		 
		 if (blankColumn+1 < dimension){
			 int[][] n = getDuplicate(this.tiles);
			 n[blankRow][blankColumn] = n[blankRow][blankColumn+1];
			 n[blankRow][blankColumn+1] = 0;

			 Board neighbor = new Board(n);			 
			 q.enqueue(neighbor);
		 }
		 
		 return q;	 
	 }	 
	 
	// string representation of the board (in the output format specified below)
	 public String toString() {		 
		 StringBuilder s = new StringBuilder();
		    s.append(dimension + "\n");
		    
		    for (int i = 0; i < dimension; i++) {
		        for (int j = 0; j < dimension; j++) {
		            s.append(String.format("%2d ", tiles[i][j]));
		        }
		        s.append("\n");
		    }
		    return s.toString();
	 }
	 
	 public static void main(String[] args) {
	    	In in = new In(args[0]);
		    int N = in.readInt();
		    int[][] blocks = new int[N][N];
		    for (int i = 0; i < N; i++)
		        for (int j = 0; j < N; j++)
		            blocks[i][j] = in.readInt();
		    
		    Board initial = new Board(blocks);
		    
		    StdOut.println("\n Blank row : " + initial.blankRow);
		    StdOut.println("\n Blank column : " + initial.blankColumn);
		    StdOut.println("\n Dimension : " + initial.dimension());
		    StdOut.println("\n Manhattan priority : " + initial.manhattan());
		    StdOut.println("\n Hamming priority : " + initial.hamming());
		    StdOut.println("Is goal : " + initial.isGoal());
		    
		    StdOut.println("\n Initial : \n " + initial.toString());		    
		    Board twin = initial.twin();
		    StdOut.println("\n Twin : \n " + twin.toString());
		    
		    StdOut.println("\n Initial and twin are equal : " + initial.equals(twin));
		    
		    for (Board b : initial.neighbors()){
		    	StdOut.println("\n Initial and neighbor are equal : " + initial.equals(b));
		    	StdOut.println(b);		    
		    }
	 } 
}
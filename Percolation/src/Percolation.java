// 1) can water flow from a matrix from top to bottom
// 2) can electricity conduct from a matrix of non conductors

// there are many industry applications for Percolation : 
		// where given a matrix,  at random cells are opened up and 
		// connected to adjacent(top/bottom or left/right) open cells, 
		// what is the threshold of cells to be opened up for percolation to happen
		// given fairly large N and enough # of experiments T 

public class Percolation {
	
	private WeightedQuickUnionUF grid;
	private WeightedQuickUnionUF backWashGrid;
	private boolean[] openSites;
	
	private int gridSize;
	private int lastElement;	
	
	// create N-by-N grid, with all sites blocked
	public Percolation(int n){
		gridSize = n;		
		lastElement = n*n + 1;
		grid = new WeightedQuickUnionUF(lastElement + 1);
		backWashGrid = new WeightedQuickUnionUF(lastElement);
		
		openSites = new boolean[lastElement];				
		for(int i=0; i<lastElement; i++){
				openSites[i] = false;
		}
	}
	
	private int xyTo1d(int i, int j){		
		return (i-1)*gridSize + j;
	}
	
	private void indexBounds(int i, int j){
		if(i <= 0 || i > gridSize)
			throw new IndexOutOfBoundsException(" row index i is out of bounds");		
		if(j <= 0 || j > gridSize)
			throw new IndexOutOfBoundsException(" column index j is out of bounds");		
	}
	
	// open site (row i, column j) if it is not already
	public void open(int i, int j){		
		indexBounds(i,j);
		int currentCell = xyTo1d(i,j);
		
		if(! isOpen(i,j) ){
			openSites[currentCell] = true;
						
			if(i == 1){
				grid.union(0, currentCell);
				backWashGrid.union(0, currentCell);
			}
			if(i == gridSize){
				grid.union(currentCell, lastElement);
			}
			
			if( j-1 > 0 && isOpen(i, j-1) ){
				grid.union(xyTo1d(i,j-1), currentCell);
				backWashGrid.union(xyTo1d(i,j-1), currentCell);
			}
			if( i-1 > 0 && isOpen(i-1,j)){
				grid.union(xyTo1d(i-1,j), currentCell);
				backWashGrid.union(xyTo1d(i-1,j), currentCell);
			}
			if( j+1 <= gridSize && isOpen(i, j+1)){
				grid.union(xyTo1d(i, j+1), currentCell);
				backWashGrid.union(xyTo1d(i, j+1), currentCell);
			}
			if( i+1 <= gridSize && isOpen(i+1, j)){
				grid.union(xyTo1d(i+1,j), currentCell);
				backWashGrid.union(xyTo1d(i+1,j), currentCell);
			}		
		}		
	}
	
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j){	
		indexBounds(i,j);
		int currentCell = xyTo1d(i,j);		
		return openSites[currentCell];
	}
	
	// is site (row i, column j) full?
	public boolean isFull(int i, int j){		
		indexBounds(i,j);		
		return backWashGrid.connected(0, xyTo1d(i,j));		
	}
	
	// does the system percolate?
	public boolean percolates(){
		return grid.connected(0, lastElement);
	}
	
	// test client, described below
		public static void main(String[] args){				
			    if(args.length <1){
			    	throw new IllegalArgumentException("There should be 2 arguments");
			    }
			    
			    int N = 0;
			    try {
			        N = Integer.parseInt(args[0]);
			    } catch (NumberFormatException e) {
			    	throw new IllegalArgumentException("N and T must be an integer");
			    }	    
			   
			    Percolation percolationGrid = new Percolation(N);
		  		int openSitesCount = 0;
		  		
		  		StdOut.print("grid size = " + N + "\n");
		  		
			    while(! percolationGrid.percolates()){	    		
			    	int x = StdRandom.uniform(N) + 1;
			    	int y = StdRandom.uniform(N) + 1;
			    	
			    	if( !percolationGrid.isOpen(x, y)){
			    		percolationGrid.open(x, y);
			    		openSitesCount++;		    		
			    	}			    	
			    }		
			    
			    StdOut.print("\n isOpen(10,1) : " + percolationGrid.isOpen(10, 1) + " isFull(10,1) : " + percolationGrid.isFull(10,1));
			    StdOut.print("\n isOpen(10,2) : " + percolationGrid.isOpen(10, 2) + " isFull(10,2) : " + percolationGrid.isFull(10,2));
			    StdOut.print("\n isOpen(10,3) : " + percolationGrid.isOpen(10, 3) + " isFull(10,3) : " + percolationGrid.isFull(10,3));
			    StdOut.print("\n isOpen(10,4) : " + percolationGrid.isOpen(10, 4) + " isFull(10,4) : " + percolationGrid.isFull(10,4));
			    StdOut.print("\n isOpen(10,5) : " + percolationGrid.isOpen(10, 5) + " isFull(10,5) : " + percolationGrid.isFull(10,5));
			    StdOut.print("\n isOpen(10,6) : " + percolationGrid.isOpen(10, 6) + " isFull(10,6) : " + percolationGrid.isFull(10,6));
			    
			    StdOut.print("\n threshold value = " + openSitesCount + "\n");
			    StdOut.print("\n Done calculating \n");
		}
}
public class PercolationStats {
	private double[] thresholdValues;
	private int gridSize;
	private int expCount;
	
	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T){
		 if( N <=0 || T <= 0){
		    	throw new IllegalArgumentException("N and T must be greater than 0");
		    }	    
		   
		gridSize = N;
		expCount = T;
		thresholdValues = new double[expCount];
		for(int i=0; i<expCount; i++){
			thresholdValues[i]=0;
		}
		
		performPercolationExp();		 
	}
	 
	private void performPercolationExp(){			    		
		StdRandom.setSeed(gridSize);
		    
		    for(int i=0; i<expCount; i++){		    	
		    	Percolation percolationGrid = new Percolation(gridSize);
		    	double openSitesCount = 0;
		    	
		    	while(! percolationGrid.percolates()){	    		
			    	int x = StdRandom.uniform(gridSize) + 1;
			    	int y = StdRandom.uniform(gridSize) + 1;
			    	
			    	if( !percolationGrid.isOpen(x, y)){
			    		percolationGrid.open(x, y);
			    		openSitesCount++;
			    	}			    	
			    }		    	
		    	thresholdValues[i] = openSitesCount / (gridSize * gridSize) ;
		    }
	}
	
	// sample mean of percolation threshold
	public double mean(){		
		return StdStats.mean(thresholdValues);
	}
	   
	// sample standard deviation of percolation threshold
	public double stddev(){
		if(expCount == 1) return Double.NaN;
		
		return StdStats.stddev(thresholdValues);
	}
	   
	// returns lower bound of the 95% confidence interval
	public double confidenceLo(){
		if(expCount == 1) return Double.NaN;
		
		return mean() - (1.96 * stddev() / Math.sqrt(expCount) );   
	}
	   
	// returns upper bound of the 95% confidence interval
	public double confidenceHi(){
		if(expCount == 1) return Double.NaN;
		
		return mean() + (1.96 * stddev() / Math.sqrt(expCount) );		   
	}
	   
	// test client, described below
	public static void main(String[] args){				
		    if(args.length <2){
		    	throw new IllegalArgumentException("There should be 2 arguments");
		    }
		    
		    int N = 0,T = 0;
		    try {
		        N = Integer.parseInt(args[0]);
		        T = Integer.parseInt(args[1]);
		    } catch (NumberFormatException e) {
		    	throw new IllegalArgumentException("N and T must be an integer");
		    }	    
		   
		    PercolationStats stats = new PercolationStats(N,T);
		    
		    StdOut.print("mean \t\t\t\t\t = " + stats.mean() + "\n");
		    StdOut.print("stddev \t\t\t\t\t = " + stats.stddev() + "\n");
		    StdOut.print("95% confidence interval  = " + stats.confidenceLo() + ", " + stats.confidenceHi());
	}
}

package Hashing;

public class Vector_multiply_bruteForce {
	
	private int N = 4;
	private double[][] a = new double[N][N];	// given 2d array
	private double[] b = new double[N];			// given vector to multiply with	
	private double[] c = new double[N];			// store result of multiplication
	
	public Vector_multiply_bruteForce(){
		// initialize code
	}
	
	// brute force required quadratic running time
	public void multiply(){		
		double sum = 0;		
		for ( int i = 0; i < N; i++){
			sum = 0.0;
			for ( int j = 0; j< N; j++){
				sum += a[i][j] * b[j];
			}
			c[i] = sum;			
		}		
	}
	
}

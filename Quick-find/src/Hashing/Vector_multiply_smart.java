package Hashing;

import java.util.HashMap;

public class Vector_multiply_smart {

	private int N = 100;
	private SparseVector[] a = new SparseVector[N];
	private double[] b = new double[N];
	private double[] c = new double[N];
	
	public Vector_multiply_smart(){
		// initialize code
	}
	
	
	// saves loads of space hence very fast
	// running time is proportional to non zero elements in each row hence almost linear time computation
	public void multiply(){
		
		for ( int i = 0; i < N; i++){
			c[i] = a[i].dot(b);
		}
	}
	
	
	private class SparseVector{
		
		private HashMap<Integer, Double> v;
		
		public SparseVector(){
			v = new HashMap<Integer, Double>();
		}
		
		public void put(int i, double x){
			v.put(i, x);
		}
		
		public double get(int i){
			if (!v.containsKey(i))
				return 0.0;
			else
				return v.get(i);
		}
		
		public Iterable<Integer> indices(){
			return v.keySet();
		}
		
		public double dot(double[] that){
			double sum = 0.0;
			
			for ( int i : indices())
				sum += that[i] * this.get(i);
			return sum;
		}
	}	
}

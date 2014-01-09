
// keys should be immutable

//underflow : throw exception if empty
// overflow : add no arg constructor and resize array

// 

package PriorityQueue;

// implementation for max PQ
public class BinaryHeap_PQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N;
	
	public BinaryHeap_PQ(int capacity){
		pq = (Key[]) new Comparable[capacity+1];
	}	
	
	
	public void sort(){
		
		for(int i=N/2; i>=1; i++){
			sink(i);
		}
		
		while(N>1){
			exch(1,N--);
			sink(1);
		}		
	}
	
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(Key k){
		pq[++N] = k;
		swim(N);
	}
	
	public Key delMax(){
		
		Key max = pq[1];
		exch(1,N--);
		sink(1);
		pq[N+1] = null;
		return max;
	}
	
	private void swim(int k){
		
		while(k>1 && less(k/2,k)){
			exch(k,k/2);
			k=k/2;
		}
	}
	
	private void sink(int k){
		
		while(2*k <=N){
			int j = 2*k;
			if(j<N && less(j,j+1))
				j++;
			if(less(k,j)){
				exch(k,j);
				k=j;
			}
		}
	}
	
	private void exch(int a, int b){
		Key tmp = pq[a];
		pq[a] = pq[b];
		pq[b] = tmp;
	}
	
	private boolean less(int a, int b){
		return pq[a].compareTo(pq[b]) < 0;
	}	
}

package Sort;

import edu.princeton.cs.introcs.StdRandom;

// no extra space hence better than mergesort even though a little more comparisons
	// running time ~= N*logN

// RANDOM shuffle is required and not hence not a stable sort

//how to improve:
	// 1) similar to mergeSort : use insertion sort for smaller sub arrays
	// if (hi <= lo + CUTOFF -1)	Insertion.sort ; return;
	// could delay the insertion sort once at the end


public class QuickSort {

	// use to find the kth top element
	// quick-select takes linear time on average
	public static Comparable select(Comparable[] a, int k){
		
		StdRandom.shuffle(a);
		int lo=0, hi = a.length -1;
	
		// can be done using recursion also
		while(hi > lo){
			
			int j = partition(a, lo, hi);
			
			if( j < k)	
				lo = j+1;
			else if( j > k) 	
				hi = j+1;
			else	
				return a[k];
		}
		return a[k];
	}
		
	
	private static int partition(Comparable[] a, int lo, int hi){
		
		int i=lo, j=hi+1;
		while(true)
		{
			while(less(a[++i], a[lo]))
				if(i==hi)	break;
			
			while(less(a[lo], a[--j]))
				if(j==lo)	break;
			
			if(i>=j)	break;
			exch(a, i, j);
		}		
		exch(a, lo, j);
		return j;
		
	}
	
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		
		if (hi <= lo)	return;
		
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static boolean less(Comparable a, Comparable b){
		return false;		
	}
	
	private static void exch(Comparable[] a, int i, int j){
		
	}
	
	private static boolean isSorted(Comparable[] a, int low, int high){
		return false;
	}	
}

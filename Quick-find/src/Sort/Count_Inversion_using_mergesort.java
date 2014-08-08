package Sort;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

// we use divide and conquer principle

// everything is same as merge sort apart from when merging element from array C into array B 

// the split inversion involving an element Y of the array C are precisely
// the number of elements left in the 1st array B when y is copied to the merged array A

public class Count_Inversion_using_mergesort {	
	
public static int count_inversion(int[] aux, int[] a, int low, int mid, int high, int count){	
		
        // copy all elements from a into aux
		for (int i=low; i<=high; i++){
			aux[i] = a[i];
		}
		
		
		int i=low, j=mid+1;
		for(int k=low; k<=high; k++){
			
			if (i > mid)			a[k] = aux[j++];
			else if (j > high)			a[k] = aux[i++];
			
			else if (aux[j] < aux[i] ){	
				a[k] = aux[j++];
				count += (mid - i + 1);				// only additional piece of code from merge sort 
			}
			else			
				a[k] = aux[i++];
		}
		return count;
	}
	
	public static int sort(int[] aux, int[] a, int low, int high, int count){
		if(high <= low)	return count;		
		
		int mid = low + (high - low)/2;
		count  = sort(aux, a, low, mid, count);
		count = sort(aux, a, mid+1, high, count);
		return count_inversion(aux, a, low, mid, high, count);
	}
	
	
	public static int sort(int[] a){
		int[] aux = new int[a.length];
		return sort(aux, a, 0, a.length-1, 0);
	}
	
	public static void main(String[] args) {
        int[] a = {10, 8, 7, 6, 4, 2, 20, 25, 28, 12, 11, 1, 30};
        
        int count = Count_Inversion_using_mergesort.sort(a);
        
        StdOut.print(count);
    }
	
	
	
	
}

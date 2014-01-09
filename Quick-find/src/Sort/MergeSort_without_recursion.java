package Sort;

public class MergeSort_without_recursion {

	// merge sort without recursion with bottom_up principle
			// so it take lgN passes and each pass having about N compares so total about NlgN comparisons but no resursion
			// sort sub array size 2, then sort subarray size 4 and so on
				// see visualization in coursera to better understand	
		/*public static void bottom_up_sort(Comparable[] a){
			int N = a.length;
			Comparable[] aux = new Comparable[a.length];
			
			for (int sz =0; sz<N; sz = sz+sz){
				for (int lo =0; lo<N-sz; lo += sz + sz){
					merge(aux, a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
				}
			}		
		}*/
	
}

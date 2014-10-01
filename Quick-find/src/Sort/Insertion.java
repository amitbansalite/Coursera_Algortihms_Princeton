package Sort;

//  ~1/4 N^2 compares and ~1/4 N^2 exchanges on average

//  sensitive to input
	// sorted input : n-1 compares and 0 exchanges
	// desc order input : ~ n^2 / 2 compares and n^2 / 2 exchanges


// for partially sorted array, it runs in linear time
	// # of compares = # of exchanges + n-1

public class Insertion {
	
	public static void Sort(Comparable[] a){
		int N = a.length;
		
		for(int i=0; i<N; i++){
			for(int j=i; j>0; j--){				
				if( less(a[j], a[j-1]) )
					exch(a, j , j-1);
			}			
			//assert isSorted(a, 0, i);
		}		
		//assert isSorted(a);
	}
	
	private static boolean less(Comparable a, Comparable b){
		return false;		
	}
	
	private static void exch(Comparable[] a, int i, int j){
		
	}
}

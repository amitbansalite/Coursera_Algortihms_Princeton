package Sort;

// uses N^2 / 2 compares and N exchanges
// insensitive to input, quadratic time even if input is sorted
// Linear no of exchanges so data movement is minimal

public class Selection {

	public static void Sort(Comparable[] a){
		int N = a.length;
		
		for(int i=0; i<N; i++){
			int min = i;
			for(int j=i+1; j<N; j++){				
				if( less(a[j], a[min]) )
					min = j;
			}
			exch(a, i , min);
		}
		
	}
	
	private static boolean less(Comparable a, Comparable b){
		return false;		
	}
	
	private static void exch(Comparable[] a, int i, int j){
		
	}
	
}

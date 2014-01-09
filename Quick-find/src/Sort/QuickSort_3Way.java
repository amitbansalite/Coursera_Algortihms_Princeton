package Sort;

// modified quick sort when input is large and has many duplicates

//running time
		// linear when constant distinct keys
		// N lg N when all distinct


public class QuickSort_3Way {

	public static void sort(Comparable[] a, int lo, int hi){
		
		if( hi <=lo)	
			return;
		
		int lt = lo, gt = hi;
		Comparable v = a[lo];
		
		int i=lo;
		
		while(i <=gt ){
			
			int cmp = a[i].compareTo(v);
			
			if (cmp < 0)		exch(a, lt++, i++);
			else if ( cmp > 0)	exch (a, i, gt--);
			else				i++;			
		}
		
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);	
	}	
	
	private static void exch(Comparable[] a, int m, int n){
		
	}
}

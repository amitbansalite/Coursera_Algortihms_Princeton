package Sort;

// uses insertion sort internally to do h-sort 

//  not much idea about # of exchanges and not much can be said about performance.. 
// it is better than insertion sort.. but not know how much...

// 3x + 1 implementation of Shell sort
public class ShellSort {
	
	public static void Sort(Comparable[] a){
		int N = a.length;
		
		int h = 1;
		while(h < N/3)
			h = 3*h + 1;
		
		while(h >= 1){
			
			for(int i=h; i<N; i++){
				
				for(int j=i; j>=h; j = j-h){
					
					if( less(a[j], a[j-h]) )
						exch(a, j , j-h);
				}			
			}
			
			h = h/3;			
		}			
	}
	
	private static boolean less(Comparable a, Comparable b){
		return false;		
	}
	
	private static void exch(Comparable[] a, int i, int j){
		
	}
}

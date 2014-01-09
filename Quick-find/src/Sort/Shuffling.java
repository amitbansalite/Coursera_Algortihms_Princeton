package Sort;

import edu.princeton.cs.introcs.StdRandom;
// 1) generate a random number for each entry in the array and sort the numbers
	// the result is a shuffled array but the cost is high coz of SORT


// 2) Linear time shuffling : in iteration i, pick integer 0 <= r <i 
	// then swap a[i] and a[r]  

// Knuth shuffling ensures uniformly random array as output
public class Shuffling {

	public static void shuffle(Object[] a){
		
		int N = a.length;
		
		for(int i=0; i<N; i++){
			
			// random number between 0 and i-1
			int r = StdRandom.uniform(i+1);
			exch(a,i,r);
		}
	}	
	
	private static void exch(Object[] a, int i, int j){
		
	}	
}

// shuffling is very very tough eg. to generate a truly random deck of cards by shuffling 
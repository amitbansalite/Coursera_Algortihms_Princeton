package SymbolTables;

// Binary tree where :
	// node contains (lo,hi)
	// left sub tree has all elements less than root(lo)
	// right sub tree has all elements greater than root(lo)
	// every node also contains : max(hi) in sub tree

public class IntervalST<Key extends Comparable<Key>, Value> {
	
	IntervalST(){
		
	}
	
	void put(Key lo, Key hi, Value val){
		
	}
	
	Value get(Key lo, Key hi){
		return null;
	}
	
	void delete(Key lo, Key hi){
		
	}
	
	Iterable<Key> Intersects(Key lo, Key hi){
		return null;
	}
	
	
	// search for an intersecting interval
	int searchIntersectingInterval(Key lo, Key hi){
		return 0;
		
		/*Node x = root;
		
		while(x != null){
			
			if		(x.interval.intersects(lo, hi)) return	x.interval;
			else if (x.left == null)						x = x.right;
			else if (x.left.max < lo)						x = x.right;
			else											x = x.left;
		}
		return null;		*/
	}
	

}

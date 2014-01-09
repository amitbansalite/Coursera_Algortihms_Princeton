import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {	
	private int N;	// no of elements in Queue
	private Item[] s;
	
	public RandomizedQueue(){
		s = (Item[]) new Object[2];
		N = 0;		
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int capacity){
		Item[] copy = (Item[]) new Object[capacity];
		
		for(int i=0; i<N; i++){		
				copy[i] = s[i];	
		}
		s = copy;				
	}
	
	public void enqueue(Item item){
		if(item == null){
			throw new NullPointerException();
		}
		
		if(N == s.length){
			resize(2*s.length);
		}		
		s[N++] = item;		
	}
		
	public Item dequeue(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		
		int random = StdRandom.uniform(N);			
		Item t = s[random];
		s[random] = s[N-1];
		s[--N] = null;
		
		if(N > 2 && N <= s.length/4){
			resize(s.length/2);
		}
		return t;
	}
	
	public Item sample(){		
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		return s[StdRandom.uniform(N)];
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private int x;
		private Item[] copy;

		public ListIterator(){
			x=0;
			copy = (Item[]) new Object[N];
			
			for(int i=0; i<N; i++){
				copy[i] = s[i];
			}
						
			for (int i = 0; i < N; i++) {				
				int r = StdRandom.uniform(i+1);     // between i and N-1
				Item temp = copy[i];
				copy[i] = copy[r];
				copy[r] = temp;
			}		
		}
		
		public boolean hasNext() {
			return x != N;
		}

		public void remove() {
			throw new UnsupportedOperationException ();			
		}

		public Item next() {
			if(!hasNext()){
				throw new NoSuchElementException(); 
			}
			return copy[x++];			
		}
	}
	
	public static void main(String[] args) {
		
		RandomizedQueue<Integer> test = new RandomizedQueue<Integer>();
		int N = 10;
		int copy[] = new int[10];
		for(int i=0; i<10; i++){
			copy[i] = i;;
		}		
		
		for (int i = 0; i < N; i++) {				
			int r = StdRandom.uniform(i);     // between i and N-1
			int temp = copy[i];
			copy[i] = copy[r];
			copy[r] = temp;
		}
		
		StdOut.print("\n iterator loop starting.");
		
		Iterator<Integer> iter1 = test.iterator();
		while(iter1.hasNext()){
			StdOut.print("\n next element is : " + iter1.next());
		}
		
	}
}

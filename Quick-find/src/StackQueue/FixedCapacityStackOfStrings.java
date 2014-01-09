package StackQueue;

public class FixedCapacityStackOfStrings {
	
	private String[] s;
	private int N = 0;
	
	
	FixedCapacityStackOfStrings(int capacity){
			s = new String[capacity];
	}
	
	public void push(String item){
		s[N++] = item;
	}
	
	// to avoid loitering (hold a reference to an object when it is no longer needed)
	public String pop(){		
		
		if(N==0) return "Stack is Empty!";
		
		String item = s[--N];
		s[N] = null;
		return item;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	// re-sizable array stack would look like : 

	private void resize(int capacity){
		String[] copy = new String[capacity];
		
		for(int i=0; i< N; i++){
			copy[i] = s[i];
		}
		s = copy;
	}
	
	public void pushNresize(String item){
		if (N == s.length){
			resize(2 * s.length);
		}
		s[N++] = item;
	}
	
	public String popNshrink(){
		String item = s[--N];
		s[N] = null;
		
		if(N > 0 && N == s.length/4){
			resize(s.length/2);
		}
		
		return item;
	}
	
}

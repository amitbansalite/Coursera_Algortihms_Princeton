package StackQueue;

// refer to the ResizingArrayQueue class in the algs4 library
public class FixedCapacityQueueOfStrings {
	
	private String[] s;
	private int head = -1, tail = 0;
	
	public FixedCapacityQueueOfStrings(int capacity){
		s = new String[capacity];		
	}
	
	boolean isEmpty(){
		return head == -1;
	}
	
	private void resize(int capacity){
		String[] copy = new String[capacity];

		int j=0;
		for(int i=head; i<tail; i++){
			copy[j++] = s[i];			
		}
		head = 0;
		tail = capacity/2 + 1;
	}
	
	public void push(String item){		
		if(tail == s.length + 1){
			resize(2*s.length);
		}	
		
		s[tail++] = item;
		
		if(head == -1){
			head++;
		}
	}
	
	public String pop(){		
		
		if(isEmpty()){
			return "Queue is empty";
		}
		
		String item = s[head];
		s[head] = null;

		if(head + 1 == tail){
			head = -1;
			tail = 0;
		}
		else if( head == s.length - (s.length/4)){
			resize(s.length/2);
		}		
		return item;	
	}	
}

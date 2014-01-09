import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
	private int N;
	private Node first, last;
	
	private class Node{
		Node next;
		Node previous;
		Item item;
	}	
	
	public Deque(){
		N = 0;
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;		
	}
	
	public void addFirst(Item item){		
		if(item == null){
			throw new NullPointerException();
		}
		
		Node newNode = new Node();
		newNode.item = item;
		
		if(isEmpty()){			
			newNode.next = null;
			newNode.previous = null;
			first = newNode;
			last = newNode;					
		}
		else{
			newNode.next = first;
			newNode.previous = null;
			
			first.previous = newNode;			
			first = newNode;
		}		
		N++;
	}
	
	public void addLast(Item item){		
		if(item == null){
			throw new NullPointerException();
		}
		
		Node newNode = new Node();
		newNode.item = item;

		if(isEmpty()){			
			newNode.next = null;
			newNode.previous = null;
			first = newNode;
			last = newNode;					
		}
		else{
			newNode.next = null;
			newNode.previous = last;
			last.next = newNode;
			last = newNode;
		}
		N++;
	}
	
	public Item removeFirst(){
		if(isEmpty())
			throw new NoSuchElementException("Deque is empty!");
		
		Item item = first.item;
		
		if(N==1){
			first = last = null;
		}				
		else{
			first = first.next;
			first.previous = null;
		}
		N--;
		return item;
	}
	
	public Item removeLast(){
		if(isEmpty())
			throw new NoSuchElementException("Deque is empty!");
		
		Item item = last.item;
		if(N==1){
			first = last = null;
		}
		else{
			last = last.previous;
			last.next = null;
		}
		N--;
		return item;
	}	
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		Node current = first;
		
		public boolean hasNext(){
			return current != null;
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
		public Item next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}		
	}
	
	public static void main(String[] args) {
		
		Deque<String> test = new Deque<String>();
		
		StdOut.print("\n is it empty : " + test.isEmpty());
		StdOut.print("\n using for each before entering any elements");
		for(String x : test){
			StdOut.print("\n Inner loop item : " + x);
		}
		
		StdOut.print("\n Starting to insert elements \n");
		test.addLast("third");
		test.addLast("fourth");
		test.addFirst("first");
		test.addFirst("second");		
		test.removeLast();
		test.removeFirst();
		
		StdOut.print("\n is it empty : " + test.isEmpty());
		StdOut.print("\n # of elements : " + test.size());
		
		StdOut.print("\n using iterator \n");		
		Iterator<String> str = test.iterator();
		while(str.hasNext()){
			StdOut.print("\n Next item is : " + str.next());			
		}		
		
		StdOut.print("\n using for each \n");		
		for(String t : test ){			
			StdOut.print("\n Outer loop item : " + t);			
			for(String x : test){
				StdOut.print("\n Inner loop item : " + x);
			}			
		}
	}
}

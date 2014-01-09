package StackQueue;
import java.util.Iterator;

// implementation : Stack(without pop) or Queue (without dequeue)

public class Bag<Item> implements Iterable<Item>{
	
	public Bag(){
		// create an empty bag
	}
	
	public void add(Item x){
		// insert a new item onto bag irrespective or order
	}
	
	public int size(){
		// # of items in bag
		return 0;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

package StackQueue;

public class LinkedQueueOfStrings {

	private Node first, last = null;
	
	private class Node{
		String item;
		Node next;
	}
	
	void enqueue(String item){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
	}
	
	String dequeue(){
		String item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		return item;
	}
	
	boolean isEmpty(){
		return first == null;
	}	
}

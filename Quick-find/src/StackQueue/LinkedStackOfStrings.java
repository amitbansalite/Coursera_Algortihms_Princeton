package StackQueue;

import edu.princeton.cs.introcs.StdOut;

public class LinkedStackOfStrings {
	private Node first = null;
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	// add new element as the 1st node
	public void push(String item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;		
	}
	
	// return the first node
	public String pop(){
		
		if(! isEmpty()){
			String item = first.item;
			Node tmp = first;
			first = first.next;			
			tmp = null;
			return item;			
		}
		
		return "Stack is empty!";		
	}	
	
	public void display()
	{
		Node tmp = first;
		
		while( ! (tmp == null) ){
			StdOut.print(tmp.item);
			tmp = tmp.next;
		}
	}
}

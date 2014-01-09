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
	
	public void push(String item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;		
	}
	
	public String pop(){
		
		if(! isEmpty()){
			String item = first.item;
			first = first.next;
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

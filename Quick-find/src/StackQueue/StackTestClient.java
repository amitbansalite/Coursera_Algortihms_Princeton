package StackQueue;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class StackTestClient {

	public static void main(String[] args) {
		
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		
		StdOut.print("\n To begin with, stack is empty : " + stack.isEmpty());
		StdOut.print("\n Popping from an empty stack : " + stack.pop());
		
		while(!StdIn.isEmpty()){
			
			StdOut.print("\n");
			stack.display();
			
			String s = StdIn.readString();
			if(s.equals("-"))
				StdOut.print("\n" + stack.pop());
			else
				stack.push(s);
		}			
	}
}

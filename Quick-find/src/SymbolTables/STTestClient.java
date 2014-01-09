package SymbolTables;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class STTestClient {

	public static void main(String[] args){
	
		ST_API<String, Integer> st = new ST_API<String, Integer>();
	
		for(int i=0; ! StdIn.isEmpty(); i++){
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		for(String s : st.keys()){
			StdOut.print(s + " " + st.get(s));
		}
	}	
}

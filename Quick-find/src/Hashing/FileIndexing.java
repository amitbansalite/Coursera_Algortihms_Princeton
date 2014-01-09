package Hashing;

import java.io.File;

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class FileIndexing {

	public static void main(String[] args){
		ST<String, SET<File>> st = new ST<String, SET<File>>();
		
		for (String fileName : args){
			File file = new File(fileName);
			In in = new In(file);
			
			while (! in.isEmpty()){
				
				String word = in.readString();
				if (!st.contains(word))
					st.put(word, new SET<File>());
				SET<File> set = st.get(word);
				set.add(file);				
			}
		}
		
		while (! StdIn.isEmpty()){
			
			String query = StdIn.readString();
			StdOut.println(st.get(query));
		}		
	}	
}

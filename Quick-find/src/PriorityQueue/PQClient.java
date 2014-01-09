package PriorityQueue;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Transaction;
import edu.princeton.cs.introcs.StdIn;


public class PQClient {

	public static void main(String[] args){
		
		MinPQ<Transaction> pq = new MinPQ<Transaction>();
		int M = 10;
		
		while(StdIn.hasNextLine()){
			
			String line = StdIn.readLine();
			Transaction item = new Transaction(line);
			pq.insert(item);
			
			if(pq.size() > M)
				pq.delMin();			
		}		
	}	
}

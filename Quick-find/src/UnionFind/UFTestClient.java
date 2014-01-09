package UnionFind;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class UFTestClient {

	public static void main(String[] args) {
			
		
		StdOut.println("Hello program starting");
		
		int n = StdIn.readInt();
		//QuckFindUF uf = new QuckFindUF(n);
		
		//QuickUnion uf = new QuickUnion(n);
		
		QuickUnionW uf = new QuickUnionW(n);
		
		//QucikUnion_PathCompression uf = new QucikUnion_PathCompression(n);
		
		uf.display();
		
		while(!StdIn.isEmpty()){
			
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if(! uf.connected(p, q)){
				uf.union(p, q);
				StdOut.println(p + " " + q);
			}
			else{
				StdOut.println(p + "&" + q + "Already Connected");
			}
		}
		
		uf.display();
	}
}

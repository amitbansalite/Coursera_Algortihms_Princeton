/****************************************************************************
 *  Compilation:  javac QuickFindUF.java
 *  Execution:  java QuickFindUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Quick-find algorithm.
 *
 ****************************************************************************/

public class QuickFindUF {
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components

    // Create an empty union-find data structure with N isolated components 0 through N-1.
    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    // Return the number of components.
    public int count() {
        return count;
    }

    // Return the component identifier for component containing p.
    public int find(int p) {
        return id[p];
    }

    // Are objects p and q in the same component?
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // Merge components containing p and q.
    public void union(int p, int q) {
        if (connected(p, q)) return;
        int pid = id[p];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = id[q]; 
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1),
        // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}

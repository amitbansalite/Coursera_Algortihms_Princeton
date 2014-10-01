/****************************************************************************
 *  Compilation:  javac QuickUnionUF.java
 *  Execution:  java QuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Quick-union algorithm.
 *
 ****************************************************************************/

public class QuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    // create an empty union-find data structure with N isolated components 0 through N-1
    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // Return the number of components.
    public int count() {
        return count;
    }

    // Return the component identifier for component containing p.
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    // Are objects p and q in the same component?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Merge components containing p and q.
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j; 
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);

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

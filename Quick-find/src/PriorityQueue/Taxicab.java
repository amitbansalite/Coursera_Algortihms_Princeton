package PriorityQueue;

/*did not understand the solution yet?????????????
 * 
 * one explanation can be found here : https://class.coursera.org/algs4partI-003/forum/thread?thread_id=1240
*/

/*************************************************************************
 *  Compilation:  javac Taxicab.java
 *  Execution:    java Taxicab N
 * 
 *  Find all nontrivial integer solutions to a^3 + b^3 = c^3 + d^3 where
 *  a, b, c, and d are between 0 and N. By nontrivial, we mean
 *  a <= b, c <= d, and (a, b) != (c, d).
 *
 *  % java Taxicab 11
 *
 *  % java Taxicab 12
 *  1729 = 9^3 + 10^3 = 1^3 + 12^3
 *
 *  % java Taxicab 1000
 *  1729 = 1^3 + 12^3 = 9^3 + 10^3
 *  4104 = 2^3 + 16^3 = 9^3 + 15^3
 *  13832 = 2^3 + 24^3 = 18^3 + 20^3
 *  20683 = 10^3 + 27^3 = 19^3 + 24^3
 *  32832 = 18^3 + 30^3 = 4^3 + 32^3
 *  ...
 *  87539319 = 255^3 + 414^3 = 167^3 + 436^3 = 228^3 + 423^3
 *  ...
 *  1477354411 = 802^3 + 987^3 = 883^3 + 924^3
 *
 *************************************************************************/

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.introcs.StdOut;

public class Taxicab implements Comparable<Taxicab> {
    private final long sum;
    private final int i;
    private final int j;

    // create a new tuple (i, j, i^3 + j^3)
    public Taxicab(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(Taxicab that) {
        if      (this.sum < that.sum) return -1;
        else if (this.sum > that.sum) return +1;
        else                          return  0;
    }

    public String toString() {
        return i + "^3 + " + j + "^3";
    }


    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        // initialize priority queue
        MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
        for (int i = 1; i <= N; i++) {
            pq.insert(new Taxicab(i, i));
        }

        // enumerate sums in ascending order, look for repeated sums
        int run = 1;
        Taxicab prev = new Taxicab(0, 0);   // sentinel
        while (!pq.isEmpty()) {
            Taxicab s = pq.delMin();

            // sum is same as previous one

            if (prev.sum == s.sum) {
                run++;
                if (run == 2) StdOut.print(prev.sum + " = " + prev);
                StdOut.print(" = " + s);
            }
            else {
                if (run > 1) StdOut.println();
                run = 1;
            }
            prev = s;

            if (s.j < N) pq.insert(new Taxicab(s.i, s.j + 1));
        }
        if (run > 1) StdOut.println();
    }

}
